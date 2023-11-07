package mod.industryoverhaul.planet.civil;

import java.util.Arrays;
import java.util.List;

import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import mod.industryoverhaul.ConditionModifierIndustry;

public class AddDecivilized extends ConditionModifierIndustry{

    protected List<String> getRequiredAnyConditions(){
        return Arrays.asList(
            Conditions.RUINS_SCATTERED,
            Conditions.RUINS_WIDESPREAD,
            Conditions.RUINS_EXTENSIVE,
            Conditions.RUINS_VAST
        );
    }

    protected List<String> getPreventAnyConditions(){
        return Arrays.asList(
            Conditions.DECIVILIZED,
            Conditions.DECIVILIZED_SUBPOP
        );
    }

    protected List<String> getAddedConditions(){
        return Arrays.asList(Conditions.DECIVILIZED);
    }
}
