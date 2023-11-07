package mod.industryoverhaul.planet.indevo.minefield;

import java.util.Arrays;
import java.util.List;

import mod.industryoverhaul.ConditionModifierIndustry;

public class AddSelfReplicatingMinefield extends ConditionModifierIndustry{

    @Override
    protected List<String> getPreventAnyConditions() {
        return Arrays.asList("IndEvo_mineFieldCondition");
    }

    protected List<String> getAddedConditions(){
        return Arrays.asList("IndEvo_mineFieldCondition");
    }
}
