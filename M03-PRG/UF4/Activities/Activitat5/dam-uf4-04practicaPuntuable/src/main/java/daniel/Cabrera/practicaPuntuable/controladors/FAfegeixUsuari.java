package daniel.Cabrera.practicaPuntuable.controladors;

import daniel.Cabrera.practicaPuntuable.Main;
import daniel.Cabrera.practicaPuntuable.classes.Admin;
import daniel.Cabrera.practicaPuntuable.classes.Alerta;
import daniel.Cabrera.practicaPuntuable.classes.Taxi;
import daniel.Cabrera.practicaPuntuable.classes.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class FAfegeixUsuari {

    // <editor-fold defaultstate="collapsed" desc="Components FXML">
    @FXML
    private AnchorPane FAfegeixLlibre;
    @FXML
    private TextField TFName;
    @FXML
    private TextField TFSurname;
    @FXML
    private TextField TFUsername;
    @FXML
    private TextField TFPassword;
    @FXML
    private TextField TFEdat;
    @FXML
    private CheckBox CBAdmin;
    @FXML
    private Button BGuarda;


    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Variables globals">
    User us = new User();
    Admin ad = new Admin();
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Mètodes">

    private void FGeneric(String formulari, String titol) {
        try {

            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(formulari));

            Parent root = (Parent) fxmlLoader.load();
            Scene scene = new Scene(root);

            Stage stage = new Stage();
            // stage.initStyle((StageStyle.TRANSPARENT));
            stage.setTitle(titol);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.show();

        } catch (Exception e) {
            Alerta al = new Alerta("El formulari: \n\n" + formulari + "\n\nno s'ha carregat. Error:\n\n" + e.getMessage());
            al.alertaError();
        }
    }

    /**
     * Inicialització de les variables del formulari
     *
     * @throws IOException excepció d'entrada/sortida
     */
    @FXML
    protected void initialize() throws IOException {


        // ** //

    }

    /**
     * Botó per guardar la  informació dels text Fields
     *
     * @throws IOException execpció d'entrada sortida
     */
    @FXML
    public void BtGuarda() {
        try {
            String name = TFName.getText();
            String surname = TFSurname.getText();
            String username = TFUsername.getText();
            String password = TFPassword.getText();

            if (CBAdmin.isSelected()) {
                boolean admin = true;
                ad.setName(name);
                ad.setSurname(surname);
                ad.setUsername(username);
                ad.setPassword(password);
                ad.setAdmin(admin);
                ad.guardaPersonaFitxer(Admin.getRutaFitxer());
            } else {
                boolean admin = false;
                int edat = Integer.parseInt(TFEdat.getText());
                us.setName(name);
                us.setSurname(surname);
                us.setUsername(username);
                us.setPassword(password);
                us.setEdat(edat);
                us.setAdmin(admin);
                us.guardaPersonaFitxer(User.getRutaFitxer());
            }

            buidaCamps();
        } catch (NumberFormatException e) {
            Alerta al = new Alerta("Error: La edad debe ser un número entero.");
            al.alertaError();
        } catch (IOException e) {
            e.printStackTrace();  // Manejo adecuado de la excepción según tu caso
        }
    }

    @FXML
    public void mostrarUsers() {
        FGeneric("Auth/FMostrarUsuaris.fxml", "Llista d'usuaris");


        //***//

    }

    /**
     * Buidem els comboBox del formulari
     */
    public void buidaCamps() {

        TFName.setText("");
        TFSurname.setText("");
        TFUsername.setText("");
        TFPassword.setText("");
        TFEdat.setText("");
        CBAdmin.setSelected(false);


        // *** //


    }
    //</editor-fold>

}
