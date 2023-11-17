package daniel.Cabrera.herenciaexemple.classes;

import java.io.IOException;
import java.util.Random;

public class Taxi implements Vehicle {

    // <editor-fold defaultstate="collapsed" desc="Propietats">

    private String matricula;
    private String model;
    private Double potencia;
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
    public Taxi(String matricula, String model, Double potencia, String numeroLlicencia) {
        try {
            this.matricula = matricula;
            this.model = model;
            this.potencia = potencia;
            this.numeroLlicencia = numeroLlicencia;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //</editor-fold>


    // <editor-fold defaultstate="collapsed" desc="Getters & Setters">

    public String getNumeroLlicencia() {
        return numeroLlicencia;
    }

    public static String getRutaFitxer() {
        return rutaFitxer;
    }

    public void setNumeroLlicencia(String numeroLlicencia) {
        this.numeroLlicencia = numeroLlicencia;
    }

    public static void setRutaFitxer(String rutaFitxer) {
        Taxi.rutaFitxer = rutaFitxer;
    }

    @Override
    public void guardaVehicleFitxer(String rutaFitxer) throws IOException {
        if (!f.existeix(dir))
            f.creaDirectori(dir);
        f.escriuObjecteFitxer(this, rutaFitxer, true);
    }

    @Override
    public <T> Object retornaVehiclesEnLlista(String arxiu, T classeObjecte) throws InterruptedException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException, IOException {
        return f.retornaFitxerObjecteEnLlista(arxiu, classeObjecte);
    }

    @Override
    public String generaMatricula() {
        int i;
        Random rnd = new Random();
        String mat = "";
        char[] lletra = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        for (i = 0; i < 4; i++) {
            mat += rnd.nextInt(10);
        }
        for (i = 0; i < 3; i++) {
            mat += lletra[rnd.nextInt(lletra.length)];
        }
        return mat;
    }

    @Override
    public String getMatricula() {
        return matricula;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public Double getPotencia() {
        return potencia;
    }

    @Override
    public int compareTo(Object o) {
        Taxi tx = (Taxi) o;
        if (this.potencia.compareTo(tx.potencia) < 0)
            return -1;
        if (this.potencia.compareTo(tx.potencia) > 0)
            return 1;
        return 0;
    }


    //</editor-fold>

}