package mod.industryoverhaul.industries.HMI.obsidian_hitech;

import java.util.Arrays;
import java.util.List;

import mod.industryoverhaul.IndustryModifierIndustry;

public class AddObsidianHitech extends IndustryModifierIndustry {

    protected List<String> getPreventAnyIndustries(){
        return Arrays.asList("HMI_obsidian_hitech");
    }

    protected List<String> getAddedIndustries(){
        return Arrays.asList("HMI_obsidian_hitech");
    }
}
