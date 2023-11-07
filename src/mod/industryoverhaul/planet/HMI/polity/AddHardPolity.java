package mod.industryoverhaul.planet.HMI.polity;

import java.util.Arrays;
import java.util.List;

import mod.industryoverhaul.ConditionModifierIndustry;

public class AddHardPolity extends ConditionModifierIndustry{

    protected List<String> getRequiredConditions(){
        return Arrays.asList("distantpolity");
    }

    protected List<String> getRemoveConditions(){
        return Arrays.asList("distantpolity");
    }

    protected List<String> getAddedConditions(){
        return Arrays.asList("hardpolity");
    }
}
