package cat.dam.psp.ex4racingcars.classes;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.util.HashMap;
import java.util.Map;

public class ResultatCarrera extends Node implements Comparable<ResultatCarrera> {
    private Color colorCotxe;
    private long temps;

    public ResultatCarrera(Color colorCotxe, long temps) {
        this.colorCotxe = colorCotxe;
        this.temps = temps;
    }

    @Override
    public int compareTo(ResultatCarrera altre) {
        return Long.compare(this.temps, altre.temps);
    }

    @Override
    public String toString() {
        return String.format("\nCotxe: %s - Temps: %d ms\n", colorToString(colorCotxe), temps);
    }

    private static final Map<Color, String> COLOR_NAMES = new HashMap<>();
    static {
        COLOR_NAMES.put(Color.RED, "Vermell");
        COLOR_NAMES.put(Color.GREEN, "Verd");
        COLOR_NAMES.put(Color.BLUE, "Blau");
        COLOR_NAMES.put(Color.PURPLE, "Violeta");
    }

    private String colorToString(Color color) {
        return COLOR_NAMES.getOrDefault(color, "Desconegut");
    }

    @Override
    public Node getStyleableNode() {
        return super.getStyleableNode();
    }
}
