package cat.dam2.psp.factory.cotxe;

public class CotxeElectric extends Cotxe {
    private int nBateries;
    public CotxeElectric(String marca, String color, int nPortes) {
        super(marca, color, nPortes);
    }

    public int getnBateries() {
        return nBateries;
    }

    public void setnBateries(int nBateries) {
        this.nBateries = nBateries;
    }

    @Override
    public String toString() {
        return "CotxeElectric{" +
                "nBateries=" + nBateries +
                '}';
    }
}
