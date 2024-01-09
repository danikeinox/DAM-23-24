package daniel.Cabrera.practicaPuntuable.classes;

import javafx.collections.ObservableList;

public enum TipusAutobus {
    Autocar, Urbà, Elèctric, Articulat, Turistic2Pissos, Turistic1Pis, Microbús;

    public static ObservableList getTipusAutobus() {
        return javafx.collections.FXCollections.observableArrayList(TipusAutobus.values());
    }
}
