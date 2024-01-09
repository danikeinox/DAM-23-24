package daniel.Cabrera.practicaPuntuable.classes;

import java.io.IOException;
import java.util.List;

public class User extends Persona {

    // <editor-fold defaultstate="collapsed" desc="Propietats">

    private String name;
    private String surname;
    private String username;
    private String password;

    private int edat;
    private boolean admin;
    private static String rutaFitxer = dir + ".users.dat";


    // IMPORTANT.Noteu que la variable dir és una variable de la interficie Vehicle
    //</editor-fold>


    // <editor-fold defaultstate="collapsed" desc="Constructors">
    // tindrem bàsicament 3 constructors. El per defecte, el del pare, el del pare+fill.

    // constructor per defecte
    public User() {
    }

    // constructor TOT
    public User(String name, String surname, String username, String password, int edat, boolean isAdmin) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.edat = edat;
        this.admin = isAdmin;
    }


    //</editor-fold>


    // <editor-fold defaultstate="collapsed" desc="Getters & Setters">

    @Override
    public int getEdat() {
        return edat;
    }

    @Override
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public static String getRutaFitxer() {
        return rutaFitxer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void setRutaFitxer(String rutaFitxer) {
        User.rutaFitxer = rutaFitxer;
    }

    @Override
    public boolean equals(Object obj) {
        // si l'objecte que vull comparar (obj) i jo(this) som el mateix objecte return true
        if (obj == this)
            return true;

        // comprovem ara que l'objecte obj sigui una instància d'Autobús
        if (!(obj instanceof User))
            return false;

        // passem ara a comprovar els valors de les propietats.
        User j = (User) obj;     //Primer convertim obj a la nostra classe

        // i ara retornem true si totes les propietats tenen el mateix valor (o false en cas contrari)
        return Integer.compare(getId(), j.getId()) == 0 &&
                getName().equals(j.getName()) &&
                getSurname().equals(j.getSurname()) &&
                getUsername().equals(j.getUsername()) &&
                getPassword().equals(j.getPassword()) &&
                getEdat() == j.getEdat() &&
                Boolean.compare(getAdmin(), j.getAdmin()) == 1;

    }

    @Override
    public User cercaPersona() {
        try {
            List<User> users = (List<User>) User.retornaPersonasEnLlista(User.getRutaFitxer());
            boolean found = false;
            for (User user : users) {
                if (user.username.equals(this.username) && user.password.equals(this.password)) {
                    this.name = user.getName();
                    this.surname = user.getSurname();
                    this.username = user.getUsername();
                    this.password = user.getPassword();
                    this.edat = user.getEdat();
                    this.admin = user.getAdmin();
                    found = true;
                    break;
                }
            }
            if (!found) {
                this.username = "No existeix";
                this.password = "";
                this.name = "";
                this.surname = "";
                this.admin = false;
            }
        } catch (IOException | NoSuchFieldException | InterruptedException | ClassNotFoundException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public boolean checkLogin(String username, String password) {
        try {
            List<User> users = (List<User>) User.retornaPersonasEnLlista(User.getRutaFitxer());
            boolean found = false;
            for (User user : users) {
                if (user.username.equals(this.username) && user.password.equals(this.password)) {
                    found = true;
                    return true;
                }
                if (user.username.equals(username) && !user.password.equals(password)) {
                    found = true;
                    Alerta al = new Alerta("Contrasenya incorrecta");
                    al.alertaError();
                    return false;
                }
            }
            if (!found) {
                Alerta al = new Alerta("No exiteix aquest usuari");
                al.alertaError();
            }
        } catch (IOException | NoSuchFieldException | InterruptedException | ClassNotFoundException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    //</editor-fold>

}