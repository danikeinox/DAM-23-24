package daniel.Cabrera.practicaPuntuable.controladors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import daniel.Cabrera.practicaPuntuable.classes.Autobus;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.List;


public class FMostrarAutobus {


    // <editor-fold defaultstate="collapsed" desc="Components FXML">

    @FXML
    private TextArea TAPantalla;

    @FXML
    private TableView<Autobus> TVPantalla;

    @FXML
    private TableColumn<Autobus, String> columnMatricula;

    @FXML
    private TableColumn<Autobus, String> columnModel;

    @FXML
    private TableColumn<Autobus, Double> columnPotencia;

    @FXML
    private TableColumn<Autobus, Integer> columnPlaces;


    //</editor-fold>


    // <editor-fold defaultstate="collapsed" desc="Mètodes">
    @FXML
    protected void initialize() throws IOException, ClassNotFoundException,
            InterruptedException, NoSuchFieldException, IllegalAccessException {
        Autobus au = new Autobus();
        TVPantalla.setItems(null);
        List<Autobus> llistaAutobussos = (List<Autobus>) au.retornaVehiclesEnLlista(au.getRutaFitxer());
        mostraAutobussos(llistaAutobussos);

    }

    /**
     * Omplim una TableView amb les dades de la Llista d'Objectes
     *
     * @param au Llista d'Autobusos que han sigut recollits del fitxer autobusos.dat
     */
    private void ompliTaula(List<Autobus> au) {

        ObservableList<Autobus> dades = FXCollections.observableArrayList();

        dades.addAll(au);

        columnMatricula.setCellValueFactory(new PropertyValueFactory<>("matricula"));
        columnModel.setCellValueFactory(new PropertyValueFactory<>("model"));
        columnPotencia.setCellValueFactory(new PropertyValueFactory<>("potencia"));
        columnPlaces.setCellValueFactory(new PropertyValueFactory<>("numPlaces"));

        TVPantalla.setItems(dades);
        TVPantalla.getColumns().add(columnMatricula);
        TVPantalla.getColumns().add(columnModel);
        TVPantalla.getColumns().add(columnPotencia);
        TVPantalla.getColumns().add(columnPlaces);

    }

    /**
     * Mostrarà en el RichTextBox
     * El contingut de tot el fitxer de taxis
     * extret del fitxer on estan tots els taxis guardats
     * que li passarem per paràmetre
     *
     * @param au Llista de tipus Autobusos
     */
    private void mostraAutobussos(List<Autobus> au) {
        ompliTaula(au);
//        int i;
//        for (i = 0; i < au.size(); i++) {
//            TAPantalla.setText(TAPantalla.getText() +
//                    "\n Matricula: " + au.get(i).getMatricula() +
//                    "\n Model: " + au.get(i).getModel() +
//                    "\n Potencia: " + au.get(i).getPotencia() +
//                    "\n Places: " + au.get(i).getNumPlaces() + "\n\n");
//        }
        // **** //
    }
    //</editor-fold>


}
