package mod.industryoverhaul.planet.biosphere;

import java.util.Arrays;
import java.util.List;

import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import mod.industryoverhaul.ConditionModifierIndustry;

public class AddInimicalBiosphere extends ConditionModifierIndustry {

	protected List<String> getPreventAnyConditions(){
        return Arrays.asList(
			Conditions.NO_ATMOSPHERE,
			Conditions.DENSE_ATMOSPHERE,
			Conditions.THIN_ATMOSPHERE,
			Conditions.TOXIC_ATMOSPHERE,
            Conditions.INIMICAL_BIOSPHERE
        );
    }

	protected List<String> getAddedConditions(){
        return Arrays.asList(Conditions.INIMICAL_BIOSPHERE);
    }
}
