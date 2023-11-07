package mod.industryoverhaul.planet.RAT.defensivedrones;

import java.util.Arrays;
import java.util.List;

import mod.industryoverhaul.ConditionModifierIndustry;

public class AddDefensiveDrones extends ConditionModifierIndustry{

    protected List<String> getPreventAnyConditions(){
        return Arrays.asList("rat_defensive_drones");
    }

    protected List<String> getAddedConditions(){
        return Arrays.asList("rat_defensive_drones");
    }
}
