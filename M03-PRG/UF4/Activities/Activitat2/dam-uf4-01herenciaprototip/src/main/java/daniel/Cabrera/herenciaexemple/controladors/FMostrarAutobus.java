package daniel.Cabrera.herenciaexemple.controladors;

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


     // *** //

    }

    /**
     * Omplim una TableView amb les dades de la Llista d'Objectes
     *
     * @param tx Llista d'Autobusos que han sigut recollits del fitxer autobusos.dat
     */
    private void ompliTaula(List<Autobus> tx) {

        //  OPCIONAL. HO PODEU FER EN TAULA O EN TEXT ÀREA  //

    }

    /**
     * Mostrarà en el RichTextBox
     * El contingut de tot el fitxer de taxis
     * extret del fitxer on estan tots els taxis guardats
     * que li passarem per paràmetre
     *
     * @param tx Llista de tipus taxis
     */
    private void mostraAutobussos(List<Autobus> tx) {

      // **** //


    }
    //</editor-fold>


}
