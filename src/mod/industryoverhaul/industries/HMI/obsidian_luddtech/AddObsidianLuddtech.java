package mod.industryoverhaul.industries.HMI.obsidian_luddtech;

import java.util.Arrays;
import java.util.List;

import mod.industryoverhaul.IndustryModifierIndustry;

public class AddObsidianLuddtech extends IndustryModifierIndustry {

    protected List<String> getPreventAnyIndustries(){
        return Arrays.asList("HMI_obsidian_luddtech");
    }

    protected List<String> getAddedIndustries(){
        return Arrays.asList("HMI_obsidian_luddtech");
    }
}
