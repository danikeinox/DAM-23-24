package cat.dam.psp.ex4racingcars.classes;

import javafx.scene.paint.Color;

public class ResultatCarrera implements Comparable<ResultatCarrera> {
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
        return String.format("Cotxe: %s - Temps: %d ms", colorToString(colorCotxe), temps);
    }

    private String colorToString(Color color) {
        if (color == Color.RED) return "Vermell";
        return "Desconegut";
    }
}
