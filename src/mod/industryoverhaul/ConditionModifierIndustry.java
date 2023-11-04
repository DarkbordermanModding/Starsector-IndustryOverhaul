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

    protected List<String> getRequiredConditions(){
        return new ArrayList<String>();
    }

    protected List<String> getPreventConditions(){
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
        for(String condition: getPreventConditions()){
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
