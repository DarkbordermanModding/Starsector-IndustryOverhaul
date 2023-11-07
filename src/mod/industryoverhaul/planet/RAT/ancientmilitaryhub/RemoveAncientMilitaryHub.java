package mod.industryoverhaul.planet.RAT.ancientmilitaryhub;

import java.util.Arrays;
import java.util.List;

import mod.industryoverhaul.ConditionModifierIndustry;

public class RemoveAncientMilitaryHub extends ConditionModifierIndustry{

    protected List<String> getRequiredAnyConditions(){
        return Arrays.asList("rat_ancient_military_hub");
    }

    protected List<String> getRemoveConditions(){
        return Arrays.asList("rat_ancient_military_hub");
    }
}
