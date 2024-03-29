package daniel.Cabrera.practicaPuntuable.controladors;

import daniel.Cabrera.practicaPuntuable.classes.TipusAutobus;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import daniel.Cabrera.practicaPuntuable.classes.Autobus;

import java.io.IOException;

public class FAfegeixAutobus {

    // <editor-fold defaultstate="collapsed" desc="Components FXML">

    @FXML
    private AnchorPane FAfegeixLlibre;
    @FXML
    private ComboBox TFModel;
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
        // ADD Enum TipusAutobus to TFModel ComboBox
        TFModel.setItems(TipusAutobus.getTipusAutobus());

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
            String matricula = TFMatricula.getText();
            String model = TFModel.getItems().get(TFModel.getSelectionModel().getSelectedIndex()).toString();
            Double potencia = Double.parseDouble(TFPotencia.getText());
            int places = Integer.parseInt(TFPlaces.getText());

            // construïm objecte, amb les dades de la classe pare (vehicle) i filla (autobus)
            Autobus au = new Autobus(matricula, model, potencia, places);
            au.guardaVehicleFitxer(Autobus.getRutaFitxer());
            buidaCamps();
            TFMatricula.setText(au.generaMatricula());
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
        TFModel.setButtonCell(TFModel.getButtonCell());
        TFPlaces.setText("");
        TFPotencia.setText("");

        // *** //

    }
    //</editor-fold>
}
