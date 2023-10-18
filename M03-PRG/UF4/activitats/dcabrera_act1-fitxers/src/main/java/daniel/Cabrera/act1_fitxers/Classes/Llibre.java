package daniel.Cabrera.act1_fitxers.Classes;

import lib.pkgFitxers.Fitxers;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Llibre implements Serializable {

    private String titol;
    private int numPag;
    private double dimensions;
    private String autor;
    private String color;
    private int any;
    private String contingut;

    // Ruta dels fitxers de dades
    private static final String dir = ".fitxers";
    private static final String fitxerDat = dir + "/llibres.dat";
    private static final String fitxerCsv = dir + "/llibres.csv";

    private static Fitxers f = new Fitxers();

    public Llibre() {
    }

    public Llibre(String titol, String autor, String contingut, double dimensions, String color, int any, int numPag) {
        this.titol = titol;
        this.autor = autor;
        this.contingut = contingut;
        this.dimensions = dimensions;
        this.color = color;
        this.any = any;
        this.numPag = numPag;
    }

    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public int getNumPag() {
        return numPag;
    }

    public void setNumPag(int numPag) {
        this.numPag = numPag;
    }

    public double getDimensions() {
        return dimensions;
    }

    public void setDimensions(double dimensions) {
        this.dimensions = dimensions;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAny() {
        return any;
    }

    public void setAny(int any) {
        this.any = any;
    }

    public String getContingutLlibre() {
        return contingut;
    }

    public void setContingutLlibre(String contingutLlibre) {
        this.contingut = contingutLlibre;
    }

    public static List<Llibre> retornaLlibresFitxerBinariEnLlista() {
        try {
            if (!f.existeix(fitxerDat)) {
                return new ArrayList<>();
            }
            List<Object> objs = f.retornaFitxerObjecteEnLlista(fitxerDat);
            return converteixALlistaObjectesLlibre(objs);
        } catch (IOException | ClassNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public void guardaLlibreObjecte() {
        try {
            if (!f.existeix(dir)) {
                f.creaDirectori(dir);
            }
            f.escriuObjecteFitxer(this, fitxerDat, true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Llibre> converteixALlistaObjectesLlibre(List<Object> Lobj) {
        List<Llibre> llistallibres = new ArrayList<>();
        for (Object obj : Lobj) {
            if (obj instanceof Llibre) {
                llistallibres.add((Llibre) obj);
            }
        }
        return llistallibres;
    }

    @Override
    public String toString() {
        return "Llibre{" +
                "titol='" + titol + '\'' +
                ", numPag=" + numPag +
                ", dimensions=" + dimensions +
                ", autor='" + autor + '\'' +
                ", color='" + color + '\'' +
                ", any=" + any +
                ", contingutLlibre='" + contingut + '\'' +
                '}';
    }
}
