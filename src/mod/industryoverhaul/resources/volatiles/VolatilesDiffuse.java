package mod.industryoverhaul.resources.volatiles;

import java.util.Arrays;
import java.util.List;

import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import mod.industryoverhaul.ConditionModifierIndustry;


public class VolatilesDiffuse extends ConditionModifierIndustry {

    protected List<String> getRequiredConditions(){
        return Arrays.asList(Conditions.VOLATILES_TRACE);
    }

    protected List<String> getRemoveConditions(){
        return Arrays.asList(Conditions.VOLATILES_TRACE);
    }

    protected List<String> getAddedConditions(){
        return Arrays.asList(Conditions.VOLATILES_DIFFUSE);
    }
}
