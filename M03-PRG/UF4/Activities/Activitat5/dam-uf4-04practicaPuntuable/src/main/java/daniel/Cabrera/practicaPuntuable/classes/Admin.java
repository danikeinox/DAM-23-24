package daniel.Cabrera.practicaPuntuable.classes;

import java.io.IOException;
import java.util.List;

public class Admin extends Persona {

    // <editor-fold defaultstate="collapsed" desc="Propietats">

    private String name;
    private String surname;
    private String username;
    private String password;
    private boolean admin;
    private static String rutaFitxer = dir + ".adminstradors.dat";

    // IMPORTANT.Noteu que la variable dir és una variable de la interficie Vehicle
    //</editor-fold>


    // <editor-fold defaultstate="collapsed" desc="Constructors">
    // tindrem bàsicament 3 constructors. El per defecte, el del pare, el del pare+fill.

    // constructor per defecte
    public Admin() {
    }

    // constructor TOT
    public Admin(String name, String surname, String username, String password, boolean isAdmin) {
        try {
            this.name = name;
            this.surname = surname;
            this.username = username;
            this.password = password;
            this.admin = isAdmin;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //</editor-fold>


    // <editor-fold defaultstate="collapsed" desc="Getters & Setters">

    @Override
    public int getEdat() {
        return 0;
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
        Admin.rutaFitxer = rutaFitxer;
    }

    @Override
    public boolean equals(Object obj) {
        // si l'objecte que vull comparar (obj) i jo(this) som el mateix objecte return true
        if (obj == this)
            return true;

        // comprovem ara que l'objecte obj sigui una instància d'Autobús
        if (!(obj instanceof Admin))
            return false;

        // passem ara a comprovar els valors de les propietats.
        Admin j = (Admin) obj;     //Primer convertim obj a la nostra classe

        // i ara retornem true si totes les propietats tenen el mateix valor (o false en cas contrari)
        return Integer.compare(getId(), j.getId()) == 0 &&
                getName().equals(j.getName()) &&
                getSurname().equals(j.getSurname()) &&
                getUsername().equals(j.getUsername()) &&
                getPassword().equals(j.getPassword()) &&
                Boolean.compare(getAdmin(), j.getAdmin()) == 1;

    }

    @Override
    public Admin cercaPersona() {
        try {
            List<Admin> admins = (List<Admin>) Admin.retornaPersonasEnLlista(Admin.getRutaFitxer());
            boolean found = false;
            for (Admin admin : admins) {
                if (admin.username.equals(this.username) && admin.password.equals(this.password)) {
                    this.name = admin.getName();
                    this.surname = admin.getSurname();
                    this.username = admin.getUsername();
                    this.password = admin.getPassword();
                    this.admin = admin.getAdmin();
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
        return username.equals(this.username) && password.equals(this.password);
    }

    public boolean checkFile() {
        return Admin.getRutaFitxer() != null;
    }

    //</editor-fold>

}