package daniel.Cabrera.classeAbstractaPrototip.controladors;

import daniel.Cabrera.classeAbstractaPrototip.classes.Taxi;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class FEliminarTaxi {

    // <editor-fold defaultstate="collapsed" desc="Components FXML">
    @FXML
    private AnchorPane FAfegeixLlibre;
    @FXML
    private TextField TFModel;
    @FXML
    private TextField TFPotencia;
    @FXML
    private TextField TFLlicencia;
    @FXML
    private TextField TFMatricula;
    @FXML
    private Button BEliminar;
    @FXML
    private Button BCerca;
    @FXML
    private Label LabelEliminat;


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
        TFModel.setText("");
        TFPotencia.setText("");
        TFLlicencia.setText("");

        // ** //

    }

    /**
     * Botó per guardar la  informació dels text Fields
     *
     * @throws IOException execpció d'entrada sortida
     */
    @FXML
    public void BtEliminar() throws IOException {
        try {
            String matricula = TFMatricula.getText();
            Double potencia = Double.parseDouble(TFPotencia.getText());
            String model = TFModel.getText();
            String numeroLlicencia = TFLlicencia.getText();

            tx = new Taxi(matricula, model, potencia, numeroLlicencia);
            tx.eliminarVehicle(Taxi.getRutaFitxer());
            buidaCamps();
            LabelEliminat.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // *** //

    }

    @FXML
    public void BtCerca() throws IOException {
        LabelEliminat.setVisible(false);
        try {
            String matricula = TFMatricula.getText();
            TFMatricula.setText(tx.cercaVehicle(matricula).getMatricula());
            TFModel.setText(tx.cercaVehicle(matricula).getModel());
            TFLlicencia.setText(String.valueOf(tx.cercaVehicle(matricula).getNumeroLlicencia()));
            TFPotencia.setText(String.valueOf(tx.cercaVehicle(matricula).getPotencia()));
            BEliminar.setDisable(tx.cercaVehicle(matricula).getMatricula().equals("No existeix"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Buidem els comboBox del formulari
     */
    public void buidaCamps() {

        TFMatricula.setText("");
        TFModel.setText("");
        TFLlicencia.setText("");
        TFPotencia.setText("");


        // *** //


    }
    //</editor-fold>

}
