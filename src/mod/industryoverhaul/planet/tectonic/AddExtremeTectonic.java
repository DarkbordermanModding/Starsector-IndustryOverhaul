package mod.industryoverhaul.planet.tectonic;

import java.util.Arrays;
import java.util.List;

import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import mod.industryoverhaul.ConditionModifierIndustry;

public class AddExtremeTectonic extends ConditionModifierIndustry {

    protected List<String> getPreventAnyConditions(){
        return Arrays.asList(
            Conditions.TECTONIC_ACTIVITY,
            Conditions.EXTREME_TECTONIC_ACTIVITY
        );
    }

    protected List<String> getAddedConditions(){
        return Arrays.asList(Conditions.EXTREME_TECTONIC_ACTIVITY);
    }
}
