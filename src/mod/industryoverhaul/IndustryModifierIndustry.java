package mod.industryoverhaul;

import java.util.ArrayList;
import java.util.List;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.econ.Industry;
import com.fs.starfarer.api.impl.campaign.econ.impl.BaseIndustry;

public class IndustryModifierIndustry extends BaseIndustry {

    @Override
    public void apply() {super.apply(true);}

    @Override
    public boolean showWhenUnavailable(){return false;}

    // Can't build if ANY of it exists
    protected List<String> getPreventAnyIndustries(){
        return new ArrayList<String>();
    }

    protected List<String> getRemoveIndustries(){
        return new ArrayList<String>();
    }

    protected List<String> getAddedIndustries(){
        return new ArrayList<String>();
    }

    @Override
    public boolean isAvailableToBuild() {
        // Check industries exist or not
        for(String industry: getAddedIndustries()){
            if(Global.getSettings().getIndustrySpec(industry) == null){ return false; }
        }
        for(String industry: getRemoveIndustries()){
            if(Global.getSettings().getIndustrySpec(industry) == null){ return false; }
        }

        // prevent any, prevent all, required all, then require any
        for(String industry: getPreventAnyIndustries()){
            if(getMarket().hasIndustry(industry)) return false;
        }

        return true;
    }

    @Override
    protected void buildingFinished(){
        super.buildingFinished();
        for(String industry: getRemoveIndustries()){
             getMarket().removeIndustry(industry, null, false);
        }
        for(String industry: getAddedIndustries()){
            getMarket().addIndustry(industry);
        }
        getMarket().reapplyConditions();
        for(Industry industry: getMarket().getIndustries()){
            industry.doPreSaveCleanup();
            industry.doPostSaveRestore();
        }
        getMarket().removeIndustry(getId(), null, false);
    }
}
