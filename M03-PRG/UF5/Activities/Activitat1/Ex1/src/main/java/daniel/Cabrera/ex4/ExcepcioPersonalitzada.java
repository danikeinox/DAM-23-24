package daniel.Cabrera.ex4;

public class ExcepcioPersonalitzada extends Exception {

    public ExcepcioPersonalitzada(String missatge) {
        super(missatge);
    }

    public double calcularArrelQuadrada(double numero) throws ExcepcioPersonalitzada {
        if (numero < 0) {
            throw new ExcepcioPersonalitzada("No es pot calcular l'arrel d'un número negatiu.");
        }
        return Math.sqrt(numero);
    }

    public static void main(String[] args) {
        try {
            ExcepcioPersonalitzada ex = new ExcepcioPersonalitzada("Missatge d'excepció personalitzada");
            double resultat = ex.calcularArrelQuadrada(5);
            System.out.println("Arrel quadrada: " + resultat);
        } catch (ExcepcioPersonalitzada e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
