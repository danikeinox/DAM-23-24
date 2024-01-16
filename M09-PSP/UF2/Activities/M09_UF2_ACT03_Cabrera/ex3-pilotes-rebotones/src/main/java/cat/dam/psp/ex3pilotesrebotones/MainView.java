package cat.dam.psp.ex3pilotesrebotones;

import cat.dam.psp.ex3pilotesrebotones.controller.MainViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class MainView extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(MainView.class.getResource("main-view.fxml"));
        Scene scene = new Scene(loader.load(), 440, 526);
        MainViewController controller = loader.getController(); // Obtenim el controlador. Sempre desprès de load()
        stage.setResizable(false);
        stage.setTitle("Bouncing balls");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

