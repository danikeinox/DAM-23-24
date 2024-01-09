package daniel.Cabrera.practicaPuntuable.controladors;

import daniel.Cabrera.practicaPuntuable.classes.Taxi;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class FModificarTaxi {

    // <editor-fold defaultstate="collapsed" desc="Components FXML">

    @FXML
    private AnchorPane FModificaTaxi;
    @FXML
    private AnchorPane FCercaTaxi;
    @FXML
    private ComboBox TFModel;
    @FXML
    private TextField TFPotencia;
    @FXML
    private TextField TFLlicencia;
    @FXML
    private TextField TFMatricula;
    @FXML
    private TextField TFCercaMatricula;
    @FXML
    private Button BModificar;
    @FXML
    private Button BCerca;
    @FXML
    private Label LabelModificat;


    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Variables globals">
    Taxi tx = new Taxi();
    //</editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Mètodes">

    /**
     * Inicialització de les variables del formulari
     *
     * @throws IOException excepció d'entrada/sortida
     */
    @FXML
    protected void initialize() throws IOException {

        TFMatricula.setText("");
        TFModel.setButtonCell(TFModel.getButtonCell());
        TFPotencia.setText("");
        TFLlicencia.setText("");

        // *** //

    }

    /**
     * Botó per guardar la  informació dels text Fields
     *
     * @throws IOException execpció d'entrada sortida
     */
    @FXML
    public void BtModificar() throws IOException {
        try {
            String matricula = TFMatricula.getText();
            String model = TFModel.getButtonCell().getText();
            Double potencia = Double.parseDouble(TFPotencia.getText());
            String numLlicencia = TFLlicencia.getText();

            tx = new Taxi(matricula, model, potencia, numLlicencia);
            // au.modificarVehicle(Taxi.getRutaFitxer());
            buidaCamps();
            LabelModificat.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // *** //

    }

    @FXML
    public void BtCerca() throws IOException {
        LabelModificat.setVisible(false);
        try {
            String matricula = TFCercaMatricula.getText();
            Taxi tx2 = new Taxi();
            tx2.setMatricula(matricula);
            if (tx2.cercaVehicle().getMatricula() == "No existeix") {
                FModificaTaxi.setDisable(true);
            } else {
                TFMatricula.setText(tx2.cercaVehicle().getMatricula());
                TFModel.getButtonCell().setText(tx2.cercaVehicle().getModel());
                TFLlicencia.setText(String.valueOf(tx2.cercaVehicle().getNumeroLlicencia()));
                TFPotencia.setText(String.valueOf(tx2.cercaVehicle().getPotencia()));
                FModificaTaxi.setDisable(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Buidem els comboBox del formulari
     */
    public void buidaCamps() {

        TFMatricula.setText("");
        TFModel.getButtonCell().setText("");
        TFLlicencia.setText("");
        TFPotencia.setText("");

        // *** //

    }
    //</editor-fold>
}
