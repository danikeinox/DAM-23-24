package pkgFitxers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Persona extends Metodes{

    private String nom;
    private String cognom;
    private int edat;
    private double sou;

    static String fitxer="persones.csv";
    static String fitxerDat="persones.dat";

    static Fitxers f=new Fitxers();


    public Persona() {
    }


    public Persona(String nom, String cognom, int edat, double sou) {
        this.nom = nom;
        this.cognom = cognom;
        this.edat = edat;
        this.sou = sou;
    }

    public String getFitxer() {
        return fitxer;
    }
    public String getFitxerDat() {
        return fitxerDat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognom() {
        return cognom;
    }

    public void setCognom(String cognom) {
        this.cognom = cognom;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public double getSou() {
        return sou;
    }

    public void setSou(double sou) {
        this.sou = sou;
    }


    @Override
    public String toString() {
        return nom+";"+cognom+";"+edat+";"+sou;
    }


    public void escriuPersona() throws IOException {
        //nom;cognom;edat;sou
        f.escriuTextFitxer(fitxer, String.valueOf(this),true);

    }

    public List<Persona> retornaPersones(){

        List<Persona>lPersones=new ArrayList();
        String[]personesString=f.retornaFitxerTextEnArray(fitxer,";");

        for (String str:personesString) {

            String []dades=str.split(";");

             String nom=dades[0];
             String cognom=dades[1];
             int edat= Integer.parseInt(dades[2]);
             double sou= Double.parseDouble(dades[3]);

             Persona pr=new Persona(nom,cognom,edat,sou);
             lPersones.add(pr);

        }

        return lPersones;
    }



}
