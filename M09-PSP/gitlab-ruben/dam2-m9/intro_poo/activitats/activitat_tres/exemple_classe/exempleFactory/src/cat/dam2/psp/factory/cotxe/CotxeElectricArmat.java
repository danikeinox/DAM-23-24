package cat.dam2.psp.factory.cotxe;

import cat.dam2.psp.factory.armament.Arma;
import cat.dam2.psp.factory.armament.IArmament;

import java.util.ArrayList;
import java.util.List;

public class CotxeElectricArmat extends CotxeElectric implements IArmament {
    private List<Arma> armes = new ArrayList<>();
    public CotxeElectricArmat(String marca, String color, int nPortes) {
        super(marca, color, nPortes);
    }

    @Override
    public int getArmes() {
        return 0;
    }

    @Override
    public void setArmes(List<Arma> armes) {
        this.armes = armes;
    }

    @Override
    public String toString() {
        return "CotxeElectricArmat{" +
                "armes=" + armes +
                '}';
    }
}
