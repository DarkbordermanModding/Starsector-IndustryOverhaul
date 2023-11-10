package mod.industryoverhaul.planet.irradiated;

import java.util.Arrays;
import java.util.List;

import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import mod.industryoverhaul.ConditionModifierIndustry;
import mod.industryoverhaul.Utilities;

public class RemoveIrradiated extends ConditionModifierIndustry{

    protected List<String> getRequiredAnyConditions(){
        return Arrays.asList(Conditions.IRRADIATED);
    }

    protected List<String> getRemoveConditions(){
        return Arrays.asList(Conditions.IRRADIATED);
    }

    protected void buildingFinished() {
        if(market.hasCondition(Conditions.TOXIC_ATMOSPHERE)){
            Utilities.changePlanetSpec(market, "toxic");
        } else{
            // Change toxic planet to barren planet
            Utilities.changePlanetSpec(market, "barren");
        }
        super.buildingFinished();
    }
}
