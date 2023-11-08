package mod.industryoverhaul.planet.habitable;

import java.util.Arrays;
import java.util.List;

import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import mod.industryoverhaul.ConditionModifierIndustry;
import mod.industryoverhaul.Utilities;

public class AddHabitable extends ConditionModifierIndustry {

    protected List<String> getPreventAnyConditions(){
        return Arrays.asList(
            Conditions.VERY_HOT,
            Conditions.VERY_COLD,
            Conditions.IRRADIATED,
            Conditions.NO_ATMOSPHERE,
            Conditions.DENSE_ATMOSPHERE,
            Conditions.THIN_ATMOSPHERE,
            Conditions.TOXIC_ATMOSPHERE,
            Conditions.POOR_LIGHT,  // Too far from star
            Conditions.DARK,  // Too far from star
            Conditions.METEOR_IMPACTS,  // No atmosphere
            Conditions.HABITABLE
        );
    }

    protected List<String> getAddedConditions(){
        return Arrays.asList(Conditions.HABITABLE);
    }

    protected void buildingFinished() {
        if(market.hasCondition(Conditions.HOT)){
            Utilities.changePlanetSpec(market, "arid");
        }else if(market.hasCondition(Conditions.COLD)){
            Utilities.changePlanetSpec(market, "tundra");
        }else if(market.hasCondition(Conditions.INIMICAL_BIOSPHERE)){
            Utilities.changePlanetSpec(market, "jungle");
        }else {
            Utilities.changePlanetSpec(market, "terran");
        }
        super.buildingFinished();
    }
}
