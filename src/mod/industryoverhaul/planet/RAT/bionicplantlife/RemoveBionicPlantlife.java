package mod.industryoverhaul.planet.RAT.bionicplantlife;

import java.util.Arrays;
import java.util.List;

import mod.industryoverhaul.ConditionModifierIndustry;

public class RemoveBionicPlantlife extends ConditionModifierIndustry{

    protected List<String> getRequiredAnyConditions(){
        return Arrays.asList("rat_bionic_plantlife");
    }

    protected List<String> getRemoveConditions(){
        return Arrays.asList("rat_bionic_plantlife");
    }
}
