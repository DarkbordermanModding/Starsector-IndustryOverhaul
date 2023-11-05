package mod.industryoverhaul.volatiles;

import java.util.Arrays;
import java.util.List;

import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import mod.industryoverhaul.ConditionModifierIndustry;


public class VolatilesTrace extends ConditionModifierIndustry {

    protected List<String> getPreventAnyConditions(){
        return Arrays.asList(
            Conditions.VOLATILES_TRACE,
            Conditions.VOLATILES_DIFFUSE,
            Conditions.VOLATILES_ABUNDANT,
            Conditions.VOLATILES_PLENTIFUL
        );
    }

    protected List<String> getAddedConditions(){
        return Arrays.asList(Conditions.VOLATILES_TRACE);
    }
}
