package mod.industryoverhaul.planet.RAT.ancientmegacities;

import java.util.Arrays;
import java.util.List;

import mod.industryoverhaul.ConditionModifierIndustry;

public class AddAncientMegacities extends ConditionModifierIndustry{

    protected List<String> getPreventAnyConditions(){
        return Arrays.asList("rat_ancient_megacities");
    }

    protected List<String> getAddedConditions(){
        return Arrays.asList("rat_ancient_megacities");
    }
}
