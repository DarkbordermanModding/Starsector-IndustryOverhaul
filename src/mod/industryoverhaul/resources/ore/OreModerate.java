package mod.industryoverhaul.resources.ore;

import java.util.Arrays;
import java.util.List;

import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import mod.industryoverhaul.ConditionModifierIndustry;


public class OreModerate extends ConditionModifierIndustry {

    protected List<String> getRequiredConditions(){
        return Arrays.asList(Conditions.ORE_SPARSE);
    }

    protected List<String> getRemoveConditions(){
        return Arrays.asList(Conditions.ORE_SPARSE);
    }

    protected List<String> getAddedConditions(){
        return Arrays.asList(Conditions.ORE_MODERATE);
    }
}
