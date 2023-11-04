package mod.industryoverhaul.ore;

import java.util.Arrays;
import java.util.List;

import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import mod.industryoverhaul.ConditionModifierIndustry;


public class OreUltraRich extends ConditionModifierIndustry {

    protected List<String> getRequiredConditions(){
        return Arrays.asList(Conditions.ORE_RICH);
    }

    protected List<String> getRemoveConditions(){
        return Arrays.asList(Conditions.ORE_RICH);
    }

    protected List<String> getAddedConditions(){
        return Arrays.asList(Conditions.ORE_ULTRARICH);
    }
}
