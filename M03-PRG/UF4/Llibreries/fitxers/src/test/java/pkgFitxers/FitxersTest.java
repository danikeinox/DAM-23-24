package pkgFitxers;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

class FitxersTest {

    static Fitxers fitx=new Fitxers();
    static Persona pers=new Persona();
    static String nomFitxer=pers.getFitxer();


    static String nom="Vicent";
    static String cognom="Bellver";
    static int edat=23;
    static double sou=523;



    @Test
    void retornaFitxerTextEnLlista() {
        List<Persona> lPersones= pers.retornaPersones();
        for (int i = 0; i < lPersones.size(); i++) {

            if (lPersones.get(i).getEdat()>45)
            System.out.println(lPersones.get(i));

        }
    }

    @Test
    void escriuObjecteFitxer() throws IOException {
        Persona p=new Persona(nom,cognom,edat,sou);
        p.escriuPersonaBinari(p.getFitxerDat());

    }

    @Test
    void retornaFitxerObjecteEnLlista() throws ClassNotFoundException {
        List<Persona> lPersones= pers.retornaPersonesObjecte(pers.getFitxerDat());
        for (int i = 0; i < lPersones.size(); i++) {

            if (lPersones.get(i).getEdat()>45)
                System.out.println(lPersones.get(i));

        }


    }

    @Test
    void escriuTextFitxer() throws IOException {

         Persona p=new Persona(nom,cognom,edat,sou);

         p.escriuPersona();

    }


}