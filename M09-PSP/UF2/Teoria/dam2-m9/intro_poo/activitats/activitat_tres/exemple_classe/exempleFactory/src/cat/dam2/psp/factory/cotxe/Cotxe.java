package cat.dam2.psp.factory.cotxe;

public abstract class Cotxe {
    private String marca;
    private String color;
    private int nPortes;

    private String nBastidor;

    public Cotxe(String marca, String color, int nPortes) {
        this.marca = marca;
        this.color = color;
        this.nPortes = nPortes;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getnPortes() {
        return nPortes;
    }

    public void setnPortes(int nPortes) {
        this.nPortes = nPortes;
    }

    public void setNBastidor(String nBastidor) {
        this.nBastidor = nBastidor;
    }

    public String getNBastidor() {
        return this.nBastidor;
    }


    @Override
    public String toString() {
        return "Cotxe{" +
                "marca='" + marca + '\'' +
                ", color='" + color + '\'' +
                ", nPortes=" + nPortes +
                '}';
    }
}
