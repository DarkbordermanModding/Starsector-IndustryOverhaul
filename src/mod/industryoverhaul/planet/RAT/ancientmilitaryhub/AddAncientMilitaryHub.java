package mod.industryoverhaul.planet.RAT.ancientmilitaryhub;

import java.util.Arrays;
import java.util.List;

import mod.industryoverhaul.ConditionModifierIndustry;

public class AddAncientMilitaryHub extends ConditionModifierIndustry{

    protected List<String> getPreventAnyConditions(){
        return Arrays.asList("rat_ancient_military_hub");
    }

    protected List<String> getAddedConditions(){
        return Arrays.asList("rat_ancient_military_hub");
    }
}
