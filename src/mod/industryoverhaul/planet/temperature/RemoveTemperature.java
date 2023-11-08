package mod.industryoverhaul.planet.temperature;

import java.util.Arrays;
import java.util.List;

import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import mod.industryoverhaul.ConditionModifierIndustry;
import mod.industryoverhaul.Utilities;

public class RemoveTemperature extends ConditionModifierIndustry{

    protected List<String> getRequiredAnyConditions(){
        return Arrays.asList(
            Conditions.COLD,
            Conditions.HOT,
            Conditions.VERY_COLD,
            Conditions.VERY_HOT
        );
    }

    protected List<String> getRemoveConditions(){
        return Arrays.asList(
            Conditions.COLD,
            Conditions.HOT,
            Conditions.VERY_COLD,
            Conditions.VERY_HOT
        );
    }

    protected void buildingFinished() {
        if(market.hasCondition(Conditions.HABITABLE)){
            Utilities.changePlanetSpec(market, "terran");
        }else{
            Utilities.changePlanetSpec(market, "barren");
        }
        super.buildingFinished();
    }
}
