package mod.industryoverhaul.resources.farmland;

import java.util.Arrays;
import java.util.List;

import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import mod.industryoverhaul.ConditionModifierIndustry;


public class FarmlandBountiful extends ConditionModifierIndustry {

    protected List<String> getRequiredConditions(){
        return Arrays.asList(Conditions.FARMLAND_RICH);
    }

    protected List<String> getRemoveConditions(){
        return Arrays.asList(Conditions.FARMLAND_RICH);
    }

    protected List<String> getAddedConditions(){
        return Arrays.asList(Conditions.FARMLAND_BOUNTIFUL);
    }
}
