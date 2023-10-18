package daniel.Cabrera.act1_fitxers.Controladors;

import daniel.Cabrera.act1_fitxers.Classes.Llibre;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lib.pkgFitxers.Fitxers;

import java.io.IOException;
import java.util.List;

public class LlibreController {
    @FXML
    private AnchorPane apCreant;
    @FXML
    private TextField tfNumpag;
    @FXML
    private TextField tfAny;
    @FXML
    private TextField tfColor;
    @FXML
    private TextField tfDimensions;
    @FXML
    private TextField tfTitle;
    @FXML
    private TextField tfAutor;
    @FXML
    private TextField tfContingut;
    @FXML
    private Button btSave;
    @FXML
    private Button btShow;
    @FXML
    private AnchorPane apMostrant;
    @FXML
    private Button btAnterior;
    @FXML
    private Button btTornar;
    @FXML
    private Button btSeguent;
    @FXML
    private Label lbNumpag;
    @FXML
    private Label lbContingut;
    @FXML
    private Label lbAutor;
    @FXML
    private Label lbTitol;
    @FXML
    private Label lbDimension;
    @FXML
    private Label lbColor;
    @FXML
    private Label lbAny;

    private final Fitxers f = new Fitxers();
    private List<Llibre> llibres; // Lista de libros
    private int index = 0;

    @FXML
    protected void onSaveButtonClick() throws IOException {
        String title = tfTitle.getText();
        String autor = tfAutor.getText();
        String contingut = tfContingut.getText();
        double dimensions = Double.parseDouble(tfDimensions.getText());
        String color = tfColor.getText();
        int any = Integer.parseInt(tfAny.getText());
        int numPag = Integer.parseInt(tfNumpag.getText());

        if (title.isEmpty() || autor.isEmpty() || contingut.isEmpty() || color.isEmpty()) {
            System.out.println("Error: Todos los campos obligatorios deben estar llenos.");
        } else {
            Llibre newLlibre = new Llibre(title, autor, contingut, dimensions, color, any, numPag);
            newLlibre.guardaLlibreObjecte(); // Guarda las datos del Llibre al archivo
            tfTitle.clear();
            tfAutor.clear();
            tfContingut.clear();
            tfDimensions.clear();
            tfColor.clear();
            tfAny.clear();
            tfNumpag.clear();
            btShow.setDisable(false);
        }
    }

    @FXML
    protected void onShowButtonClick() {
        llibres = Llibre.retornaLlibresFitxerBinariEnLlista(); // Obtiene la lista de libros
        if (llibres.size() > 0) {
            mostrarLibroEnVista();
            checkLeftRight();
        } else {
            System.out.println("No hay libros guardados.");
        }
        apMostrant.setDisable(false);
        apCreant.setDisable(true);
    }

    private void mostrarLibroEnVista() {
        if (index >= 0 && index < llibres.size()) {
            Llibre libro = llibres.get(index);
            lbTitol.setText(libro.getTitol());
            lbAutor.setText(libro.getAutor());
            lbContingut.setText(libro.getContingutLlibre());
            lbDimension.setText(String.valueOf(libro.getDimensions()));
            lbColor.setText(libro.getColor());
            lbAny.setText(String.valueOf(libro.getAny()));
            lbNumpag.setText(String.valueOf(libro.getNumPag()));
        }
    }

    @FXML
    protected void onTornarButtonClick() {
        lbTitol.setText("");
        lbAutor.setText("");
        lbContingut.setText("");
        lbDimension.setText("");
        lbColor.setText("");
        lbAny.setText("");
        lbNumpag.setText("");
        apMostrant.setDisable(true);
        apCreant.setDisable(false);
    }

    @FXML
    protected void onLeftButtonClick() {
        index--;
        mostrarLibroEnVista();
        checkLeftRight();
    }

    @FXML
    protected void onRightButtonClick() {
        index++;
        mostrarLibroEnVista();
        checkLeftRight();
    }

    private void checkLeftRight() {
        if (index <= 0) {
            btAnterior.setDisable(true);
        } else {
            btAnterior.setDisable(false);
        }

        if (index >= llibres.size() - 1) {
            btSeguent.setDisable(true);
        } else {
            btSeguent.setDisable(false);
        }
    }
}
