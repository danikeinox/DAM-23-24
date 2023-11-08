package daniel.Cabrera.herenciaexemple.classes;

import java.io.IOException;

public class Taxi implements Vehicle {


    // <editor-fold defaultstate="collapsed" desc="Propietats">
    // sols una propietat de taxi. La resta estan en el pare
    private String numeroLlicencia;
    private static String rutaFitxer = dir + ".taxis.dat";

    // IMPORTANT.Noteu que la variable dir és una variable de la interficie Vehicle
    //</editor-fold>


    // <editor-fold defaultstate="collapsed" desc="Constructors">
    // tindrem bàsicament 3 constructors. El per defecte, el del pare, el del pare+fill.

    // constructor per defecte
    public Taxi() {
    }

    // constructor TOT
    public Taxi(String matricula, String model, Double potencia, String numeroLlicencia) throws IOException {
        this.matricula = matricula;
        this.model = model;
        this.potencia = potencia;
        this.numeroLlicencia = numeroLlicencia;
    }

    //</editor-fold>


    // <editor-fold defaultstate="collapsed" desc="Getters & Setters">

    public String getNumeroLlicencia() {
        return numeroLlicencia;
    }

    public  void setNumeroLlicencia(String numeroLlicencia) {
        this.numeroLlicencia = numeroLlicencia;
    }

    public static String getRutaFitxer() {
        return rutaFitxer;
    }

    public static void setRutaFitxer(String rutaFitxer) {
        Taxi.rutaFitxer = rutaFitxer;
    }


    //</editor-fold>

}