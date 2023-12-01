package cat.dam.psp.activitat_tres.activitat.ship;

import cat.dam.psp.activitat_tres.activitat.weapon.InstalledWeapon;
import cat.dam.psp.activitat_tres.activitat.weapon.WeaponType;

import java.util.ArrayList;
import java.util.List;

public class RepublicShipFactory {
    public static RepublicStarship xWing(String id) {
        RepublicStarship ship = new RepublicStarship(id, "Incom Corporation (IC)", Faction.REPUBLIC, 1000);
        List<InstalledWeapon> weapons = new ArrayList<>();
        weapons.add(new InstalledWeapon(1, WeaponType.LASER_CANON, 4));
        weapons.add(new InstalledWeapon(1, WeaponType.PROTON_TORPEDO, 2));
        ship.setWeaponry(weapons);
        return ship;
    }
}
