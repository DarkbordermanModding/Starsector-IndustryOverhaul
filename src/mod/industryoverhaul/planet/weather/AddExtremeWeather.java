package mod.industryoverhaul.planet.weather;

import java.util.Arrays;
import java.util.List;

import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import mod.industryoverhaul.ConditionModifierIndustry;

public class AddExtremeWeather extends ConditionModifierIndustry{

    protected List<String> getPreventAnyConditions(){
        return Arrays.asList(
            Conditions.MILD_CLIMATE,
            Conditions.EXTREME_WEATHER
        );
    }

    protected List<String> getAddedConditions(){
        return Arrays.asList(Conditions.EXTREME_WEATHER);
    }
}
