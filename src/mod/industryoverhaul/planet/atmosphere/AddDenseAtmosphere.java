package mod.industryoverhaul.planet.atmosphere;

import java.util.Arrays;
import java.util.List;

import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import mod.industryoverhaul.ConditionModifierIndustry;

public class AddDenseAtmosphere extends ConditionModifierIndustry {

    protected List<String> getPreventAnyConditions(){
        return Arrays.asList(
            Conditions.NO_ATMOSPHERE,
            Conditions.THIN_ATMOSPHERE,
            Conditions.TOXIC_ATMOSPHERE,
            Conditions.DENSE_ATMOSPHERE,
            Conditions.HABITABLE
        );
    }

    protected List<String> getAddedConditions(){
        return Arrays.asList(Conditions.DENSE_ATMOSPHERE);
    }
}
