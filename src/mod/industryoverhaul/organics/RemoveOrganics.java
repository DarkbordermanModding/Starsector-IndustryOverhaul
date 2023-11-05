package mod.industryoverhaul.organics;

import java.util.Arrays;
import java.util.List;

import com.fs.starfarer.api.impl.campaign.ids.Conditions;

public class RemoveOrganics {

    protected List<String> getRequiredAnyConditions(){
        return Arrays.asList(
            Conditions.ORGANICS_TRACE,
            Conditions.ORGANICS_COMMON,
            Conditions.ORGANICS_ABUNDANT,
            Conditions.ORGANICS_PLENTIFUL
        );
    }

    protected List<String> getRemoveConditions(){
        return Arrays.asList(
            Conditions.ORGANICS_TRACE,
            Conditions.ORGANICS_COMMON,
            Conditions.ORGANICS_ABUNDANT,
            Conditions.ORGANICS_PLENTIFUL
        );
    }
}
