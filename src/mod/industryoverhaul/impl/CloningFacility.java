package mod.industryoverhaul.impl;

import com.fs.starfarer.api.campaign.econ.MarketAPI;
import com.fs.starfarer.api.campaign.econ.MarketImmigrationModifier;
import com.fs.starfarer.api.impl.campaign.econ.impl.BaseIndustry;
import com.fs.starfarer.api.impl.campaign.ids.Commodities;
import com.fs.starfarer.api.impl.campaign.population.PopulationComposition;

public class CloningFacility extends BaseIndustry implements MarketImmigrationModifier{

    public static int IMMIGRATION_MULPILIER = 2;

    @Override
    public boolean canImprove() { return true; }

    public void apply() {
        super.apply(true);

        int size = market.getSize();

        demand(Commodities.FOOD, size);
        demand(Commodities.ORGANICS, size);
        demand(Commodities.CREW, size);
        demand(Commodities.SUPPLIES, size);

        if (isImproved()) IMMIGRATION_MULPILIER = 3;
        else IMMIGRATION_MULPILIER = 2;

        if (!isFunctional()) {
            supply.clear();
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
}
