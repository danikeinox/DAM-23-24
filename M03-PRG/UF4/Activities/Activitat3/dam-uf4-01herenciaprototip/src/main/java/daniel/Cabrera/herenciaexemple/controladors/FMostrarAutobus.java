package daniel.Cabrera.herenciaexemple.controladors;

import daniel.Cabrera.herenciaexemple.classes.Taxi;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import daniel.Cabrera.herenciaexemple.classes.Autobus;

import java.io.IOException;
import java.util.List;


public class FMostrarAutobus {


    // <editor-fold defaultstate="collapsed" desc="Components FXML">

    @FXML
    private TextArea TAPantalla;


    //</editor-fold>


    // <editor-fold defaultstate="collapsed" desc="Mètodes">
    @FXML
    protected void initialize() throws IOException, ClassNotFoundException,
            InterruptedException, NoSuchFieldException, IllegalAccessException {
        Autobus au = new Autobus();
        TAPantalla.setText("");
        List<Autobus> llistaAutobussos = (List<Autobus>) au.retornaVehiclesEnLlista(au.getRutaFitxer(), Autobus.class);
        mostraAutobussos(llistaAutobussos);

    }

    /**
     * Omplim una TableView amb les dades de la Llista d'Objectes
     *
     * @param tx Llista d'Autobusos que han sigut recollits del fitxer autobusos.dat
     */
    private void ompliTaula(List<Autobus> tx) {

        TAPantalla.setEditable(false);
        TAPantalla.clear();
        TAPantalla.appendText("AUTOBUSOS\n");
        TAPantalla.appendText("Matricula\tModel\tPotencia\n");
        TAPantalla.appendText("-----------------------------------------------------------\n");
        mostraAutobussos(tx);

        //  OPCIONAL. HO PODEU FER EN TAULA O EN TEXT ÀREA  //

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

        int i;
        for (i = 0; i < au.size(); i++) {
            TAPantalla.setText(TAPantalla.getText() + au.get(i).toString() + "\n" + au.get(i).getNumPlaces() + "\n");
        }
      // **** //


    }
    //</editor-fold>


}
