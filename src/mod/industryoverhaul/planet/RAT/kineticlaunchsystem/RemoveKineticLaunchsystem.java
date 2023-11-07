package mod.industryoverhaul.planet.RAT.kineticlaunchsystem;

import java.util.Arrays;
import java.util.List;

import mod.industryoverhaul.ConditionModifierIndustry;

public class RemoveKineticLaunchsystem extends ConditionModifierIndustry{

    protected List<String> getRequiredAnyConditions(){
        return Arrays.asList("rat_kinetic_launchsystem");
    }

    protected List<String> getRemoveConditions(){
        return Arrays.asList("rat_kinetic_launchsystem");
    }
}
