package mod.industryoverhaul;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.PlanetSpecAPI;
import com.fs.starfarer.api.campaign.econ.MarketAPI;
import com.fs.starfarer.loading.specs.PlanetSpec;

public class Utilities {

    public void changePlanetSpec(MarketAPI market, String planetType){
        PlanetSpecAPI myspec = market.getPlanetEntity().getSpec();
        for(PlanetSpecAPI spec: Global.getSettings().getAllPlanetSpecs()) {
            if (spec.getPlanetType().equals(planetType)) {
                myspec.setAtmosphereColor(spec.getAtmosphereColor());
                myspec.setAtmosphereThickness(spec.getAtmosphereThickness());
                myspec.setAtmosphereThicknessMin(spec.getAtmosphereThicknessMin());
                myspec.setCloudColor(spec.getCloudColor());
                myspec.setCloudRotation(spec.getCloudRotation());
                myspec.setCloudTexture(spec.getCloudTexture());
                myspec.setGlowColor(spec.getGlowColor());
                myspec.setGlowTexture(spec.getGlowTexture());
                myspec.setIconColor(spec.getIconColor());
                myspec.setPlanetColor(spec.getPlanetColor());
                myspec.setStarscapeIcon(spec.getStarscapeIcon());
                myspec.setTexture(spec.getTexture());
                myspec.setUseReverseLightForGlow(spec.isUseReverseLightForGlow());
                ((PlanetSpec)myspec).planetType = planetType;
                ((PlanetSpec)myspec).name = spec.getName();
                ((PlanetSpec)myspec).descriptionId = ((PlanetSpec)spec).descriptionId;
                break;
            }
        }
        market.getPlanetEntity().applySpecChanges();
    }
}
