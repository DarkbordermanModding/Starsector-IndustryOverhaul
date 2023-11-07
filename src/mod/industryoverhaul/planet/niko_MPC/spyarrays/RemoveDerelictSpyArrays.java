package mod.industryoverhaul.planet.niko_MPC.spyarrays;

import java.util.Arrays;
import java.util.List;

import mod.industryoverhaul.ConditionModifierIndustry;

public class RemoveDerelictSpyArrays extends ConditionModifierIndustry{

    protected List<String> getRequiredAnyConditions(){
        return Arrays.asList("niko_MPC_spyArrays");
    }

    protected List<String> getRemoveConditions(){
        return Arrays.asList("niko_MPC_spyArrays");
    }
}
