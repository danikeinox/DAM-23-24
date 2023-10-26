package conceptes.classes;

public class Cap extends Treballador {
    private double incentiu;

    public Cap(String nom, double sou, int any, int mes, int dia) {
        super(nom, sou, any, mes, dia);
    }

    public void setIncentiu(double incentiu) {
        this.incentiu = incentiu;
    }

    public double getSou() {
        double souCap = super.getSou();
        return souCap + incentiu;

    }
}
