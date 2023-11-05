package mod.industryoverhaul.organics;

import java.util.Arrays;
import java.util.List;

import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import mod.industryoverhaul.ConditionModifierIndustry;


public class UpgradeOrganicsAbundant extends ConditionModifierIndustry {

    protected List<String> getRequiredConditions(){
        return Arrays.asList(Conditions.ORGANICS_COMMON);
    }

    protected List<String> getRemoveConditions(){
        return Arrays.asList(Conditions.ORGANICS_COMMON);
    }

    protected List<String> getAddedConditions(){
        return Arrays.asList(Conditions.ORGANICS_ABUNDANT);
    }
}
