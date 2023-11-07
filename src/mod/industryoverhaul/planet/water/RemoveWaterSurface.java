package mod.industryoverhaul.planet.water;

import java.util.Arrays;
import java.util.List;

import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import mod.industryoverhaul.ConditionModifierIndustry;
import mod.industryoverhaul.Utilities;

public class RemoveWaterSurface extends ConditionModifierIndustry{

    protected List<String> getRequiredAnyConditions(){
        return Arrays.asList(Conditions.WATER_SURFACE);
    }

    protected List<String> getRemoveConditions(){
        return Arrays.asList(Conditions.WATER_SURFACE);
    }

    protected void buildingFinished() {
        if(market.hasCondition(Conditions.HOT)){
            Utilities.changePlanetSpec(market, "arid");
        }else if(market.hasCondition(Conditions.COLD)){
            Utilities.changePlanetSpec(market, "tundra");
        }else if(market.hasCondition(Conditions.INIMICAL_BIOSPHERE)){
            Utilities.changePlanetSpec(market, "jungle");
        }else {
            Utilities.changePlanetSpec(market, "terran");
        }
        super.buildingFinished();
    }
}
