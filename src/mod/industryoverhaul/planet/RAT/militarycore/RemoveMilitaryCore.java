package mod.industryoverhaul.planet.RAT.militarycore;

import java.util.Arrays;
import java.util.List;

import mod.industryoverhaul.ConditionModifierIndustry;

public class RemoveMilitaryCore extends ConditionModifierIndustry{

    protected List<String> getRequiredAnyConditions(){
        return Arrays.asList("rat_rampant_military_core");
    }

    protected List<String> getRemoveConditions(){
        return Arrays.asList("rat_rampant_military_core");
    }
}
