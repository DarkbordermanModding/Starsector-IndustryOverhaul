package mod.industryoverhaul.planet.RAT.engineeredutopia;

import java.util.Arrays;
import java.util.List;

import mod.industryoverhaul.ConditionModifierIndustry;

public class RemoveEngineeredUtopia extends ConditionModifierIndustry{

    protected List<String> getRequiredAnyConditions(){
        return Arrays.asList("rat_engineered_utopia");
    }

    protected List<String> getRemoveConditions(){
        return Arrays.asList("rat_engineered_utopia");
    }
}
