package mod.industryoverhaul.planet.HMI.polity;

import java.util.Arrays;
import java.util.List;

import mod.industryoverhaul.ConditionModifierIndustry;

public class RemovePolity extends ConditionModifierIndustry{

    protected List<String> getRequiredAnyConditions(){
        return Arrays.asList(
            "distantpolity",
            "hardpolity"
        );
    }

    protected List<String> getRemoveConditions(){
        return Arrays.asList(
            "distantpolity",
            "hardpolity"
        );
    }
}
