package mod.industryoverhaul.resources.farmland;

import java.util.Arrays;
import java.util.List;

import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import mod.industryoverhaul.ConditionModifierIndustry;


public class RemoveFarmland extends ConditionModifierIndustry {

    protected List<String> getRequiredAnyConditions(){
        return Arrays.asList(
            Conditions.FARMLAND_POOR,
            Conditions.FARMLAND_ADEQUATE,
            Conditions.FARMLAND_RICH,
            Conditions.FARMLAND_BOUNTIFUL
        );
    }

    protected List<String> getRemoveConditions(){
        return Arrays.asList(
            Conditions.FARMLAND_POOR,
            Conditions.FARMLAND_ADEQUATE,
            Conditions.FARMLAND_RICH,
            Conditions.FARMLAND_BOUNTIFUL
        );
    }
}
