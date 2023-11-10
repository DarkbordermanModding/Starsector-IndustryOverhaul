package mod.industryoverhaul.planet.irradiated;

import java.util.Arrays;
import java.util.List;

import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import mod.industryoverhaul.ConditionModifierIndustry;
import mod.industryoverhaul.Utilities;

public class AddIrradiated extends ConditionModifierIndustry {

    protected List<String> getPreventAnyConditions(){
        return Arrays.asList(
            Conditions.HABITABLE,
            Conditions.IRRADIATED
        );
    }

    protected List<String> getAddedConditions(){
        return Arrays.asList(Conditions.IRRADIATED);
    }

    protected void buildingFinished() {
        Utilities.changePlanetSpec(market, "irradiated");
        super.buildingFinished();
    }
}
