package daniel.Cabrera.practicaPuntuable.classes;


import pkgFitxers.ComparadorObjectes;
import pkgFitxers.Fitxers;

import java.io.IOException;
import java.io.Serializable;

public abstract class Persona extends ComparadorObjectes implements Serializable, Comparable {


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
    private String name;
    private String surname;
    private String username;
    private String password;
    private boolean admin;

    //missatgesJavaSwing m = new missatgesJavaSwing();
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Mètodes">

    /**
     * Mètode per guardar un objecte Persona
     *
     * @throws IOException Excepció d'E/S
     */
    public void guardaPersonaFitxer(String rutaFitxer) throws IOException {
        if (!f.existeix(dir))
            f.creaDirectori(dir);
        f.escriuObjecteFitxer(this, rutaFitxer, true);
    }


    /**
     * Mètode per retornar qualsevol objecte Persona
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
    public static <T> Object retornaPersonasEnLlista(String arxiu)
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
        Persona pe = cercaPersona();
        int q = (int) f.retornaFitxerObjecteEnLlista(fitxer, pe);
        if (q == 1)
            f.eliminarFitxerDirectori(fitxer);
        else
            f.eliminaRegistreFitxerObjecte(fitxer, pe);
    }

    /**
     * Mètode per retornar l'equals de la Persona
     *
     * @return equals
     */
    public abstract boolean equals(Object obj);

    /**
     * Mètode per cercar una Persona
     *
     * @return cercaPersona
     */
    public abstract Persona cercaPersona();


    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters">

    //getters (necessaris per a que des de la classe filla puga'm veure les dades (si volem clar)

    public int getId() {
        this.id = id;
        return this.id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean getAdmin() {
        return admin;
    }

    public abstract int getEdat();


    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public abstract void setAdmin(boolean admin);


    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }


    //</editor-fold>

}
