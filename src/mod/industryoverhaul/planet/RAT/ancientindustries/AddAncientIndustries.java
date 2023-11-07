package mod.industryoverhaul.planet.RAT.ancientindustries;

import java.util.Arrays;
import java.util.List;

import mod.industryoverhaul.ConditionModifierIndustry;

public class AddAncientIndustries extends ConditionModifierIndustry{

    protected List<String> getPreventAnyConditions(){
        return Arrays.asList("rat_ancient_industries");
    }

    protected List<String> getAddedConditions(){
        return Arrays.asList("rat_ancient_industries");
    }
}
