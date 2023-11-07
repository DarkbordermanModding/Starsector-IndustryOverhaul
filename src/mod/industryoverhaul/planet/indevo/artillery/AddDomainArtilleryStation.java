package mod.industryoverhaul.planet.indevo.artillery;

import java.util.Arrays;
import java.util.List;

import mod.industryoverhaul.ConditionModifierIndustry;

public class AddDomainArtilleryStation extends ConditionModifierIndustry{

    @Override
    protected List<String> getPreventAnyConditions() {
        return Arrays.asList("IndEvo_ArtilleryStationCondition");
    }

    protected List<String> getAddedConditions(){
        return Arrays.asList("IndEvo_ArtilleryStationCondition");
    }
}
