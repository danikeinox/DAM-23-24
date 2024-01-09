package daniel.Cabrera.practicaPuntuable.controladors;

import daniel.Cabrera.practicaPuntuable.classes.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import daniel.Cabrera.practicaPuntuable.Main;

import java.io.IOException;

public class FLogin {


    // <editor-fold defaultstate="collapsed" desc="components Formulari">

    @FXML
    private MenuItem MIAfegirUsuari;
    @FXML
    private MenuItem MIMostrarUsuaris;
    @FXML
    private MenuItem MIPrincipal;
    @FXML
    private TextField tf_username;
    @FXML
    private TextField pf_password;
    @FXML
    private Button bt_login;
    @FXML
    private Button bt_config;


    //</editor-fold>


    // <editor-fold defaultstate="collapsed" desc="Variables globals Formulari Login">

    //  protected Fitxers f = new Fitxers();
    protected User us = new User();
    protected Admin ad = new Admin();

    //</editor-fold>


    // <editor-fold defaultstate="collapsed" desc="Mètodes del formulari">

    /**
     * Obrim el formulari que passem per paràmetre. Amb el titol també passat per paràmetre
     *
     * @param formulari Formulari a obrir
     * @param titol     Títol del formulari
     */
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

    @FXML
    protected void initialize() throws IOException {
        bt_config.setVisible(ad.checkFile());

        // ** //

    }


    // Login
    @FXML
    public void Login() {
        if (us.checkLogin(tf_username.getText(), pf_password.getText())) {
            FGeneric("FPrincipal.fxml", "Vehicles");
        } else if(ad.checkLogin(tf_username.getText(), pf_password.getText())){
            FGeneric("FPrincipal.fxml", "Vehicles");
        } else {
            Alerta al = new Alerta("Credencials incorrectes");
            al.alertaError();
        }
    }

    // Config
    @FXML
    public void Config() {
        FGeneric("Auth/FAfegeixUsuari.fxml", "Configuració");

        //***//
    }


    //</editor-fold>


}
