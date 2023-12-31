package mod.industryoverhaul;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.PlanetSpecAPI;
import com.fs.starfarer.api.campaign.econ.MarketAPI;
import com.fs.starfarer.loading.specs.PlanetSpec;

public class Utilities {

    public static void changePlanetSpec(MarketAPI market, String planetType){
        // Deal with non-planet entity
        if(market.getPlanetEntity() == null) return;
        // Planet specs are defined in data/config/planets.json
        PlanetSpecAPI planetSpec = market.getPlanetEntity().getSpec();
        for(PlanetSpecAPI spec: Global.getSettings().getAllPlanetSpecs()) {
            if (spec.getPlanetType().equals(planetType)) {
                planetSpec.setAtmosphereColor(spec.getAtmosphereColor());
                planetSpec.setAtmosphereThickness(spec.getAtmosphereThickness());
                planetSpec.setAtmosphereThicknessMin(spec.getAtmosphereThicknessMin());
                planetSpec.setCloudColor(spec.getCloudColor());
                planetSpec.setCloudRotation(spec.getCloudRotation());
                planetSpec.setCloudTexture(spec.getCloudTexture());
                planetSpec.setGlowColor(spec.getGlowColor());
                planetSpec.setGlowTexture(spec.getGlowTexture());
                planetSpec.setIconColor(spec.getIconColor());
                planetSpec.setPlanetColor(spec.getPlanetColor());
                planetSpec.setStarscapeIcon(spec.getStarscapeIcon());
                planetSpec.setTexture(spec.getTexture());
                planetSpec.setUseReverseLightForGlow(spec.isUseReverseLightForGlow());
                ((PlanetSpec)planetSpec).planetType = planetType;
                // only modify gas giant to planet, not vice versa
                // Without this line planet will missing "world" on its name
                ((PlanetSpec)planetSpec).setGasGiant(false);
                ((PlanetSpec)planetSpec).name = spec.getName();
                ((PlanetSpec)planetSpec).descriptionId = ((PlanetSpec)spec).descriptionId;
                break;
            }
        }
        market.getPlanetEntity().applySpecChanges();
    }
}
