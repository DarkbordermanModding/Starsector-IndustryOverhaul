package mod.industryoverhaul.planet.habitable;

import java.util.Arrays;
import java.util.List;

import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import mod.industryoverhaul.ConditionModifierIndustry;
import mod.industryoverhaul.Utilities;

public class RemoveHabitable extends ConditionModifierIndustry{

    protected List<String> getRequiredAnyConditions(){
        return Arrays.asList(
            Conditions.HABITABLE
        );
    }

    protected List<String> getRemoveConditions(){
        return Arrays.asList(
            Conditions.HABITABLE
        );
    }

    protected void buildingFinished() {
        Utilities.changePlanetSpec(market, "barren");
        super.buildingFinished();
    }
}
