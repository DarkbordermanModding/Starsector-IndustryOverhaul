package mod.industryoverhaul.rareore;

import java.util.Arrays;
import java.util.List;

import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import mod.industryoverhaul.ConditionModifierIndustry;


public class RareOreModerate extends ConditionModifierIndustry {

    protected List<String> getRequiredConditions(){
        return Arrays.asList(Conditions.RARE_ORE_SPARSE);
    }

    protected List<String> getRemoveConditions(){
        return Arrays.asList(Conditions.RARE_ORE_SPARSE);
    }

    protected List<String> getAddedConditions(){
        return Arrays.asList(Conditions.RARE_ORE_MODERATE);
    }
}
