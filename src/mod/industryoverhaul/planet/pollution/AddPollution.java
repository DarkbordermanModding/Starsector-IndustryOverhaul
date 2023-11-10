package mod.industryoverhaul.planet.pollution;

import java.util.Arrays;
import java.util.List;

import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import mod.industryoverhaul.ConditionModifierIndustry;

public class AddPollution extends ConditionModifierIndustry {

    protected List<String> getPreventAnyConditions(){
        return Arrays.asList(Conditions.POLLUTION);
    }

    protected List<String> getAddedConditions(){
        return Arrays.asList(Conditions.POLLUTION);
    }
}
