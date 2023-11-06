package mod.industryoverhaul.resources.rareore;

import java.util.Arrays;
import java.util.List;

import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import mod.industryoverhaul.ConditionModifierIndustry;


public class RemoveRareOre extends ConditionModifierIndustry {

    protected List<String> getRequiredAnyConditions(){
        return Arrays.asList(
            Conditions.RARE_ORE_SPARSE,
            Conditions.RARE_ORE_MODERATE,
            Conditions.RARE_ORE_ABUNDANT,
            Conditions.RARE_ORE_RICH,
            Conditions.RARE_ORE_ULTRARICH
        );
    }

    protected List<String> getRemoveConditions(){
        return Arrays.asList(
            Conditions.RARE_ORE_SPARSE,
            Conditions.RARE_ORE_MODERATE,
            Conditions.RARE_ORE_ABUNDANT,
            Conditions.RARE_ORE_RICH,
            Conditions.RARE_ORE_ULTRARICH
        );
    }
}
