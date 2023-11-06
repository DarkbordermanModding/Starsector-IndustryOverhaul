package mod.industryoverhaul.resources.organics;

import java.util.Arrays;
import java.util.List;

import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import mod.industryoverhaul.ConditionModifierIndustry;


public class UpgradeOrganicsCommon extends ConditionModifierIndustry {

    protected List<String> getRequiredConditions(){
        return Arrays.asList(Conditions.ORGANICS_TRACE);
    }

    protected List<String> getRemoveConditions(){
        return Arrays.asList(Conditions.ORGANICS_TRACE);
    }

    protected List<String> getAddedConditions(){
        return Arrays.asList(Conditions.ORGANICS_COMMON);
    }
}
