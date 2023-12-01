package cat.dam2.psp.factory;

import cat.dam2.psp.factory.cotxe.CotxeElectricArmat;
import cat.dam2.psp.factory.cotxe.CotxeEspiaFactory;

public class Main {
    public static void main(String[] args) {
        CotxeElectricArmat c1 = CotxeEspiaFactory.cotxeModelEspiaA("0001");
        CotxeElectricArmat c2 = CotxeEspiaFactory.cotxeModelEspiaA("0002");
        System.out.printf("Bastidor: %s armament: %s\n", c1.getNBastidor(), c1.toString());
        System.out.printf("Bastidor: %s armament: %s", c2.getNBastidor(), c2.toString());
    }
}