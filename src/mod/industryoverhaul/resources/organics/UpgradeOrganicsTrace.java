package mod.industryoverhaul.resources.organics;

import java.util.Arrays;
import java.util.List;

import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import mod.industryoverhaul.ConditionModifierIndustry;


public class UpgradeOrganicsTrace extends ConditionModifierIndustry {


    protected List<String> getPreventAnyConditions(){
        return Arrays.asList(
            Conditions.ORGANICS_TRACE,
            Conditions.ORGANICS_COMMON,
            Conditions.ORGANICS_ABUNDANT,
            Conditions.ORGANICS_PLENTIFUL
        );
    }

    protected List<String> getAddedConditions(){
        return Arrays.asList(Conditions.VOLATILES_TRACE);
    }
}
