package daniel.Cabrera.practicaPuntuable.controladors;

import daniel.Cabrera.practicaPuntuable.classes.Admin;
import daniel.Cabrera.practicaPuntuable.classes.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.List;


public class FMostrarUsuaris {


    // <editor-fold defaultstate="collapsed" desc="Components FXML">

    @FXML
    private TextArea TAPantalla;

    @FXML
    private TableView<User> TVPantalla;
    @FXML
    private TableColumn<User, Object> columnUsername;
    @FXML
    private TableColumn<User, Object> columnPassword;
    @FXML
    private TableColumn<User, Object> columnName;
    @FXML
    private TableColumn<User, Object> columnSurname;
    @FXML
    private TableColumn<User, Object> columnAdmin;
    @FXML
    private TableColumn<User, Object> columnEdat;


    //</editor-fold>


    // <editor-fold defaultstate="collapsed" desc="Mètodes">
    @FXML
    protected void initialize() throws IOException, ClassNotFoundException,
            InterruptedException, NoSuchFieldException, IllegalAccessException {
        User us = new User();
        Admin ad = new Admin();
        TVPantalla.setItems(null);
        List<User> llistaUsers = (List<User>) us.retornaPersonasEnLlista(us.getRutaFitxer());
        llistaUsers.addAll((List<User>) us.retornaPersonasEnLlista(ad.getRutaFitxer()));
        // List<Persona> llistaUsers = (List<Persona>) Persona.retornaPersonasEnLlista(Admin.getRutaFitxer());
        mostraUsers(llistaUsers);

    }

    /**
     * Omplim una TableView amb les dades de la Llista d'Objectes
     *
     * @param pe Llista d'Autobusos que han sigut recollits del fitxer autobusos.dat
     */
    private void ompliTaula(List<User> pe) {

        ObservableList<User> dades = FXCollections.observableArrayList();

        dades.addAll(pe);

        columnUsername.setCellValueFactory(new PropertyValueFactory<>("username"));
        columnPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnSurname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        columnAdmin.setCellValueFactory(new PropertyValueFactory<>("admin"));
        columnEdat.setCellValueFactory(new PropertyValueFactory<>("edat"));

        TVPantalla.setItems(dades);

    }

    /**
     * Mostrarà en el RichTextBox
     * El contingut de tot el fitxer de Users
     * extret del fitxer on estan tots els Users guardats
     * que li passarem per paràmetre
     *
     * @param pe Llista de tipus Users
     */
    private void mostraUsers(List<User> pe) {
        ompliTaula(pe);
//        int i;
//        for (i = 0; i < us.size(); i++) {
//            TAPantalla.setText(TAPantalla.getText() +
//                    "\n Username: " + us.get(i).getUsername() +
//                    "\n Password: " + us.get(i).getPassword() +
//                    "\n Name: " + us.get(i).getName() +
//                    "\n Surname: " + us.get(i).getSurname() + "\n\n");
//        }
        //  ***  //
    }
    //</editor-fold>


}
