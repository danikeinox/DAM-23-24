package daniel.Cabrera.herenciaexemple.classes;


import pkgFitxers.Fitxers;

import java.io.IOException;

public class Taxi extends Vehicle {


    // <editor-fold defaultstate="collapsed" desc="Propietats">
    // sols una propietat de taxi. La resta estan en el pare
    protected static String numeroLlicencia = "";
    private static String rutaFitxer=dir+".autobussos.dat";

    // IMPORTANT.Noteu que la variable dir és una variable de la classe pare. PROTECTED
    //</editor-fold>


    // <editor-fold defaultstate="collapsed" desc="Constructors">
    // tindrem bàsicament 3 constructors. El per defecte, el del pare, el del pare+fill.



    // constructor pare + fill
    public Taxi(String matricula, String model, String potencia, String numeroLlicencia) {
        super(matricula, model, potencia);
        Taxi.numeroLlicencia = numeroLlicencia;
    }

    // constructor per defecte
    public Taxi() {
        super();
    }

    // constructor pare
    public Taxi(String matricula, String model, String potencia) {
        super(matricula, model, potencia);
    }


    //</editor-fold>


    // <editor-fold defaultstate="collapsed" desc="Getters & Setters">

    public static String getNumeroLlicencia() {
        return numeroLlicencia;
    }

    public static void setNumeroLlicencia(String numeroLlicencia) {
        Taxi.numeroLlicencia = numeroLlicencia;
    }

    public static String getRutaFitxer() {
        return rutaFitxer;
    }

    public static void setRutaFitxer(String rutaFitxer) {
        Taxi.rutaFitxer = rutaFitxer;
    }


    //</editor-fold>

}