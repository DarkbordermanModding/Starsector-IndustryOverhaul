package mod.industryoverhaul.planet.light;

import java.util.Arrays;
import java.util.List;

import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import mod.industryoverhaul.ConditionModifierIndustry;

public class RemoveLight extends ConditionModifierIndustry{

    protected List<String> getRequiredAnyConditions(){
        return Arrays.asList(
            Conditions.POOR_LIGHT,
            Conditions.DARK
        );
    }

    protected List<String> getRemoveConditions(){
        return Arrays.asList(
            Conditions.POOR_LIGHT,
            Conditions.DARK
        );
    }
}
