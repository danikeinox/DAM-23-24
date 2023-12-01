package cat.dam.psp.activitat_tres.activitat.weapon;

public class Weapon {
    private double bonusDamage;
    private WeaponType weaponType;

    public Weapon(double bonusDamage, WeaponType weaponType) {
        this.bonusDamage = bonusDamage;
        this.weaponType = weaponType;
    }

    public double getBonusDamage() {
        return bonusDamage;
    }

    public void setBonusDamage(double bonusDamage) {
        this.bonusDamage = bonusDamage;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "bonusDamage=" + bonusDamage +
                ", weaponType=" + weaponType +
                '}';
    }
}
