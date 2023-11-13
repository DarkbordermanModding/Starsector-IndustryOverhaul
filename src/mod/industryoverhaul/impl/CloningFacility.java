package mod.industryoverhaul.impl;

import java.awt.Color;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.econ.MarketAPI;
import com.fs.starfarer.api.campaign.econ.MarketImmigrationModifier;
import com.fs.starfarer.api.impl.campaign.econ.impl.BaseIndustry;
import com.fs.starfarer.api.impl.campaign.ids.Commodities;
import com.fs.starfarer.api.impl.campaign.population.PopulationComposition;
import com.fs.starfarer.api.ui.TooltipMakerAPI;
import com.fs.starfarer.api.util.Misc;

public class CloningFacility extends BaseIndustry implements MarketImmigrationModifier{

    public static float IMMIGRATION_MULPILIER = 2000;

    @Override
    public boolean canImprove() { return true; }

    @Override
    public boolean showWhenUnavailable(){return false;}

    @Override
    public boolean isAvailableToBuild() {
        return market.getSize() < Global.getSettings().getInt("maxColonySize");
    }

    @Override
    protected boolean hasPostDemandSection(boolean hasDemand, IndustryTooltipMode mode) {
        return isFunctional();
    }

    public void apply() {
        super.apply(true);

        int size = market.getSize();

        demand(Commodities.FOOD, size);
        demand(Commodities.ORGANICS, size);
        demand(Commodities.CREW, size);
        demand(Commodities.SUPPLIES, size);

        if (isImproved()) IMMIGRATION_MULPILIER = 3;
        else IMMIGRATION_MULPILIER = 2000;

        if (!isFunctional()) {
            supply.clear();
            unapply();
        }

        if(market.getSize() == Global.getSettings().getInt("maxColonySize")){
            setHidden(true);
            upkeep.modifyMult(getModId(), 0f);
            demand(Commodities.FOOD, 0);
            demand(Commodities.ORGANICS, 0);
            demand(Commodities.CREW, 0);
            demand(Commodities.SUPPLIES, 0);
            unapply();
        }
    }

    @Override
    public void unapply() {
        super.unapply();
    }

    public void modifyIncoming(MarketAPI market, PopulationComposition incoming) {
        float immigrationModifier = 1 / 0.5f;
        double bonus = Math.pow(immigrationModifier, market.getSize());
        // Approximately (2.66 * multiplier)%  growth rate
        incoming.getWeight().modifyFlat(
            getModId(),
            (float)bonus * IMMIGRATION_MULPILIER,
            getNameForModifier()
        );
    }

    @Override
    protected void addPostDemandSection(TooltipMakerAPI tooltip, boolean hasDemand, IndustryTooltipMode mode) {
        if (mode != IndustryTooltipMode.NORMAL || isFunctional()) {
            Color h = Misc.getHighlightColor();
            float opad = 10f;
            double bonus = 2.66 * IMMIGRATION_MULPILIER;
            tooltip.addPara("Population growth: %s", opad, h, "+" + (float)bonus + "%");
        }
    }

    public void addImproveDesc(TooltipMakerAPI info, ImprovementDescriptionMode mode) {
        float opad = 10f;
        Color highlight = Misc.getHighlightColor();

        String str = "2.66";

        info.addPara("Incrase additional %s%% growth rate.", 0f, highlight, str);

        info.addSpacer(opad);
        super.addImproveDesc(info, mode);
    }
}
