package mod.industryoverhaul;

import java.util.List;

import com.fs.starfarer.api.campaign.econ.Industry;
import com.fs.starfarer.api.impl.campaign.econ.impl.BaseIndustry;

public abstract class ConditionModifierIndustry extends BaseIndustry {

    public List<String> PREVENT_CONDITIONS;
    public List<String> REQUIRED_CONDITIONS;
    public List<String> REMOVE_CONDITIONS;
    public List<String> ADD_CONDITIONS;

    @Override
	public boolean isAvailableToBuild() {
        for(String condition: PREVENT_CONDITIONS){
            if(getMarket().hasCondition(condition)) return false;
        }
        for(String condition: REQUIRED_CONDITIONS){
            if(!getMarket().hasCondition(condition)) return false;
        }
		return true;
	}

	@Override
	protected void buildingFinished(){
		super.buildingFinished();
        for(String condition: REMOVE_CONDITIONS){
     		getMarket().removeCondition(condition);
        }
        for(String condition: ADD_CONDITIONS){
            getMarket().addCondition(condition);
            getMarket().getCondition(condition).setSurveyed(true);
        }
		getMarket().reapplyConditions();
		for(Industry industry: getMarket().getIndustries()){
			industry.doPreSaveCleanup();
			industry.doPostSaveRestore();
		}
		getMarket().removeIndustry(getId(), null, false);
	}

    @Override
	public boolean showWhenUnavailable(){
		return false;
	}
}
