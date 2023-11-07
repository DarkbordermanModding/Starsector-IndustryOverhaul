package mod.industryoverhaul.planet.niko_MPC.spyarrays;

import java.util.Arrays;
import java.util.List;

import mod.industryoverhaul.ConditionModifierIndustry;

public class AddDerelictSpyArrays extends ConditionModifierIndustry{

    protected List<String> getPreventAnyConditions(){
        return Arrays.asList("niko_MPC_spyArrays");
    }

    protected List<String> getAddedConditions(){
        return Arrays.asList("niko_MPC_spyArrays");
    }
}
