package mod.industryoverhaul.planet.niko_MPC.districts;

import java.util.Arrays;
import java.util.List;

import mod.industryoverhaul.ConditionModifierIndustry;

public class AddDerelictDistricts extends ConditionModifierIndustry{

    protected List<String> getPreventAnyConditions(){
        return Arrays.asList("niko_MPC_ftcDistricts");
    }

    protected List<String> getAddedConditions(){
        return Arrays.asList("niko_MPC_ftcDistricts");
    }
}
