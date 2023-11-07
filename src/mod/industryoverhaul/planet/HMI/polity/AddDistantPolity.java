package mod.industryoverhaul.planet.HMI.polity;

import java.util.Arrays;
import java.util.List;

import mod.industryoverhaul.ConditionModifierIndustry;

public class AddDistantPolity extends ConditionModifierIndustry{

    @Override
    protected List<String> getPreventAnyConditions() {
        return Arrays.asList("distantpolity");
    }

    protected List<String> getAddedConditions(){
        return Arrays.asList("distantpolity");
    }
}
