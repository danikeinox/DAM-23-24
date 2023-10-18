package daniel.Cabrera.weapon;

public class Weapon {
    private double bonusDamage;
    private WeaponType weaponType;

    public Weapon(double bonusDamage, WeaponType weaponType) {
        this.bonusDamage = bonusDamage;
        this.weaponType = weaponType;
    }

    // Getters and setters for Weapon attributes
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "bonusDamage=" + bonusDamage +
                ", weaponType=" + weaponType +
                ", count=" + count +
                '}';
    }

    // Método para calcular el daño de esta arma
    public double getDamage() {
        // El daño es igual al bonusDamage multiplicado por el tipo de arma
        return bonusDamage * weaponType.getDamageMultiplier();
    }
}
