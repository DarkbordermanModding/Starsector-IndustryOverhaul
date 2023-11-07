package mod.industryoverhaul.planet.RAT.defensivedrones;

import java.util.Arrays;
import java.util.List;

import mod.industryoverhaul.ConditionModifierIndustry;

public class RemoveDefensiveDrones extends ConditionModifierIndustry{

    protected List<String> getRequiredAnyConditions(){
        return Arrays.asList("rat_defensive_drones");
    }

    protected List<String> getRemoveConditions(){
        return Arrays.asList("rat_defensive_drones");
    }
}
