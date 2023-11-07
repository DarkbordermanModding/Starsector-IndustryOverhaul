package mod.industryoverhaul.planet.civil;

import java.util.Arrays;
import java.util.List;

import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import mod.industryoverhaul.ConditionModifierIndustry;

public class RemoveDecivilized extends ConditionModifierIndustry{

    protected List<String> getRequiredAnyConditions(){
        return Arrays.asList(Conditions.DECIVILIZED);
    }

    protected List<String> getRemoveConditions(){
        return Arrays.asList(Conditions.DECIVILIZED);
    }
}
