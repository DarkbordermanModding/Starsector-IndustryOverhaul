package mod.industryoverhaul.planet.niko_MPC.satellites;

import java.util.Arrays;
import java.util.List;

import mod.industryoverhaul.ConditionModifierIndustry;

public class RemoveDerelictSatellites extends ConditionModifierIndustry{

    protected List<String> getRequiredAnyConditions(){
        return Arrays.asList("niko_MPC_antiAsteroidSatellites_derelict");
    }

    protected List<String> getRemoveConditions(){
        return Arrays.asList("niko_MPC_antiAsteroidSatellites_derelict");
    }
}
