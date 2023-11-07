package mod.industryoverhaul.planet.RAT.engineeredutopia;

import java.util.Arrays;
import java.util.List;

import mod.industryoverhaul.ConditionModifierIndustry;

public class AddEngineeredUtopia extends ConditionModifierIndustry{

    protected List<String> getPreventAnyConditions(){
        return Arrays.asList("rat_engineered_utopia");
    }

    protected List<String> getAddedConditions(){
        return Arrays.asList("rat_engineered_utopia");
    }
}
