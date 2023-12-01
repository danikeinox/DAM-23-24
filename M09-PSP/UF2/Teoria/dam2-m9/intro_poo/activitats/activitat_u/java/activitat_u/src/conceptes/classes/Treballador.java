package conceptes.classes;

import java.util.Date;
import java.util.GregorianCalendar;


public class Treballador implements Comparable {

    private static final Seccio DEFAULT_SECTION = Seccio.ADMINISTRACIO;

    private final String nom;
    private double sou;
    private final Seccio seccio;
    private final Date altaContracte;

    public Treballador(String nom, double sou, int any, int mes, int dia) {
        this.nom = nom;
        this.sou = sou;
        this.seccio = DEFAULT_SECTION;
        this.altaContracte = new GregorianCalendar(any, mes, dia).getTime();
    }

    public Treballador(String nom, double sou, Seccio seccio, int any, int mes, int dia) {
        this.nom = nom;
        this.sou = sou;
        this.seccio = seccio;

        GregorianCalendar calendari = new GregorianCalendar(any, mes, dia);
        this.altaContracte = calendari.getTime();
    }

    public Treballador() {
        this("Treballador", 20000, DEFAULT_SECTION, 1990, 1, 1);
    }

    public String getNom() {
        return nom;
    }

    public double getSou() {
        return sou;
    }

    public Seccio getSeccio() {
        return seccio;
    }

    public void setSou(double sou) {
        this.sou = sou;
    }

    public Date getAltaContracte() {
        return altaContracte;
    }

    public void augmentaSou(double percentatge) {
        sou += sou * percentatge / 100;
    }

    //metode que estem obligats a implementar amb la interface Comparable
    public int compareTo(Object objecte) {
//        if (this.sou < ((Treballador) objecte).getSou())
//            return -1;
//        else if (this.sou > ((Treballador) objecte).getSou())
//            return 1;
//        else
//            return 0;
        return Double.compare(this.sou, ((Treballador) objecte).getSou());
    }

    @Override
    public String toString() {
        return "El nom és " + this.getNom() + "\n" +
                "El sou és " + this.getSou() + "\n" +
                "La secció és " + this.getSeccio().getDescripcio() + "\n" +
                "La data de contracctació és " + this.getAltaContracte() + "\n";
    }
}