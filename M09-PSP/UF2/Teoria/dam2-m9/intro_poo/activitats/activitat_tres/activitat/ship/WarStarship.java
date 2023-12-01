package cat.dam.psp.activitat_tres.activitat.ship;

import cat.dam.psp.activitat_tres.activitat.weapon.InstalledWeapon;

import java.util.List;

public abstract class WarStarship extends cat.dam.psp.activitat_tres.activitat.ship.Starship implements Defense {
    private List<InstalledWeapon> weaponry;

    private final double SHIELD_REDUCE_FACTOR = 0.25;

    public WarStarship(String id, String manufacturer, cat.dam.psp.activitat_tres.activitat.ship.Faction faction, double hullIntegrity) {
        super(id, manufacturer, faction, hullIntegrity);
    }

    public List<InstalledWeapon> getWeaponry() {
        return weaponry;
    }

    public void setWeaponry(List<InstalledWeapon> weaponry) {
        this.weaponry = weaponry;
    }

    @Override
    public String toString() {
        StringBuilder list = new StringBuilder();
        this.getWeaponry().forEach(weapon -> list.append("\t").append(weapon.toString()).append("\n"));
        return String.format("%s\nWeaponery:\n\tPower: %.2f\n%s", super.toString(), this.getAttackPower(), list);
    }

    public double getAttackPower() {
        double power = 0.0f;
        for (InstalledWeapon w : this.getWeaponry()) {
            power += w.getBonusDamage() * w.getWeaponType().getDefaultDamage() * w.getCount();
        }
        return power;
    }

    @Override
    public boolean defendAgainst(WarStarship enemy) {
        double enemyAttackPower = enemy.getAttackPower();
        double currentShields = this.getShields();
        double currentHull = this.getHullIntegrity();
        boolean alive = true;
        if (currentShields > 0 && currentHull > 0) {
            this.setShields(currentShields - (SHIELD_REDUCE_FACTOR * enemyAttackPower) / 100);
            this.setHullIntegrity(currentHull - (currentShields * enemyAttackPower) / 100);
            if (this.getHullIntegrity() <= 0)
                alive = false;
        } else {
            alive = false;
        }

        if (!alive) {
            this.setFlying(false);
            this.setDestroyed(true);
        }

        return alive;
    }
}