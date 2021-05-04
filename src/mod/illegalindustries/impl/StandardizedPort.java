package mod.illegalindustries.impl;

import java.awt.Color;
import java.util.Map;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.econ.CommoditySpecAPI;
import com.fs.starfarer.api.campaign.econ.MarketAPI;
import com.fs.starfarer.api.campaign.econ.MarketImmigrationModifier;
import com.fs.starfarer.api.combat.MutableStat.StatMod;
import com.fs.starfarer.api.impl.campaign.ids.Commodities;
import com.fs.starfarer.api.impl.campaign.ids.Stats;
import com.fs.starfarer.api.impl.campaign.population.PopulationComposition;
import com.fs.starfarer.api.ui.TooltipMakerAPI;
import com.fs.starfarer.api.util.Misc;
import com.fs.starfarer.api.util.Pair;

import mod.illegalindustries.Utilities;

import com.fs.starfarer.api.impl.campaign.econ.impl.BaseIndustry;



public class StandardizedPort extends BaseIndustry implements MarketImmigrationModifier {

	public static float OFFICER_PROB_MOD = 0.1f;
	public static float OFFICER_PROB_MOD_MEGA = 0.2f;

	public static float UPKEEP_MULT_PER_DEFICIT = 0.1f;

	public static final float BASE_ACCESSIBILITY = 0.5f;
	public static final float MEGAPORT_ACCESSIBILITY = 0.8f;

	public static final float ALPHA_CORE_ACCESSIBILITY = 0.2f;
	public static final float IMPROVE_ACCESSIBILITY = 0.2f;

	public void apply() {
		super.apply(true);

		int size = market.getSize();

		boolean megaport = true;

		demand(Commodities.FUEL, size);
		demand(Commodities.SUPPLIES, size);
		demand(Commodities.SHIPS, size);

		supply(Commodities.CREW, size + 1);
		supply(Commodities.MARINES, size);

		String desc = getNameForModifier();

		Pair<String, Integer> deficit = getUpkeepAffectingDeficit();

		if (deficit.two > 0) {
			float loss = getUpkeepPenalty(deficit);
			getUpkeep().modifyMult("deficit", 1f + loss, getDeficitText(deficit.one));
		} else {
			getUpkeep().unmodifyMult("deficit");
		}

		market.setHasSpaceport(true);

		float total = 0f;
		for(Map.Entry<String, StatMod> entry: market.getAccessibilityMod().getFlatBonuses().entrySet()) {
			if(!entry.getKey().equals("standardizedport")){
				total += entry.getValue().value;
			}
		}
		market.getAccessibilityMod().modifyFlat(getModId(0), Utilities.getStandardizedPortAccessibility() - total, desc);
		market.getStats().getDynamic().getMod(Stats.COMBAT_FLEET_SIZE_MULT).modifyMult(getModId(0), 2f, desc);

		float officerProb = OFFICER_PROB_MOD;
		if (megaport) officerProb = OFFICER_PROB_MOD_MEGA;
		market.getStats().getDynamic().getMod(Stats.OFFICER_PROB_MOD).modifyFlat(getModId(0), officerProb);

		if (!isFunctional()) {
			supply.clear();
			unapply();
			market.setHasSpaceport(true);
		}
	}

	@Override
	public void unapply() {
		super.unapply();

		market.setHasSpaceport(false);
		market.getAccessibilityMod().unmodifyFlat(getModId(0));
		market.getAccessibilityMod().unmodifyFlat(getModId(1));
		market.getAccessibilityMod().unmodifyFlat(getModId(2));

		market.getStats().getDynamic().getMod(Stats.OFFICER_PROB_MOD).unmodifyFlat(getModId(0));
		market.getStats().getDynamic().getMod(Stats.COMBAT_FLEET_SIZE_MULT).unmodifyMult(getModId(0));
	}

	protected float getUpkeepPenalty(Pair<String, Integer> deficit) {
		float loss = deficit.two * UPKEEP_MULT_PER_DEFICIT;
		if (loss < 0) loss = 0;
		return loss;
	}

	protected Pair<String, Integer> getUpkeepAffectingDeficit() {
		return getMaxDeficit(Commodities.FUEL, Commodities.SUPPLIES, Commodities.SHIPS);
	}

	protected boolean hasPostDemandSection(boolean hasDemand, IndustryTooltipMode mode) {
		return mode != IndustryTooltipMode.NORMAL || isFunctional();
	}

	@Override
	protected void addPostDemandSection(TooltipMakerAPI tooltip, boolean hasDemand, IndustryTooltipMode mode) {
		if (mode != IndustryTooltipMode.NORMAL || isFunctional()) {
			Color h = Misc.getHighlightColor();
			float opad = 10f;
			float bonus = getPopulationGrowthBonus();

			tooltip.addPara("Population growth: %s", opad, h, "+" + (int)bonus);
			tooltip.addPara("Fleet size: %s", opad, h, "x" + 2f);
		}
	}

	public float getPopulationGrowthBonus() {
		return market.getSize();
	}

	public void modifyIncoming(MarketAPI market, PopulationComposition incoming) {
		float bonus = getPopulationGrowthBonus();
		incoming.getWeight().modifyFlat(getModId(), bonus, getNameForModifier());
	}

	@Override
	protected void applyAlphaCoreModifiers() {
		market.getAccessibilityMod().modifyFlat(getModId(2), ALPHA_CORE_ACCESSIBILITY, "Alpha core (" + getNameForModifier() + ")");
	}

	@Override
	protected void applyNoAICoreModifiers() {
		market.getAccessibilityMod().unmodifyFlat(getModId(2));
	}

	@Override
	protected void applyAlphaCoreSupplyAndDemandModifiers() {
		demandReduction.modifyFlat(getModId(0), DEMAND_REDUCTION, "Alpha core");
	}

	protected void addAlphaCoreDescription(TooltipMakerAPI tooltip, AICoreDescriptionMode mode) {
		float opad = 10f;
		Color highlight = Misc.getHighlightColor();

		String pre = "Alpha-level AI core currently assigned. ";
		if (mode == AICoreDescriptionMode.MANAGE_CORE_DIALOG_LIST || mode == AICoreDescriptionMode.INDUSTRY_TOOLTIP) {
			pre = "Alpha-level AI core. ";
		}
		float a = ALPHA_CORE_ACCESSIBILITY;
		String aStr = "" + (int)Math.round(a * 100f) + "%";

		if (mode == AICoreDescriptionMode.INDUSTRY_TOOLTIP) {
			CommoditySpecAPI coreSpec = Global.getSettings().getCommoditySpec(aiCoreId);
			TooltipMakerAPI text = tooltip.beginImageWithText(coreSpec.getIconName(), 48);
			text.addPara(pre + "Reduces upkeep cost by %s. Reduces demand by %s unit. " +
					"Increases accessibility by %s.", 0f, highlight,
					"" + (int)((1f - UPKEEP_MULT) * 100f) + "%", "" + DEMAND_REDUCTION,
					aStr);
			tooltip.addImageWithText(opad);
			return;
		}

		tooltip.addPara(pre + "Reduces upkeep cost by %s. Reduces demand by %s unit. " +
				"Increases accessibility by %s.", opad, highlight,
				"" + (int)((1f - UPKEEP_MULT) * 100f) + "%", "" + DEMAND_REDUCTION,
				aStr);
	}

	@Override
	public boolean canImprove() {
		return false;
	}
}
