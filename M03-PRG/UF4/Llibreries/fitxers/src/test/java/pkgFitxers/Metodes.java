package pkgFitxers;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public abstract class Metodes implements Serializable {

    static Fitxers f=new Fitxers();


    public void escriuPersonaBinari(String fitxerDat) throws IOException {
        f.escriuObjecteFitxer(this,fitxerDat,true);
    }


    public List<Persona> retornaPersonesObjecte(String fitxerDat) throws ClassNotFoundException, IOException, NoSuchFieldException, InterruptedException, IllegalAccessException {
        return (List<Persona>) f.retornaFitxerObjecteEnLlista(fitxerDat,Persona.class);

    }
}
