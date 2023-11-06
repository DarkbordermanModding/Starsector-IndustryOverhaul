package mod.industryoverhaul.resources.rareore;

import java.util.Arrays;
import java.util.List;

import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import mod.industryoverhaul.ConditionModifierIndustry;


public class RareOreRich extends ConditionModifierIndustry {

    protected List<String> getRequiredConditions(){
        return Arrays.asList(Conditions.RARE_ORE_ABUNDANT);
    }

    protected List<String> getRemoveConditions(){
        return Arrays.asList(Conditions.RARE_ORE_ABUNDANT);
    }

    protected List<String> getAddedConditions(){
        return Arrays.asList(Conditions.RARE_ORE_RICH);
    }
}
