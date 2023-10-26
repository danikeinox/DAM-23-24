package cat.dam2.psp.factory.armament;

public enum Arma {
    LASER(10.0),
    CANO(100.0),
    AMETRALLADORA (75.0);

    private final double deafultDamage;

    public double getDeafultDamage() {
        return deafultDamage;
    }

    Arma(double deafultDamage) {
        this.deafultDamage = deafultDamage;
    }
}
