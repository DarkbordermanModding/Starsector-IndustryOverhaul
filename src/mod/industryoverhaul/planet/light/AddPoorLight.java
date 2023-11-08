package mod.industryoverhaul.planet.light;

import java.util.Arrays;
import java.util.List;

import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import mod.industryoverhaul.ConditionModifierIndustry;

public class AddPoorLight extends ConditionModifierIndustry {

    protected List<String> getPreventAnyConditions(){
        return Arrays.asList(
            Conditions.POOR_LIGHT,
            Conditions.DARK,
            Conditions.HABITABLE
        );
    }

    protected List<String> getAddedConditions(){
        return Arrays.asList(Conditions.POOR_LIGHT);
    }
}
