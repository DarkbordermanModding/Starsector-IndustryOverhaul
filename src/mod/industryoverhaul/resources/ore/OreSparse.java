package mod.industryoverhaul.resources.ore;

import java.util.Arrays;
import java.util.List;

import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import mod.industryoverhaul.ConditionModifierIndustry;


public class OreSparse extends ConditionModifierIndustry {

    protected List<String> getPreventAnyConditions(){
        return Arrays.asList(
            Conditions.ORE_SPARSE,
            Conditions.ORE_MODERATE,
            Conditions.ORE_ABUNDANT,
            Conditions.ORE_RICH,
            Conditions.ORE_ULTRARICH
        );
    }

    protected List<String> getAddedConditions(){
        return Arrays.asList(Conditions.ORE_SPARSE);
    }
}
