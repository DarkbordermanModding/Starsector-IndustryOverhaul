package mod.industryoverhaul.planet.pollution;

import java.util.Arrays;
import java.util.List;

import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import mod.industryoverhaul.ConditionModifierIndustry;

public class RemovePollution extends ConditionModifierIndustry{

    protected List<String> getRequiredAnyConditions(){
        return Arrays.asList(Conditions.POLLUTION);
    }

    protected List<String> getRemoveConditions(){
        return Arrays.asList(Conditions.POLLUTION);
    }
}
