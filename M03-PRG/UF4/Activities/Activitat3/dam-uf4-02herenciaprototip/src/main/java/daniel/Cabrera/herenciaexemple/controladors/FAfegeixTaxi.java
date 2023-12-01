package daniel.Cabrera.herenciaexemple.controladors;

import daniel.Cabrera.herenciaexemple.classes.Taxi;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class FAfegeixTaxi {

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
    private Button BGuarda;


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

        TFMatricula.setText(tx.generaMatricula());

            // ** //

    }

    /**
     * Botó per guardar la  informació dels text Fields
     *
     * @throws IOException execpció d'entrada sortida
     */
    @FXML
    public void BtGuarda() throws IOException {
        try{
            Double potencia = Double.parseDouble(TFPotencia.getText());
            String matricula = TFMatricula.getText();
            String model = TFModel.getText();
            String numeroLlicencia = TFLlicencia.getText();

            // construïm objecte, amb les dades de la classe pare (vehicle) i filla (taxi)
            Taxi tx = new Taxi(matricula, model, potencia, numeroLlicencia);
            tx.guardaVehicleFitxer(Taxi.getRutaFitxer());
            buidaCamps();
        } catch (Exception e){
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
        TFLlicencia.setText("");
        TFPotencia.setText("");


        // *** //


    }
    //</editor-fold>

}
