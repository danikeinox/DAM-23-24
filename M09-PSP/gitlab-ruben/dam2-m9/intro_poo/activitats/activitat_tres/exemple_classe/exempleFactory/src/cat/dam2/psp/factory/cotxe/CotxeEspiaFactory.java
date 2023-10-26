package cat.dam2.psp.factory.cotxe;

import cat.dam2.psp.factory.armament.Arma;

import java.util.ArrayList;
import java.util.List;

public class CotxeEspiaFactory {
    public static CotxeElectricArmat cotxeModelEspiaA(String nBastidor){
        CotxeElectricArmat cotxe = new CotxeElectricArmat("Ford",
                "Negre", 4);
        cotxe.setNBastidor(nBastidor);
        cotxe.setnBateries(100);
        List<Arma> armes = new ArrayList<>();
        armes.add(Arma.CANO);
        armes.add(Arma.LASER);
        cotxe.setArmes(armes);
        return cotxe;
    }
}
