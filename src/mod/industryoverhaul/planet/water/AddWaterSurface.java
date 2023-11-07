package mod.industryoverhaul.planet.water;

import java.util.Arrays;
import java.util.List;

import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import mod.industryoverhaul.ConditionModifierIndustry;
import mod.industryoverhaul.Utilities;

public class AddWaterSurface extends ConditionModifierIndustry{

    protected List<String> getRequiredConditions(){
        return Arrays.asList(Conditions.HABITABLE);
    }

    protected List<String> getPreventAnyConditions(){
        return Arrays.asList(Conditions.WATER_SURFACE);
    }

    protected List<String> getAddedConditions(){
        return Arrays.asList(Conditions.WATER_SURFACE);
    }

    protected void buildingFinished() {
        Utilities.changePlanetSpec(market, "water");
        super.buildingFinished();
    }
}
