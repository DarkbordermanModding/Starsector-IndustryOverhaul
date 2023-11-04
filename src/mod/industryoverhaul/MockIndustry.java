package mod.industryoverhaul;

import com.fs.starfarer.api.impl.campaign.econ.impl.BaseIndustry;

// Used to display variable selection for industries
public class MockIndustry extends BaseIndustry{
	@Override
	public void apply() {
		super.apply(true);
	}
}
