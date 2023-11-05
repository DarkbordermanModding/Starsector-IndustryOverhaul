package mod.industryoverhaul;


import java.util.Iterator;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.PlanetSpecAPI;
import com.fs.starfarer.api.campaign.econ.MarketAPI;
import com.fs.starfarer.loading.specs.PlanetSpec;

public class Utilities {

    public void changePlanetSpec(MarketAPI market){
        String newPlanetType = "terran";
        PlanetSpecAPI myspec = market.getPlanetEntity().getSpec();
        Iterator var4 = Global.getSettings().getAllPlanetSpecs().iterator();
        while(var4.hasNext()) {
            PlanetSpecAPI spec = (PlanetSpecAPI)var4.next();
            if (spec.getPlanetType().equals(newPlanetType)) {
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
                ((PlanetSpec)myspec).planetType = newPlanetType;
                ((PlanetSpec)myspec).name = spec.getName();
                ((PlanetSpec)myspec).descriptionId = ((PlanetSpec)spec).descriptionId;
                break;
            }
        }
        market.getPlanetEntity().applySpecChanges();
    }
}
