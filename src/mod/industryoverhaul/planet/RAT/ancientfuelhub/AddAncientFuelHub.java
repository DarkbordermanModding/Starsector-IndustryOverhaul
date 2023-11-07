package mod.industryoverhaul.planet.RAT.ancientfuelhub;

import java.util.Arrays;
import java.util.List;

import mod.industryoverhaul.ConditionModifierIndustry;

public class AddAncientFuelHub extends ConditionModifierIndustry{

    protected List<String> getPreventAnyConditions(){
        return Arrays.asList("rat_ancient_fuel_hub");
    }

    protected List<String> getAddedConditions(){
        return Arrays.asList("rat_ancient_fuel_hub");
    }
}
