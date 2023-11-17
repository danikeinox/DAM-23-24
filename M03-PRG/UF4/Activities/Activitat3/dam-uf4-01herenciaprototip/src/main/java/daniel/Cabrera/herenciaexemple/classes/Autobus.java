package daniel.Cabrera.herenciaexemple.classes;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Autobus implements Vehicle {


    // <editor-fold defaultstate="collapsed" desc="Propietats">

    private String matricula;
    private String model;
    private Double potencia;
    private int numPlaces;
    private static String rutaFitxer = dir + ".autobussos.dat";

    // IMPORTANT.Noteu que la variable dir és una variable de la classe pare. PROTECTED
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" constructors">

    public Autobus() {
    }

    public Autobus(String matricula, String model, Double potencia, int numPlaces) {
        try {
            this.matricula = matricula;
            this.model = model;
            this.potencia = potencia;
            this.numPlaces = numPlaces;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters & Setters">

    public static String getRutaFitxer() {
        return rutaFitxer;
    }

    public static void setRutaFitxer(String rutaFitxer) {
        Autobus.rutaFitxer = rutaFitxer;
    }

    public int getNumPlaces() {
        return numPlaces;
    }

    public void setNumPlaces(int numPlaces) {
        this.numPlaces = numPlaces;
    }


    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" Mètodes">

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

    /**
     * Genera una matrícula aleatoria amb le utilitació
     * del mètode generarClau de la llibreria LlibreriaComuna
     * A aquesta matrícula se li afegirà aleatoriament
     * unes sigles d'un país europeu.
     * <p>
     * Utilitzem polimorfisme, ja que aquest mètode està creat
     * en el pare, i reprogramat en aquesta classe derivada
     *
     * @return marícula amb sigles pais
     */
    public String generaMatricula() {
        Random rnd = new Random();
        StringBuilder mat = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            mat.append(rnd.nextInt(10));
        }
        char[] lletra = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        for (int i = 0; i < 3; i++) {
            mat.append(lletra[rnd.nextInt(lletra.length)]);
        }
        String[] lletresMatricula = {"RO", "IT", "DE", "BE", "ES", "FR", "GB", "PT", "AT", "CH", "DK", "FI", "HU", "IE", "IS", "NL", "NO", "SE", "SK"};
        mat.append(" (" + lletresMatricula[rnd.nextInt(lletresMatricula.length)] + ")");
        return mat.toString();
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
        Autobus au = (Autobus) o;
        if (this.potencia.compareTo(au.potencia) < 0)
            return -1;
        if (this.potencia.compareTo(au.potencia) > 0)
            return 1;
        return 0;
    }
    //</editor-fold>

}
