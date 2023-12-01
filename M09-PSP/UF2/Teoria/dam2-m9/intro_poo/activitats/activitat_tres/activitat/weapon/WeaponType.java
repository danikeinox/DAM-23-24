package cat.dam.psp.activitat_tres.activitat.weapon;

public enum WeaponType {
    PHASER(10.0),
    PHOTON(25.0),
    WEIGHT_TURBO_LASER_TURRET(60.0),
    MEDIUM_TURBO_LASER_TURRET(30.0),
    LIGHT_TURBO_LASER_TURRET(15.0),
    TRACTOR_BEAM(0.0),
    ION_CANNON(85.0),
    LASER_CANON(65.0),
    PROTON_TORPEDO(100.0);

    private final double defaultDamage;

    public double getDefaultDamage() {
        return defaultDamage;
    }

    WeaponType(double defaultDamage) {
        this.defaultDamage = defaultDamage;
    }
}
