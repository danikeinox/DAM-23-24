package daniel.Cabrera.classeAbstractaPrototip.controladors;

import daniel.Cabrera.classeAbstractaPrototip.classes.Autobus;
import daniel.Cabrera.classeAbstractaPrototip.classes.Taxi;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class FEliminarAutobus {

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
    private Button BEliminar;
    @FXML
    private Button BCerca;
    @FXML
    private Label LabelEliminat;


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
        TFModel.setText("");
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
    public void BtEliminar() throws IOException {
        try {
            String matricula = TFMatricula.getText();
            String model = TFModel.getText();
            Double potencia = Double.parseDouble(TFPotencia.getText());
            int numPlaces = Integer.parseInt(TFPlaces.getText());

            au = new Autobus(matricula, model, potencia, numPlaces);
            au.eliminarVehicle(Autobus.getRutaFitxer());
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
            TFMatricula.setText(au.cercaVehicle(matricula).getMatricula());
            TFModel.setText(au.cercaVehicle(matricula).getModel());
            TFPlaces.setText(String.valueOf(au.cercaVehicle(matricula).getNumPlaces()));
            TFPotencia.setText(String.valueOf(au.cercaVehicle(matricula).getPotencia()));
            BEliminar.setDisable(au.cercaVehicle(matricula).getMatricula().equals("No existeix"));
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
        TFPlaces.setText("");
        TFPotencia.setText("");

        // *** //

    }
    //</editor-fold>
}
