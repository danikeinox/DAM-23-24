package daniel.Cabrera.practicaPuntuable.classes;


import pkgFitxers.ComparadorObjectes;
import pkgFitxers.Fitxers;

import java.io.IOException;
import java.io.Serializable;

public abstract class Vehicle extends ComparadorObjectes implements Serializable, Comparable {


    /**
     * Fixeu-se que sols aquesta classe pare és serialitzable
     * ja que el mètode d'escriptura d'objectes al fitxer està ací
     * Les classes filles no cal que es serialitzen ja que ho hereten del pare
     * i per tant ja són serialitzables per herència
     */

    // <editor-fold defaultstate="collapsed" desc="Propietats">
    // Variables protected que podran utilitzar les filles sense necessitat de declarar-les
    protected static Fitxers f = new Fitxers();
    protected static String dir = ".data/";       // carpeta contenidora dels fitxers

    private int id;
    private String matricula;
    private Double potencia;
    //missatgesJavaSwing m = new missatgesJavaSwing();
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
    public static <T> Object retornaVehiclesEnLlista(String arxiu)
            throws InterruptedException, ClassNotFoundException, NoSuchFieldException,
            IllegalAccessException, IOException {
        return f.retornaFitxerObjecteEnLlista(arxiu);
    }


    /**
     * Mètode per eliminar un vehicle
     *
     * @param fitxer ruta del fitxer
     */
    public void eliminarVehicle(String fitxer) throws IOException, InterruptedException, ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Vehicle vh = cercaVehicle();
        int q = (int) f.retornaFitxerObjecteEnLlista(fitxer, vh);
        if (q == 1)
            f.eliminarFitxerDirectori(fitxer);
        else
            f.eliminaRegistreFitxerObjecte(fitxer, vh);
    }

    /**
     * Mètode per retornar l'equals del vehicle
     *
     * @return equals
     */
    public abstract boolean equals(Object obj);

    /**
     * Mètode per cercar un vehicle
     *
     * @return cercaVehicle
     */
    public abstract Vehicle cercaVehicle();

    /**
     * POLIMORFISME. Ja que en la classe derivada taxi, utilitzarà aquest mètode
     * i en la classe derivada Autobús s'ha de reescriure el mètode.
     * <p>
     * Genera una matrícula aleatoria ) 4 números i 3 lletres
     * <p>
     *
     * @return matrícula
     */
    public abstract String generaMatricula();

    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters">

    //getters (necessaris per a que des de la classe filla puga'm veure les dades (si volem clar)

    public int getId() {
        this.id = id;
        return this.id;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Double getPotencia() {
        this.potencia = potencia;
        return this.potencia;
    }

    public abstract String getMatricula();
    public abstract String getModel();

    @Override
    public int compareTo(Object o) {
        return 0;
    }


    //</editor-fold>

}
