package mod.industryoverhaul.ore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import mod.industryoverhaul.ConditionModifierIndustry;


public class OreAbundant extends ConditionModifierIndustry {

    protected List<String> getRequiredConditions(){
        return Arrays.asList(Conditions.ORE_MODERATE);
    }
}
