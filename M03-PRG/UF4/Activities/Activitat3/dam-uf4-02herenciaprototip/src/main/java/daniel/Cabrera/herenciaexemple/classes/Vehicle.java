package daniel.Cabrera.herenciaexemple.classes;


import pkgFitxers.Fitxers;

import java.io.IOException;
import java.io.Serializable;
import java.util.Random;

public interface Vehicle extends Serializable, Comparable {


    /**
     * Fixeu-se que sols aquesta classe pare és serialitzable
     * ja que el mètode d'escriptura d'objectes al fitxer està ací
     * Les classes filles no cal que es serialitzen ja que ho hereten del pare
     * i per tant ja són serialitzables per herència
     */

    // <editor-fold defaultstate="collapsed" desc="Propietats">
    // Variables protected que podran utilitzar les filles sense necessitat de declarar-les
    Fitxers f = new Fitxers();
    String dir = ".data/";       // carpeta contenidora dels fitxers
    //missatgesJavaSwing m = new missatgesJavaSwing();
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Mètodes">

    /**
     * Mètode per guardar un objecte vehicle
     *
     * @throws IOException Excepció d'E/S
     */
    void guardaVehicleFitxer(String rutaFitxer) throws IOException;


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
    <T> Object retornaVehiclesEnLlista(String arxiu, T classeObjecte)
            throws InterruptedException, ClassNotFoundException, NoSuchFieldException,
            IllegalAccessException, IOException;


    /**
     * POLIMORFISME. Ja que en la classe derivada taxi, utilitzarà aquest mètode
     * i en la classe derivada Autobús s'ha de reescriure el mètode.
     * <p>
     * Genera una matrícula aleatoria ) 4 números i 3 lletres
     * <p>
     *
     * @return matrícula
     */
    String generaMatricula();

    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters">

    //getters (necessaris per a que des de la classe filla puga'm veure les dades (si volem clar)

    String getMatricula();

    String getModel();

    Double getPotencia();

    //</editor-fold>

}
