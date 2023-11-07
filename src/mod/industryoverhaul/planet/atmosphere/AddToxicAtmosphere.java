package mod.industryoverhaul.planet.atmosphere;

import java.util.Arrays;
import java.util.List;

import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import mod.industryoverhaul.ConditionModifierIndustry;
import mod.industryoverhaul.Utilities;

public class AddToxicAtmosphere extends ConditionModifierIndustry {

    protected List<String> getPreventAnyConditions(){
        return Arrays.asList(
            Conditions.NO_ATMOSPHERE,
            Conditions.THIN_ATMOSPHERE,
            Conditions.TOXIC_ATMOSPHERE,
            Conditions.DENSE_ATMOSPHERE
        );
    }

    protected List<String> getAddedConditions(){
        return Arrays.asList(Conditions.TOXIC_ATMOSPHERE);
    }

    protected void buildingFinished() {
        if(market.hasCondition(Conditions.IRRADIATED)){
            Utilities.changePlanetSpec(market, "irradiated");
        } else{
            // Change toxic planet to barren planet
            Utilities.changePlanetSpec(market, "barren");
        }
        super.buildingFinished();
    }
}
