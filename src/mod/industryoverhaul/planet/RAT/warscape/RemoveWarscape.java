package mod.industryoverhaul.planet.RAT.warscape;

import java.util.Arrays;
import java.util.List;

import mod.industryoverhaul.ConditionModifierIndustry;

public class RemoveWarscape extends ConditionModifierIndustry{

    protected List<String> getRequiredAnyConditions(){
        return Arrays.asList("rat_warscape");
    }

    protected List<String> getRemoveConditions(){
        return Arrays.asList("rat_warscape");
    }
}
