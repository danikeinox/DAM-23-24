package conceptes.classes;

public enum Seccio {
    ADMINISTRACIO("Administració"),
    PRODUCCIO("Producció"),
    COMPTABILITAT("Comptabilitat"),
    INFORMATICA("Informàtica");

    private final String descripcio;

    Seccio(String descripcio) {
        this.descripcio = descripcio;
    }

    public String getDescripcio() {
        return descripcio;
    }
}
