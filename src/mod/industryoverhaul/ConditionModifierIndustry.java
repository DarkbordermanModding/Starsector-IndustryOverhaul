package mod.industryoverhaul;

import java.util.ArrayList;
import java.util.List;

import com.fs.starfarer.api.campaign.econ.Industry;
import com.fs.starfarer.api.impl.campaign.econ.impl.BaseIndustry;

public class ConditionModifierIndustry extends BaseIndustry {

    @Override
    public void apply() {super.apply(true);}

    @Override
    public boolean showWhenUnavailable(){return false;}

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
        // prevent any, prevent all, required all, then require any
        for(String condition: getPreventAnyConditions()){
            if(getMarket().hasCondition(condition)) return false;
        }
        for(String condition: getRequiredConditions()){
            if(!getMarket().hasCondition(condition)) return false;
        }

        // Do not require any condition
        boolean requiredMet = false;
        if(getRequiredAnyConditions().isEmpty()) requiredMet = true;
        for(String condition: getRequiredAnyConditions()){
            if(getMarket().hasCondition(condition)) requiredMet = true;
        }

        return requiredMet;
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
}
