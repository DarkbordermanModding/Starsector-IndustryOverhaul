package mod.industryoverhaul.impl;

import com.fs.starfarer.api.campaign.econ.MarketAPI;
import com.fs.starfarer.api.campaign.econ.MarketImmigrationModifier;
import com.fs.starfarer.api.impl.campaign.econ.impl.BaseIndustry;
import com.fs.starfarer.api.impl.campaign.ids.Commodities;
import com.fs.starfarer.api.impl.campaign.population.PopulationComposition;

public class CloningFacility extends BaseIndustry implements MarketImmigrationModifier{

    public void apply() {
        super.apply(true);

        int size = market.getSize();

        demand(Commodities.FUEL, size);
        demand(Commodities.SUPPLIES, size);

        supply(Commodities.CREW, size + 1);

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
         // Approximately 2.66% growth rate
        double bonus = Math.pow(immigrationModifier, market.getSize());
        incoming.getWeight().modifyFlat(getModId(), (float)bonus, getNameForModifier());
    }

    @Override
    protected boolean canImproveToIncreaseProduction() {
        return true;
    }
}
