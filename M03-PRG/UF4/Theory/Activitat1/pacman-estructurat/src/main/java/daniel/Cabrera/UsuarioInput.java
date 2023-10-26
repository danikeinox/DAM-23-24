package daniel.Cabrera;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class UsuarioInput {
    private KeyListener listener;

    public UsuarioInput() {
        listener = new KeyListener() {
            @Override
            public void keyPressed(KeyEvent event) {
                // Lógica para manejar las teclas presionadas
            }

            @Override
            public void keyReleased(KeyEvent event) {
                // Lógica para manejar las teclas liberadas
            }

            @Override
            public void keyTyped(KeyEvent event) {
                // Lógica para manejar las teclas presionadas y liberadas
            }
        };
    }

    public int obtenerDireccion() {
        // Lógica para obtener la dirección
        return 0;
    }

    // Otros métodos relacionados con la entrada del usuario
}
