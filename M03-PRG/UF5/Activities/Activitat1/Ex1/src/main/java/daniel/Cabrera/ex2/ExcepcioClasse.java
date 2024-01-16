package daniel.Cabrera.ex2;

public class ExcepcioClasse {

    public static void main(String[] args) {
        try {
            ExcepcioClasse ex = new ExcepcioClasse("hola", "4");
            System.out.println("Suma: " + ex.suma());
        } catch (NumberFormatException e) {
            System.out.println("Error: S'esperava un número, no un string.");
        }
    }

    private String num1;
    private String num2;

    public ExcepcioClasse(String num1, String num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int suma() {
        int n1 = Integer.parseInt(num1);
        int n2 = Integer.parseInt(num2);
        return n1 + n2;
    }
}
