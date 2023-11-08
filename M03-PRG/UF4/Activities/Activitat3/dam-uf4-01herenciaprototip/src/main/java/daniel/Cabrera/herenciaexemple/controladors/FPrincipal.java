package daniel.Cabrera.herenciaexemple.controladors;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Modality;
import javafx.stage.Stage;
import daniel.Cabrera.herenciaexemple.Main;
import daniel.Cabrera.herenciaexemple.classes.Autobus;
import daniel.Cabrera.herenciaexemple.classes.Taxi;

public class FPrincipal {


    // <editor-fold defaultstate="collapsed" desc="components Formulari">

    @FXML
    private MenuItem MIAfegirTaxi;
    @FXML
    private MenuItem MIMostrarTaxi;
    @FXML
    private MenuItem MIAfegirAutobus;
    @FXML
    private MenuItem MIMostrarAutor;


    //</editor-fold>


    // <editor-fold defaultstate="collapsed" desc="Variables globals Formulari Principal">

  //  protected Fitxers f = new Fitxers();
    protected Taxi tx = new Taxi();
    protected Autobus au = new Autobus();

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
//            Alerta al = new Alerta("El formulari: \n\n" + formulari + "\n\nno s'ha carregat. Error:\n\n" + e.getMessage());
//            al.alertaError();
        }
    }


    // Taxi
    @FXML
    public void afegirTaxi() {

        FGeneric("Taxi/FAfegeixTaxi.fxml", "Afegir Taxi");
    }

    @FXML
    public void mostrarTaxi() {
        FGeneric("Taxi/FMostrarTaxis.fxml", "Llistat de taxi");

        //***//
    }


    // Autobús
    @FXML
    public void afegirAutobus() {

        FGeneric("Autobus/FAfegeixAutobus.fxml", "Afegir Autobus");

    }

    @FXML
    public void mostarAutobus() {
        FGeneric("Autobus/FMostrarAutobus.fxml", "Llista d'autobussos");


        //***//

    }


    //</editor-fold>


}
