package mod.industryoverhaul.planet.temperature;

import java.util.Arrays;
import java.util.List;

import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import mod.industryoverhaul.ConditionModifierIndustry;
import mod.industryoverhaul.Utilities;

public class AddVeryHot extends ConditionModifierIndustry {

    protected List<String> getPreventAnyConditions(){
        return Arrays.asList(
            Conditions.HABITABLE,
            Conditions.VERY_HOT,
            Conditions.HOT,
            Conditions.COLD,
            Conditions.VERY_COLD
        );
    }

    protected List<String> getAddedConditions(){
        return Arrays.asList(Conditions.VERY_HOT);
    }

    protected void buildingFinished() {
        if(
            !market.hasCondition(Conditions.TOXIC_ATMOSPHERE) ||
            !market.hasCondition(Conditions.IRRADIATED)
        ){
            Utilities.changePlanetSpec(market, "lava");
        }
        super.buildingFinished();
    }
}
