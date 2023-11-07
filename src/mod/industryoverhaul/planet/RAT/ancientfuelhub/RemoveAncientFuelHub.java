package mod.industryoverhaul.planet.RAT.ancientfuelhub;

import java.util.Arrays;
import java.util.List;

import mod.industryoverhaul.ConditionModifierIndustry;

public class RemoveAncientFuelHub extends ConditionModifierIndustry{

    protected List<String> getRequiredAnyConditions(){
        return Arrays.asList("rat_ancient_fuel_hub");
    }

    protected List<String> getRemoveConditions(){
        return Arrays.asList("rat_ancient_fuel_hub");
    }
}
