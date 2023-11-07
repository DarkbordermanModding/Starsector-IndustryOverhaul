package mod.industryoverhaul.planet.RAT.ancientmegacities;

import java.util.Arrays;
import java.util.List;

import mod.industryoverhaul.ConditionModifierIndustry;

public class RemoveAncientMegacities extends ConditionModifierIndustry{

    protected List<String> getRequiredAnyConditions(){
        return Arrays.asList("rat_ancient_megacities");
    }

    protected List<String> getRemoveConditions(){
        return Arrays.asList("rat_ancient_megacities");
    }
}
