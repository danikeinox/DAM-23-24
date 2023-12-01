package cat.dam.psp.activitat_dos.controllers;

import cat.dam.psp.activitat_dos.excepctions.EMailException;
import cat.dam.psp.activitat_dos.excepctions.NTelefonException;
import cat.dam.psp.activitat_dos.excepctions.NomException;
import cat.dam.psp.activitat_dos.utils.Utils;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {
    private static final String DEFAULT_FILE = "resultat.txt";
    private static final int MAX_TEL = 9;
    @FXML
    TextField tfNom, tfTel, tfEmail;
    @FXML
    Label lblError;

    @FXML
    Button btDesa;

    @FXML
    TextArea taResultat;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btDesa.setDisable(true);
        lblError.setText("");
        taResultat.clear();
    }

    public void btTestOnAction(ActionEvent actionEvent) throws NTelefonException, NomException, EMailException {
        boolean val = validateFields();
        if (val) {
            btDesa.setDisable(false);
            taResultat.setText(String.format("Nom: %s\n Telèfon: %s\n Correu: %s\n", tfNom.getText(), tfTel.getText(), tfEmail.getText()));
        }
    }

    @FXML
    public void btDesaOnAction(ActionEvent actionEvent) {
        try {
            if (validateFields()) {
                Utils.saveToFile(DEFAULT_FILE, taResultat.getText());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Informació");
                alert.setHeaderText(null);
                alert.setContentText("El fitxer s'ha desat correctament");
                alert.showAndWait();
            }
        } catch (NomException | NTelefonException | EMailException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void btSurtOnAction(ActionEvent actionEvent) {
        Platform.exit();
    }

    private boolean validateFields() throws NomException, NTelefonException, EMailException {
        if (tfNom.getText().isEmpty()) {
            lblError.setText("El valor introduït no és vàlid");
            tfNom.requestFocus();
            throw new NomException("El valor introduït no és vàlid");
        }

        if (tfTel.getText().length() < MAX_TEL) {
            lblError.setText("Els nombre de telèfon han de ser de " + MAX_TEL + " caràcters");
            tfTel.requestFocus();
            tfTel.selectAll();
            throw new NTelefonException("Els nombre de telèfon han de ser de " + MAX_TEL + " caràcters");
        }

        if (!Utils.validateEmail(tfEmail.getText())) {
            lblError.setText("El format del correu electrònic no es correcte.");
            tfEmail.requestFocus();
            throw new EMailException("El format del correu electrònic no es correcte.");
        }
        return true;
    }

    public void btTestOnMouseClicked(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseButton.PRIMARY) {
            System.out.println("Botó primari");
        }
    }
}
