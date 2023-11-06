package mod.industryoverhaul.resources.farmland;

import java.util.Arrays;
import java.util.List;

import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import mod.industryoverhaul.ConditionModifierIndustry;


public class FarmlandAdequate extends ConditionModifierIndustry {

    protected List<String> getRequiredConditions(){
        return Arrays.asList(Conditions.FARMLAND_POOR);
    }

    protected List<String> getRemoveConditions(){
        return Arrays.asList(Conditions.FARMLAND_POOR);
    }

    protected List<String> getAddedConditions(){
        return Arrays.asList(Conditions.FARMLAND_ADEQUATE);
    }
}
