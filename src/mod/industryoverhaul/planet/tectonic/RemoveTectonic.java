package mod.industryoverhaul.planet.tectonic;

import java.util.Arrays;
import java.util.List;

import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import mod.industryoverhaul.ConditionModifierIndustry;

public class RemoveTectonic extends ConditionModifierIndustry{

    protected List<String> getRequiredAnyConditions(){
        return Arrays.asList(
            Conditions.TECTONIC_ACTIVITY,
            Conditions.EXTREME_TECTONIC_ACTIVITY
        );
    }

    protected List<String> getRemoveConditions(){
        return Arrays.asList(
            Conditions.TECTONIC_ACTIVITY,
            Conditions.EXTREME_TECTONIC_ACTIVITY
        );
    }
}
