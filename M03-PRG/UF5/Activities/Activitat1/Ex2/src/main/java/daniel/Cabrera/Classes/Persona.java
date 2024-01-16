package daniel.Cabrera.Classes;

public class Persona implements IDades, Cloneable {
    private String dni;
    private String nom;
    private String cognom1;
    private int edat;
    private String correuElect;
    private String fitxer;

    public Persona(String dni, String nom, String cognom1, int edat, String correuElect, String fitxer) {
        this.dni = dni;
        this.nom = nom;
        this.cognom1 = cognom1;
        this.edat = edat;
        this.correuElect = correuElect;
        this.fitxer = fitxer;
    }

    // Getters y Setters

    @Override
    public String getDni() {
        return dni;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public String getCognom1() {
        return cognom1;
    }

    @Override
    public int getEdat() {
        return edat;
    }

    @Override
    public String getCorreuElect() {
        return correuElect;
    }

    @Override
    public String getFitxer() {
        return fitxer;
    }

    // Métodos de la clase Object

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Persona persona = (Persona) obj;
        return dni.equals(persona.dni);
    }

    @Override
    public int hashCode() {
        return dni.hashCode();
    }

    @Override
    public String toString() {
        return "Persona{" +
                "dni='" + dni + '\'' +
                ", nom='" + nom + '\'' +
                ", cognom1='" + cognom1 + '\'' +
                ", edat=" + edat +
                ", correuElect='" + correuElect + '\'' +
                '}';
    }
}

