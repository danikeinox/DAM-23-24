package daniel.Cabrera.weapon;

public class InstalledWeapon extends Weapon {

    private int count;

    public InstalledWeapon(double bonusDamage, WeaponType weaponType, int count) {
        super(bonusDamage, weaponType);
        this.count = count;
    }


    public int getCount() { return count; }

    public void setCount(int count) { this.count = count; }


}
