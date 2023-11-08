package daniel.Cabrera.herenciaexemple.controladors;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import daniel.Cabrera.herenciaexemple.classes.Taxi;

import java.io.IOException;
import java.util.List;


public class FMostrarTaxis {


    // <editor-fold defaultstate="collapsed" desc="Components FXML">

    @FXML
    private TextArea TAPantalla;


    //</editor-fold>


    // <editor-fold defaultstate="collapsed" desc="Mètodes">

    /**
     * S'executa sempre que es mostre el formulari
     * @throws IOException Excepció d'E/S
     * @throws ClassNotFoundException Excepció de classe no trobada
     * @throws InterruptedException Interrupció
     * @throws NoSuchFieldException Excepció de que no troba l'arxiu
     * @throws IllegalAccessException Accés a memòria incorrecte
     */
    @FXML
    protected void initialize() throws IOException, ClassNotFoundException, InterruptedException, NoSuchFieldException, IllegalAccessException {
        Taxi tx = new Taxi();
        TAPantalla.setText("");
        List<Taxi> llistaTaxis = (List<Taxi>) tx.retornaVehiclesEnLlista(tx.getRutaFitxer(), Taxi.class);
        mostraTaxis(llistaTaxis);
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
        int i;
        for (i = 0; i < tx.size(); i++) {
            TAPantalla.setText(TAPantalla.getText() + tx.get(i).toString() + "\n");
        }
        //  ***  //

    }


    //</editor-fold>


}
