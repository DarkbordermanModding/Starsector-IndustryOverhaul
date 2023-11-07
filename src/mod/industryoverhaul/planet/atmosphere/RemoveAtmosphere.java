package mod.industryoverhaul.planet.atmosphere;

import java.util.Arrays;
import java.util.List;

import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import mod.industryoverhaul.ConditionModifierIndustry;

public class RemoveAtmosphere extends ConditionModifierIndustry{

    protected List<String> getRequiredAnyConditions(){
        return Arrays.asList(
            Conditions.DENSE_ATMOSPHERE,
            Conditions.NO_ATMOSPHERE,
            Conditions.THIN_ATMOSPHERE,
            Conditions.TOXIC_ATMOSPHERE
        );
    }

    protected List<String> getRemoveConditions(){
        return Arrays.asList(
            Conditions.DENSE_ATMOSPHERE,
            Conditions.NO_ATMOSPHERE,
            Conditions.THIN_ATMOSPHERE,
            Conditions.TOXIC_ATMOSPHERE
        );
    }
}
