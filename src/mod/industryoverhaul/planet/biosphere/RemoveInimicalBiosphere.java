package mod.industryoverhaul.planet.biosphere;

import java.util.Arrays;
import java.util.List;

import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import mod.industryoverhaul.ConditionModifierIndustry;

public class RemoveInimicalBiosphere extends ConditionModifierIndustry{

    protected List<String> getRequiredAnyConditions(){
        return Arrays.asList(Conditions.INIMICAL_BIOSPHERE);
    }

    protected List<String> getRemoveConditions(){
        return Arrays.asList(Conditions.INIMICAL_BIOSPHERE);
    }
}
