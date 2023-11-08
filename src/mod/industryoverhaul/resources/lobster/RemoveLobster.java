package mod.industryoverhaul.resources.lobster;

import java.util.Arrays;
import java.util.List;

import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import mod.industryoverhaul.ConditionModifierIndustry;


public class RemoveLobster extends ConditionModifierIndustry {

    protected List<String> getRequiredConditions(){
        return Arrays.asList(Conditions.VOLTURNIAN_LOBSTER_PENS);
    }

    protected List<String> getRemoveConditions(){
        return Arrays.asList(Conditions.VOLTURNIAN_LOBSTER_PENS);
    }
}
