package mod.industryoverhaul.planet.RAT.militarycore;

import java.util.Arrays;
import java.util.List;

import mod.industryoverhaul.ConditionModifierIndustry;

public class AddMilitaryCore extends ConditionModifierIndustry{

    protected List<String> getPreventAnyConditions(){
        return Arrays.asList("rat_rampant_military_core");
    }

    protected List<String> getAddedConditions(){
        return Arrays.asList("rat_rampant_military_core");
    }
}
