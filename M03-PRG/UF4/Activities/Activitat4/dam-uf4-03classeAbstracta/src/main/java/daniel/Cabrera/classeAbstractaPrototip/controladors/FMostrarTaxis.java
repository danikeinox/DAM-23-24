package daniel.Cabrera.classeAbstractaPrototip.controladors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import daniel.Cabrera.classeAbstractaPrototip.classes.Taxi;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.List;


public class FMostrarTaxis {


    // <editor-fold defaultstate="collapsed" desc="Components FXML">

    @FXML
    private TextArea TAPantalla;

    @FXML
    private TableView<Taxi> TVPantalla;

    @FXML
    private TableColumn<Taxi, Double> columnPotencia;

    @FXML
    private TableColumn<Taxi, String> columnMatricula;

    @FXML
    private TableColumn<Taxi, String> columnModel;

    @FXML
    private TableColumn<Taxi, String> columnLlicencia;


    //</editor-fold>


    // <editor-fold defaultstate="collapsed" desc="Mètodes">
    @FXML
    protected void initialize() throws IOException, ClassNotFoundException,
            InterruptedException, NoSuchFieldException, IllegalAccessException {
        Taxi tx = new Taxi();
        TVPantalla.setItems(null);
        List<Taxi> llistaTaxis = (List<Taxi>) tx.retornaVehiclesEnLlista(tx.getRutaFitxer());
        mostraTaxis(llistaTaxis);

    }

    /**
     * Omplim una TableView amb les dades de la Llista d'Objectes
     *
     * @param tx Llista d'Autobusos que han sigut recollits del fitxer autobusos.dat
     */
    private void ompliTaula(List<Taxi> tx) {

        ObservableList<Taxi> dades = FXCollections.observableArrayList();

        dades.addAll(tx);

        columnMatricula.setCellValueFactory(new PropertyValueFactory<>("matricula"));
        columnModel.setCellValueFactory(new PropertyValueFactory<>("model"));
        columnPotencia.setCellValueFactory(new PropertyValueFactory<>("potencia"));
        columnLlicencia.setCellValueFactory(new PropertyValueFactory<>("numeroLlicencia"));

        TVPantalla.setItems(dades);
        TVPantalla.getColumns().add(columnMatricula);
        TVPantalla.getColumns().add(columnModel);
        TVPantalla.getColumns().add(columnPotencia);
        TVPantalla.getColumns().add(columnLlicencia);

    }

    /**
     * Mostrarà en el RichTextBox
     * El contingut de tot el fitxer de taxis
     * extret del fitxer on estan tots els taxis guardats
     * que li passarem per paràmetre
     *
     * @param tx Llista de tipus taxis
     */
    private void mostraTaxis(List<Taxi> tx) {
        ompliTaula(tx);
//        int i;
//        for (i = 0; i < tx.size(); i++) {
//            TAPantalla.setText(TAPantalla.getText() +
//                    "\n Matricula: " + tx.get(i).getMatricula() +
//                    "\n Model: " + tx.get(i).getModel() +
//                    "\n Potencia: " + tx.get(i).getPotencia() +
//                    "\n Llicencia: " + tx.get(i).getNumeroLlicencia() + "\n\n");
//        }
        //  ***  //
    }
    //</editor-fold>


}
