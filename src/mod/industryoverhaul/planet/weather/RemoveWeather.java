package mod.industryoverhaul.planet.weather;

import java.util.Arrays;
import java.util.List;

import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import mod.industryoverhaul.ConditionModifierIndustry;

public class RemoveWeather extends ConditionModifierIndustry{

    protected List<String> getRequiredAnyConditions(){
        return Arrays.asList(
            Conditions.EXTREME_WEATHER,
            Conditions.MILD_CLIMATE
        );
    }

    protected List<String> getRemoveConditions(){
        return Arrays.asList(
            Conditions.EXTREME_WEATHER,
            Conditions.MILD_CLIMATE
        );
    }
}
