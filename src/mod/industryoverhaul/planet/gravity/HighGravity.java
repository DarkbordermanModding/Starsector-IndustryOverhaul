package mod.industryoverhaul.planet.gravity;

import java.util.Arrays;
import java.util.List;

import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import mod.industryoverhaul.ConditionModifierIndustry;

public class HighGravity extends ConditionModifierIndustry{
    protected List<String> getPreventAnyConditions(){
        return Arrays.asList(
            Conditions.LOW_GRAVITY,
            Conditions.HIGH_GRAVITY
        );
    }

    protected List<String> getAddedConditions(){
        return Arrays.asList(Conditions.HIGH_GRAVITY);
    }
}
