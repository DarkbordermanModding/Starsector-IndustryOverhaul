package mod.industryoverhaul.planet.RAT.ancientindustries;

import java.util.Arrays;
import java.util.List;

import mod.industryoverhaul.ConditionModifierIndustry;

public class RemoveAncientIndustries extends ConditionModifierIndustry{

    protected List<String> getRequiredAnyConditions(){
        return Arrays.asList("rat_ancient_industries");
    }

    protected List<String> getRemoveConditions(){
        return Arrays.asList("rat_ancient_industries");
    }
}
