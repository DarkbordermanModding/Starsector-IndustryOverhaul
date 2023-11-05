package mod.industryoverhaul.ruins;

import java.util.Arrays;
import java.util.List;

import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import mod.industryoverhaul.ConditionModifierIndustry;


public class UpgradeRuinsVast extends ConditionModifierIndustry {

    protected List<String> getRequiredConditions(){
        return Arrays.asList(Conditions.RUINS_EXTENSIVE);
    }

    protected List<String> getRemoveConditions(){
        return Arrays.asList(Conditions.RUINS_EXTENSIVE);
    }

    protected List<String> getAddedConditions(){
        return Arrays.asList(Conditions.RUINS_VAST);
    }
}
