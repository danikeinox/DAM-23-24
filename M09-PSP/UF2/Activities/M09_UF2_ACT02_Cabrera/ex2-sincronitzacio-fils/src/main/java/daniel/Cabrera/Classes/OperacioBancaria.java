package daniel.Cabrera.Classes;

public abstract class OperacioBancaria {
    protected CompteBancari compte;

    public OperacioBancaria(CompteBancari compte) {
        this.compte = compte;
    }

    public abstract float quantitatAleatoria();
}
