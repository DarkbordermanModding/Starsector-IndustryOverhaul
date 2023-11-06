package mod.industryoverhaul.resources.volatiles;

import java.util.Arrays;
import java.util.List;

import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import mod.industryoverhaul.ConditionModifierIndustry;

public class RemoveVolatiles extends ConditionModifierIndustry {

    protected List<String> getRequiredAnyConditions(){
        return Arrays.asList(
            Conditions.VOLATILES_TRACE,
            Conditions.VOLATILES_DIFFUSE,
            Conditions.VOLATILES_ABUNDANT,
            Conditions.VOLATILES_PLENTIFUL
        );
    }

    protected List<String> getRemoveConditions(){
        return Arrays.asList(
            Conditions.VOLATILES_TRACE,
            Conditions.VOLATILES_DIFFUSE,
            Conditions.VOLATILES_ABUNDANT,
            Conditions.VOLATILES_PLENTIFUL
        );
    }
}
