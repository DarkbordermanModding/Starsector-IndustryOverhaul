package mod.industryoverhaul.planet.RAT.kineticlaunchsystem;

import java.util.Arrays;
import java.util.List;

import mod.industryoverhaul.ConditionModifierIndustry;

public class AddKineticLaunchsystem extends ConditionModifierIndustry{

    protected List<String> getPreventAnyConditions(){
        return Arrays.asList("rat_kinetic_launchsystem");
    }

    protected List<String> getAddedConditions(){
        return Arrays.asList("rat_kinetic_launchsystem");
    }
}
