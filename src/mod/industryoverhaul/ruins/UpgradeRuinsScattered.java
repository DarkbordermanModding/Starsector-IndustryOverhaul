package mod.industryoverhaul.ruins;

import java.util.Arrays;
import java.util.List;

import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import mod.industryoverhaul.ConditionModifierIndustry;


public class UpgradeRuinsScattered extends ConditionModifierIndustry {

    protected List<String> getPreventAnyConditions(){
        return Arrays.asList(
            Conditions.RUINS_SCATTERED,
            Conditions.RUINS_WIDESPREAD,
            Conditions.RUINS_EXTENSIVE,
            Conditions.RUINS_VAST
        );
    }

    protected List<String> getAddedConditions(){
        return Arrays.asList(Conditions.RUINS_SCATTERED);
    }
}
