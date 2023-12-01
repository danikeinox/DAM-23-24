package daniel.Cabrera.classeAbstractaPrototip.classes;


public class Alerta{
    private final String missatge;
    private String titol;


    // <editor-fold defaultstate="collapsed" desc="Propietats">
    //</editor-fold>


    // <editor-fold defaultstate="collapsed" desc="Constructors">

    public Alerta(String missatge) {
        this.missatge = missatge;
    }

    public Alerta(String missatge, String titol) {
        this.missatge = missatge;
        this.titol = titol;
    }


    //</editor-fold>


    // <editor-fold defaultstate="collapsed" desc="Mètodes">

    public void alertaError() {
        this.titol = "ERROR";
    }

    void alertaWarning() {
        this.titol = "Warning";
    }

    //</editor-fold>


}
