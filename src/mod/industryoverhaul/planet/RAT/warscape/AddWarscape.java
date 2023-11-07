package mod.industryoverhaul.planet.RAT.warscape;

import java.util.Arrays;
import java.util.List;

import mod.industryoverhaul.ConditionModifierIndustry;

public class AddWarscape extends ConditionModifierIndustry{

    protected List<String> getPreventAnyConditions(){
        return Arrays.asList("rat_warscape");
    }

    protected List<String> getAddedConditions(){
        return Arrays.asList("rat_warscape");
    }
}
