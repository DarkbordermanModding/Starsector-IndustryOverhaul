package mod.industryoverhaul.impl;

import com.fs.starfarer.api.campaign.econ.Industry;
import com.fs.starfarer.api.campaign.econ.MarketAPI.SurveyLevel;
import com.fs.starfarer.api.impl.campaign.econ.impl.BaseIndustry;
import com.fs.starfarer.api.impl.campaign.ids.Conditions;


public class UpgradeOre extends BaseIndustry {

	@Override
	public void apply() {
		super.apply(true);
	}

	@Override
	protected void buildingFinished(){
		super.buildingFinished();
		if(getMarket().hasCondition(Conditions.ORE_SPARSE)){
			getMarket().removeCondition(Conditions.ORE_SPARSE);
			getMarket().addCondition(Conditions.ORE_MODERATE);
		}else if(getMarket().hasCondition(Conditions.ORE_MODERATE)){
			getMarket().removeCondition(Conditions.ORE_MODERATE);
			getMarket().addCondition(Conditions.ORE_ABUNDANT);
		}
		getMarket().setSurveyLevel(SurveyLevel.FULL);
		for(Industry industry: getMarket().getIndustries()){
			industry.doPreSaveCleanup();
			industry.doPostSaveRestore();
		}
		getMarket().removeIndustry(getId(), null, false);
	}

	@Override
	public boolean isAvailableToBuild() {
		if(getMarket().hasCondition(Conditions.ORE_ULTRARICH)) return false;
		return true;
	}

	@Override
	public boolean showWhenUnavailable(){
		return false;
	}
}
