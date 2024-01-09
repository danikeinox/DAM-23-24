package daniel.Cabrera.practicaPuntuable.controladors;

import daniel.Cabrera.practicaPuntuable.classes.Autobus;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class FModificarAutobus {

    // <editor-fold defaultstate="collapsed" desc="Components FXML">

    @FXML
    private AnchorPane FModificaAutobus;
    @FXML
    private AnchorPane FCercaAutobus;
    @FXML
    private ComboBox TFModel;
    @FXML
    private TextField TFPotencia;
    @FXML
    private TextField TFPlaces;
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

        TFMatricula.setText("");
        TFModel.setButtonCell(TFModel.getButtonCell());
        TFPotencia.setText("");
        TFPlaces.setText("");

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
            int numPlaces = Integer.parseInt(TFPlaces.getText());

            au = new Autobus(matricula, model, potencia, numPlaces);
            // au.modificarVehicle(Autobus.getRutaFitxer());
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
            Autobus au2 = new Autobus();
            au2.setMatricula(matricula);
            if (au2.cercaVehicle().getMatricula() == "No existeix") {
                FModificaAutobus.setDisable(true);
            } else {
                TFMatricula.setText(au2.cercaVehicle().getMatricula());
                TFModel.getButtonCell().setText(au2.cercaVehicle().getModel());
                TFPlaces.setText(String.valueOf(au2.cercaVehicle().getNumPlaces()));
                TFPotencia.setText(String.valueOf(au2.cercaVehicle().getPotencia()));
                FModificaAutobus.setDisable(false);
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
        TFPlaces.setText("");
        TFPotencia.setText("");

        // *** //

    }
    //</editor-fold>
}
