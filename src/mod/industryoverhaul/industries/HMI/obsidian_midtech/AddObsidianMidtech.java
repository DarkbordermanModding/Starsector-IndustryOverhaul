package mod.industryoverhaul.industries.HMI.obsidian_midtech;

import java.util.Arrays;
import java.util.List;

import mod.industryoverhaul.IndustryModifierIndustry;

public class AddObsidianMidtech extends IndustryModifierIndustry {

    protected List<String> getPreventAnyIndustries(){
        return Arrays.asList("HMI_obsidian_midtech");
    }

    protected List<String> getAddedIndustries(){
        return Arrays.asList("HMI_obsidian_midtech");
    }
}
