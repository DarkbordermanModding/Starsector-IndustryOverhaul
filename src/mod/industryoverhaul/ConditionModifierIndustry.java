package mod.industryoverhaul;

import java.util.ArrayList;
import java.util.List;

import com.fs.starfarer.api.campaign.econ.Industry;
import com.fs.starfarer.api.impl.campaign.econ.impl.BaseIndustry;

public class ConditionModifierIndustry extends BaseIndustry {

    public List<String> PREVENT_CONDITIONS = new ArrayList<String>();
    public List<String> REMOVE_CONDITIONS = new ArrayList<String>();
    public List<String> ADD_CONDITIONS = new ArrayList<String>();

    @Override
    public void apply() {
        super.apply(true);
    }

    protected List<String> getRequiredConditions(){
        return new ArrayList<String>();
    }

    @Override
	public boolean isAvailableToBuild() {
        for(String condition: PREVENT_CONDITIONS){
            if(getMarket().hasCondition(condition)) return false;
        }
        for(String condition: getRequiredConditions()){
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
