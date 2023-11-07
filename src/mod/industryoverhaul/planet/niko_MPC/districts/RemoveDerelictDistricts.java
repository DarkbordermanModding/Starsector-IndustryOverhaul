package mod.industryoverhaul.planet.niko_MPC.districts;

import java.util.Arrays;
import java.util.List;

import mod.industryoverhaul.ConditionModifierIndustry;

public class RemoveDerelictDistricts extends ConditionModifierIndustry{

    protected List<String> getRequiredAnyConditions(){
        return Arrays.asList("niko_MPC_ftcDistricts");
    }

    protected List<String> getRemoveConditions(){
        return Arrays.asList("niko_MPC_ftcDistricts");
    }
}
