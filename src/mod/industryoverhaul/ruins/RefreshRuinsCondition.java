package mod.industryoverhaul.ruins;

import java.util.Arrays;
import java.util.List;

import com.fs.starfarer.api.campaign.econ.Industry;
import com.fs.starfarer.api.campaign.rules.MemoryAPI;
import com.fs.starfarer.api.impl.campaign.ids.Conditions;

import mod.industryoverhaul.ConditionModifierIndustry;


public class RefreshRuinsCondition extends ConditionModifierIndustry {

    protected List<String> getRequiredAnyConditions(){
        return Arrays.asList(
            Conditions.RUINS_SCATTERED,
            Conditions.RUINS_WIDESPREAD,
            Conditions.RUINS_EXTENSIVE,
            Conditions.RUINS_VAST
        );
    }

    @Override
    protected void buildingFinished(){
        super.buildingFinished();

        MemoryAPI mem = market.getMemoryWithoutUpdate();
        if (mem.contains("$core_techMiningMult")) {
            mem.set("$core_techMiningMult", 1f);
        }

        getMarket().reapplyConditions();
        for(Industry industry: getMarket().getIndustries()){
            industry.doPreSaveCleanup();
            industry.doPostSaveRestore();
        }
        getMarket().removeIndustry(getId(), null, false);
    }
}
