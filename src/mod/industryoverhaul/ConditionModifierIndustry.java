package mod.industryoverhaul;

import java.util.ArrayList;
import java.util.List;

import com.fs.starfarer.api.campaign.econ.Industry;
import com.fs.starfarer.api.impl.campaign.econ.impl.BaseIndustry;

public class ConditionModifierIndustry extends BaseIndustry {

    public List<String> ADD_CONDITIONS = new ArrayList<String>();

    @Override
    public void apply() {
        super.apply(true);
    }

    // Can build if ALL of it exists
    protected List<String> getRequiredConditions(){
        return new ArrayList<String>();
    }

    // Can build if ANY of it exists
    protected List<String> getRequiredAnyConditions(){
        return new ArrayList<String>();
    }

    // Can't build if ANY of it exists
    protected List<String> getPreventAnyConditions(){
        return new ArrayList<String>();
    }

    protected List<String> getRemoveConditions(){
        return new ArrayList<String>();
    }

    protected List<String> getAddedConditions(){
        return new ArrayList<String>();
    }

    @Override
	public boolean isAvailableToBuild() {
        for(String condition: getPreventAnyConditions()){
            if(getMarket().hasCondition(condition)) return false;
        }
        for(String condition: getRequiredConditions()){
            if(!getMarket().hasCondition(condition)) return false;
        }

        // Do not require any condition
        if(getRequiredAnyConditions().isEmpty()) return true;
        for(String condition: getRequiredAnyConditions()){
            if(getMarket().hasCondition(condition)) return true;
        }
        return false;
	}

	@Override
	protected void buildingFinished(){
		super.buildingFinished();
        for(String condition: getRemoveConditions()){
     		getMarket().removeCondition(condition);
        }
        for(String condition: getAddedConditions()){
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
