package daniel.Cabrera.practicaPuntuable.classes;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class Autobus extends Vehicle {


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

    public int getNumPlaces() { return numPlaces; }

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
    public boolean equals(Object obj) {
        // si l'objecte que vull comparar (obj) i jo(this) som el mateix objecte return true
        if (obj == this)
            return true;

        // comprovem ara que l'objecte obj sigui una instància d'Autobús
        if (!(obj instanceof Autobus))
            return false;

        // passem ara a comprovar els valors de les propietats.
        Autobus j = (Autobus) obj;     //Primer convertim obj a la nostra classe

        // i ara retornem true si totes les propietats tenen el mateix valor (o false en cas contrari)
        return Integer.compare(getId(), j.getId()) == 0 &&
                Integer.compare(getNumPlaces(), j.getNumPlaces()) == 0 &&
                Double.compare(getPotencia(), j.getPotencia()) == 0 &&
                getMatricula().equals(j.getMatricula()) &&
                getModel().equals(j.getModel());

    }

    @Override
    public Autobus cercaVehicle() {
        try {
            List<Autobus> autobus = (List<Autobus>) Autobus.retornaVehiclesEnLlista(Autobus.getRutaFitxer());
            boolean found = false;
            for (Autobus bus : autobus) {
                if (bus.matricula.equals(matricula)) { // Compare with the matricula passed as a parameter
                    this.matricula = bus.getMatricula();
                    this.potencia = bus.getPotencia();
                    this.model = bus.getModel();
                    this.numPlaces = bus.getNumPlaces();
                    found = true;
                    break;
                }
            }
            if (!found) {
                this.matricula = "No existeix";
                this.potencia = 0.0;
                this.model = "";
                this.numPlaces = 0;
            }
        } catch (IOException | NoSuchFieldException | InterruptedException | ClassNotFoundException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    @Override
    public Double getPotencia() {
        return potencia;
    }

    @Override
    public int compareTo(Object obj) {
        Autobus au = (Autobus) obj;
        if (this.potencia.compareTo(au.potencia) < 0)
            return -1;
        if (this.potencia.compareTo(au.potencia) > 0)
            return 1;
        return 0;
    }
    //</editor-fold>

}
