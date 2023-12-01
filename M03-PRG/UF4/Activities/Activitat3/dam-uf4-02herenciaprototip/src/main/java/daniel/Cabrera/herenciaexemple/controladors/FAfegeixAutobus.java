package daniel.Cabrera.herenciaexemple.controladors;

import daniel.Cabrera.herenciaexemple.classes.Taxi;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import daniel.Cabrera.herenciaexemple.classes.Autobus;

import java.io.IOException;

public class FAfegeixAutobus {

    // <editor-fold defaultstate="collapsed" desc="Components FXML">

    @FXML
    private AnchorPane FAfegeixLlibre;
    @FXML
    private TextField TFModel;
    @FXML
    private TextField TFPotencia;
    @FXML
    private TextField TFPlaces;
    @FXML
    private TextField TFMatricula;
    @FXML
    private Button BGuarda;


    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Variables globals">
    Autobus au = new Autobus();
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Mètodes">

    /**
     * Inicialització de les variables del formulari
     *
     * @throws IOException excepció d'entrada/sortida
     */
    @FXML
    protected void initialize() throws IOException {

        TFMatricula.setText(au.generaMatricula());

        // *** //

    }

    /**
     * Botó per guardar la  informació dels text Fields
     *
     * @throws IOException execpció d'entrada sortida
     */
    @FXML
    public void BtGuarda() throws IOException {
        try {
            Double potencia = Double.parseDouble(TFPotencia.getText());
            String matricula = TFMatricula.getText();
            String model = TFModel.getText();
            int places = Integer.parseInt(TFPlaces.getText());

            // construïm objecte, amb les dades de la classe pare (vehicle) i filla (autobus)
            Autobus au = new Autobus(matricula, model, potencia, places);
            au.guardaVehicleFitxer(Autobus.getRutaFitxer());
            buidaCamps();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // *** //

    }

    /**
     * Buidem els comboBox del formulari
     */
    public void buidaCamps() {

        TFMatricula.setText("");
        TFModel.setText("");
        TFPlaces.setText("");
        TFPotencia.setText("");

        // *** //

    }
    //</editor-fold>
}
