package cat.dam.psp.activitat_tres.activitat.ship;

public abstract class Starship {
    private String id;
    private String manufacturer;
    private Faction faction;
    private boolean flying;
    private boolean destroyed;
    private double hullIntegrity;
    private double shields;

    public Starship(String id, String manufacturer, Faction faction, double hullIntegrity) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.faction = faction;
        this.flying = false;
        this.destroyed = false;
        this.shields = 100;
        this.hullIntegrity = hullIntegrity;
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

    public Faction getFaction() {
        return faction;
    }

    public void setFaction(Faction faction) {
        this.faction = faction;
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
                        "\nid: %s" +
                        "\nManufacturer: %s" +
                        "\nFaction: %s" +
                        "\nStatus:" +
                        "\n\t hull integrity: %.2f" +
                        "\n\t shields: %.2f %%" +
                        "\n\t is flying: %B" +
                        "\n\t is destroyed: %B",
                this.getClass().getSimpleName(), this.getId(),
                this.getManufacturer(), faction,
                this.getHullIntegrity(), this.getShields(),
                this.isFlying(), this.isDestroyed());
    }
}