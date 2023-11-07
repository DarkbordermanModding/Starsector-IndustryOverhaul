package mod.industryoverhaul.industries.HMI.obsidian_lowtech;

import java.util.Arrays;
import java.util.List;

import mod.industryoverhaul.IndustryModifierIndustry;

public class AddObsidianLowtech extends IndustryModifierIndustry {

    protected List<String> getPreventAnyIndustries(){
        return Arrays.asList("HMI_obsidian_lowtech");
    }

    protected List<String> getAddedIndustries(){
        return Arrays.asList("HMI_obsidian_lowtech");
    }
}
