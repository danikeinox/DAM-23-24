package cat.dam.psp.activitat_tres.activitat.ship;

import cat.dam.psp.activitat_tres.activitat.weapon.InstalledWeapon;
import cat.dam.psp.activitat_tres.activitat.weapon.WeaponType;

import java.util.ArrayList;
import java.util.List;

/***
 * Patró Factory
 * Check: <a href="https://www.arquitecturajava.com/usando-el-patron-factory/">...</a>
 */
public class EmpireShipFactory {
    public static EmpireWarStarship stellarDrestroyer(String id) {
        EmpireWarStarship ship = new EmpireWarStarship(id, "Kuat Drive Yards (KDY)", Faction.EMPIRE, 10000);
        List<InstalledWeapon> weapons = new ArrayList<>();
        weapons.add(new InstalledWeapon(1, WeaponType.TRACTOR_BEAM, 10));
        weapons.add(new InstalledWeapon(1, WeaponType.ION_CANNON, 60));
        weapons.add(new InstalledWeapon(1, WeaponType.WEIGHT_TURBO_LASER_TURRET, 60));
        weapons.add(new InstalledWeapon(1, WeaponType.MEDIUM_TURBO_LASER_TURRET, 60));
        weapons.add(new InstalledWeapon(1, WeaponType.LIGHT_TURBO_LASER_TURRET, 60));
        ship.setWeaponry(weapons);
        return ship;
    }
}
