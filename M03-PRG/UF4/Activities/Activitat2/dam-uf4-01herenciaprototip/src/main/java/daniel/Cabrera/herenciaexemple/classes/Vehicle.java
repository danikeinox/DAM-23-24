package daniel.Cabrera.herenciaexemple.classes;


import pkgFitxers.Fitxers;

import java.io.IOException;
import java.io.Serializable;
import java.util.Random;

public class Vehicle implements Serializable {


    /**
     * Fixeu-se que sols aquesta classe pare és serialitzable
     * ja que el mètode d'escriptura d'objectes al fitxer està ací
     * Les classes filles no cal que es serialitzen ja que ho hereten del pare
     * i per tant ja són serialitzables per herència
     */

    // <editor-fold defaultstate="collapsed" desc="Propietats">
    private String matricula;        // matrícula del vehicle
    private String model;           // model del vehicle
    private Double potencia;
    // Variables protected que podran utilitzar les filles sense necessitat de declarar-les
    protected static Fitxers f = new Fitxers();
    protected static String dir = ".data/";       // carpeta contenidora dels fitxers
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Constructors">

    public Vehicle() {
    }

    public Vehicle(String matricula, String model, Double potencia) {
        this.matricula = matricula;
        this.model = model;
        this.potencia = potencia;
    }

    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Mètodes">

    /**
     * Mètode per guardar un objecte vehicle
     *
     * @throws IOException Excepció d'E/S
     */
    public void guardaVehicleFitxer(String rutaFitxer) throws IOException {
        if (!f.existeix(dir))
            f.creaDirectori(dir);
        f.escriuObjecteFitxer(this, rutaFitxer, true);
    }


    /**
     * Mètode per retornar qualsevol objecte vehicle
     * ja retorna fins i tot formatat a la classe que pertany
     *
     * @param arxiu ruta de l'arxiu
     * @return llista classe de l'objecte a transformar
     * @throws InterruptedException   excepció
     * @throws ClassNotFoundException excepció
     * @throws NoSuchFieldException   excepció
     * @throws IllegalAccessException excepció
     * @throws IOException            excepció
     */
    public <T> Object retornaVehiclesEnLlista(String arxiu, T Class) throws ClassNotFoundException, InterruptedException, NoSuchFieldException, IllegalAccessException, IOException {
        return f.retornaFitxerTextEnLlista(arxiu);        // <-- eliminar el return null
    }


    /**
     * POLIMORFISME. Ja que en la classe derivada taxi, utilitzarà aquest mètode
     * i en la classe derivada Autobús s'ha de reescriure el mètode.
     * <p>
     * Genera una matrícula aleatoria ) 4 números i 3 lletres
     * <p>
     *
     * @return matrícula
     */
    public String generaMatricula() {
        int i;
        Random rnd = new Random();
        String mat = "";
        char[] lletra = {'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R',
                'S', 'T', 'V', 'W', 'X', 'Y', 'Z'};
        for (i = 0; i < 4; i++) {
            mat = mat + rnd.nextInt(10);        // número aleatori entre 0 i 9
        }
        for (i = 0; i < 3; i++) {
            mat = mat + lletra[rnd.nextInt(lletra.length)];
        }
        return mat;
    }

    public void missatge(String alerta) {
        System.out.println();
    }

    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters">

    //getters (necessaris per a que des de la classe filla puga'm veure les dades (si volem clar)

    public static Fitxers getF() {
        return f;
    }

    public static String getDir() {
        return dir;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getModel() {
        return model;
    }

    public Double getPotencia() {
        return potencia;
    }

    @Override
    public String toString() {
        return "Matricula: " + matricula + "\n" +
                "Model: " + model + "\n" +
                "Potencia: " + potencia + "\n";
    }

    //</editor-fold>

}
