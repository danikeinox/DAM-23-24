package daniel.Cabrera.herenciaexemple.classes;

import java.util.Arrays;
import java.util.Random;

public class Autobus extends Vehicle {


    // <editor-fold defaultstate="collapsed" desc="Propietats">

    private static String rutaFitxer = dir + ".autobussos.dat";
    private int numPlaces = 0;
    // IMPORTANT.Noteu que la variable dir és una variable de la classe pare. PROTECTED
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc=" constructors">

    public Autobus() {
    }

    public Autobus(String matricula, String model, String potencia) {
        super(matricula, model, potencia);
    }

    public Autobus(String matricula, String model, String potencia, int numPlaces) {
        super(matricula, model, potencia);
        this.numPlaces = numPlaces;
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
        for(int i = 0; i < 4; i++){
            mat.append(rnd.nextInt(10));
        }
        char[] lletra = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        for(int i = 0; i < 3; i++) {
            mat.append(lletra[rnd.nextInt(lletra.length)]);
        }
        String[] lletresMatricula = {"RO", "IT", "DE", "BE", "ES", "FR", "GB", "PT", "AT", "CH", "DK", "FI", "HU", "IE", "IS", "NL", "NO", "SE", "SK"};
        mat.append(" (").append(rnd.nextInt(Arrays.toString(lletresMatricula).length())).append(")");
        return mat.toString();
    }
    //</editor-fold>

}
