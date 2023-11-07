package mod.industryoverhaul.planet.RAT.bionicplantlife;

import java.util.Arrays;
import java.util.List;

import mod.industryoverhaul.ConditionModifierIndustry;

public class AddBionicPlantlife extends ConditionModifierIndustry{

    protected List<String> getPreventAnyConditions(){
        return Arrays.asList("rat_bionic_plantlife");
    }

    protected List<String> getAddedConditions(){
        return Arrays.asList("rat_bionic_plantlife");
    }
}
