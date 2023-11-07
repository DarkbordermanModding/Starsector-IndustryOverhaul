package mod.industryoverhaul.planet.niko_MPC.satellites;

import java.util.Arrays;
import java.util.List;

import mod.industryoverhaul.ConditionModifierIndustry;

public class AddDerelictSatellites extends ConditionModifierIndustry{

    protected List<String> getPreventAnyConditions(){
        return Arrays.asList("niko_MPC_antiAsteroidSatellites_derelict");
    }

    protected List<String> getAddedConditions(){
        return Arrays.asList("niko_MPC_antiAsteroidSatellites_derelict");
    }
}
