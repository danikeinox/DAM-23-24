package daniel.Cabrera.classeAbstractaPrototip.classes;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class Taxi extends Vehicle {

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
    public boolean equals(Object obj) {
         // si l'objecte que vull comparar (obj) i jo(this) som el mateix objecte return true
        if (obj == this)
            return true;

        // comprovem ara que l'objecte obj sigui una instància d'Autobús
        if (!(obj instanceof Taxi))
            return false;

        // passem ara a comprovar els valors de les propietats.
        Taxi j = (Taxi) obj;     //Primer convertim obj a la nostra classe

        // i ara retornem true si totes les propietats tenen el mateix valor (o false en cas contrari)
        return Integer.compare(getId(), j.getId()) == 0 &&
                getNumeroLlicencia().equals(j.getNumeroLlicencia()) &&
                Double.compare(getPotencia(), j.getPotencia()) == 0 &&
                getMatricula().equals(j.getMatricula()) &&
                getModel().equals(j.getModel());

    }

    @Override
    public Taxi cercaVehicle() {
        try {
            String checkMatricula = getMatricula();
            List<Taxi> taxis = (List<Taxi>) Taxi.retornaVehiclesEnLlista(Taxi.getRutaFitxer());
            for (Taxi taxi : taxis) {
                if (taxi.getMatricula().equals(checkMatricula)) {
                    this.potencia = getPotencia();
                    this.model = getModel();
                    this.numeroLlicencia = getNumeroLlicencia();
                }
            }
        } catch (IOException | NoSuchFieldException | InterruptedException | ClassNotFoundException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return this;
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