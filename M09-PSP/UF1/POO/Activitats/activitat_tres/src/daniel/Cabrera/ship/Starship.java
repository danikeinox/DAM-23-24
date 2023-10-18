package daniel.Cabrera.ship;

public class Starship {
    private String id;
    private String manufacturer;
    private Faction faction;
    private boolean flying;
    private boolean destroyed;
    private double hullIntegrity;
    private double shields;

    public static void StellarDestroyer(String id, double hullIntegrity, double shields) {
        this.id = id;
        this.manufacturer = "Kuat Drive Yards (KDY)";
        this.faction = Faction.EMPIRE;
        this.hullIntegrity = hullIntegrity;
        this.shields = shields;
        this.flying = false;
        this.destroyed = false;
    }

    public void xWing(String id, double hullIntegrity, double shields) {
        this.id = id;
        this.manufacturer = "Incom Corporation (IC)";
        this.faction = Faction.REPUBLIC;
        this.hullIntegrity = hullIntegrity;
        this.shields = shields;
        this.flying = false;
        this.destroyed = false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public boolean isFlying() {
        return flying;
    }

    public void setFlying(boolean flying) {
        this.flying = flying;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    public double getHullIntegrity() {
        return hullIntegrity;
    }

    public void setHullIntegrity(double hullIntegrity) {
        this.hullIntegrity = hullIntegrity;
    }

    public double getShields() {
        return shields;
    }

    public void setShields(double shields) {
        this.shields = shields;
    }

    @Override
    public String toString() {
        return String.format("\n%s" +
                        "\n, id: %s " +
                        "\n, manufacturer: %s" +
                        "\n, faction:' %s" +
                        "\n, Status" +
                        "\n\t, hull integrity: %f.2\n" +
                        "\n\t, shields: %f.2 \n" +
                        "\n\t, is flying: %b \n" +
                        "\n\t, is destroyed: %b \n",
                this.getClass().getSimpleName(), this.getId(), this.getManufacturer(), faction ,this.getHullIntegrity(),this.getShields(),this.isFlying(),this.isDestroyed() );
    }

}

