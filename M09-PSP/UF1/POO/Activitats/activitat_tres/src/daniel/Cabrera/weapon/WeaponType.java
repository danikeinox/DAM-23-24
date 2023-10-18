package daniel.Cabrera.weapon;

public enum WeaponType {
    TRACTOR_BEAM(10.0),
    ION_CANNON(15.0),
    WEIGHT_TURBO_LASER_TURRET(60.0),
    MEDIUM_TURBO_LASER_TURRET(30.0),
    LIGHT_TURBO_LASER_TURRET(85.0),
    LASER_CANON(65.0),
    PROTON_TORPEDO(100.0);

    private final double defaultDamage;

    public double getDefaultDamage() { return defaultDamage; }

    public double getDamageMultiplier() {
        return damageMultiplier;
    }
}
