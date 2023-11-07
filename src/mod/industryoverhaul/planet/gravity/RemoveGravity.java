package mod.industryoverhaul.planet.gravity;

import java.util.Arrays;
import java.util.List;

import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import mod.industryoverhaul.ConditionModifierIndustry;
import mod.industryoverhaul.Utilities;

public class RemoveGravity extends ConditionModifierIndustry{

    protected List<String> getRequiredAnyConditions(){
        return Arrays.asList(
            Conditions.LOW_GRAVITY,
            Conditions.HIGH_GRAVITY
        );
    }

    protected List<String> getRemoveConditions(){
        return Arrays.asList(
            Conditions.LOW_GRAVITY,
            Conditions.HIGH_GRAVITY
        );
    }

    protected void buildingFinished() {
        if(market.hasCondition(Conditions.IRRADIATED)){
            Utilities.changePlanetSpec(market, "irradiated");
        }else if(market.hasCondition(Conditions.TOXIC_ATMOSPHERE)){
            Utilities.changePlanetSpec(market, "toxic");
        }
        super.buildingFinished();
    }
}
