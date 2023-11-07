package mod.industryoverhaul.impl;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.CargoAPI.CargoItemQuantity;
import com.fs.starfarer.api.campaign.FleetDataAPI;
import com.fs.starfarer.api.campaign.SpecialItemData;
import com.fs.starfarer.api.campaign.econ.SubmarketAPI;
import com.fs.starfarer.api.combat.ShipHullSpecAPI;
import com.fs.starfarer.api.fleet.FleetMemberAPI;
import com.fs.starfarer.api.impl.campaign.econ.impl.BaseIndustry;
import com.fs.starfarer.api.impl.campaign.ids.Items;

public class ReverseEngineeringYard extends BaseIndustry {
    protected transient SubmarketAPI saved = null;

    public void apply() {
        super.apply(true);
        // Code from com.fs.starfarer.api.impl.campaign.econ.impl.TradeCenter
        if (this.isFunctional() && this.market.isPlayerOwned()) {
            SubmarketAPI open = this.market.getSubmarket("reverse_engineering");
            if (open == null) {
                if (this.saved != null) {
                    this.market.addSubmarket(this.saved);
                } else {
                    this.market.addSubmarket("reverse_engineering");
                    SubmarketAPI sub = this.market.getSubmarket("reverse_engineering");
                    sub.setFaction(Global.getSector().getFaction("player"));
               }
            }
        } else if (this.market.isPlayerOwned()) {
            this.market.removeSubmarket("reverse_engineering");
        }
        if (!this.isFunctional()) {
            this.unapply();
        }
    }

    public void unapply() {
        super.unapply();
        if (this.market.isPlayerOwned()) {
            SubmarketAPI open = this.market.getSubmarket("reverse_engineering");
            this.saved = open;
            this.market.removeSubmarket("reverse_engineering");
        }
    }

    public void advance(float amount) {
        super.advance(amount);
        // Reverse engineering weapon/fighters/ships each hour
        SubmarketAPI reverseEngineeringMarket = this.market.getSubmarket("reverse_engineering");
        SubmarketAPI storage = this.market.getSubmarket("reverse_engineering");
        if(reverseEngineeringMarket == null || storage == null) return;

        if(!reverseEngineeringMarket.getCargo().getWeapons().isEmpty()){
            String weaponId = "";
            int weaponCount = 0;
            for(CargoItemQuantity<String> weapon: reverseEngineeringMarket.getCargo().getWeapons()){
                weaponId = weapon.getItem();
                weaponCount = weapon.getCount();
                break;
            }
            reverseEngineeringMarket.getCargo().removeWeapons(weaponId, weaponCount);
            SpecialItemData data = new SpecialItemData(Items.WEAPON_BP, weaponId);
            storage.getCargo().addSpecial(data, weaponCount);
        }
        if(!reverseEngineeringMarket.getCargo().getFighters().isEmpty()){
            String fighterId = "";
            int fighterCount = 0;
            for(CargoItemQuantity<String> fighter: reverseEngineeringMarket.getCargo().getFighters()){
                fighterId = fighter.getItem();
                fighterCount = fighter.getCount();
                break;
            }
            reverseEngineeringMarket.getCargo().removeFighters(fighterId, fighterCount);
            SpecialItemData data = new SpecialItemData(Items.FIGHTER_BP, fighterId);
            storage.getCargo().addSpecial(data, fighterCount);
        }
        FleetDataAPI storedShips = reverseEngineeringMarket.getCargo().getMothballedShips();
        if (!storedShips.getMembersListCopy().isEmpty()){
            String blueprintId = "";
            for(FleetMemberAPI ship: storedShips.getMembersListCopy()){
                blueprintId = getBaseShipHullSpec(ship.getHullSpec()).getHullId();
                storedShips.removeFleetMember(ship);
                break;
            }
            //add the blueprint to storage
            SpecialItemData data = new SpecialItemData(Items.SHIP_BP, blueprintId);
            storage.getCargo().addSpecial(data, 1);
        }
    }

    // Remove Dmods and others, get base blueprint hull
    private ShipHullSpecAPI getBaseShipHullSpec(ShipHullSpecAPI spec) {
        ShipHullSpecAPI base = spec.getDParentHull();
        if (!spec.isDefaultDHull() && !spec.isRestoreToBase()) {
            base = spec;
        }
        if (spec.isRestoreToBase()) {
            base = spec.getBaseHull();
        }
        return base;
    }
}
