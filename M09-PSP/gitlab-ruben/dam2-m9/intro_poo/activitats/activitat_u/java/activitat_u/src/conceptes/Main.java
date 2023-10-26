package conceptes;

import conceptes.classes.Cap;
import conceptes.classes.Treballador;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cap cap1 = new Cap("Luis", 30000, 2010, 10, 1);
        cap1.setIncentiu(500.0);
        cap1.setSou(54000.0);

        List<Treballador> treballadors = new ArrayList<>();
        treballadors.add(new Treballador("Luis", 20000.0, 2011, 11, 15));
        treballadors.add(new Treballador("Ana", 25000.0, 2007, 7, 21));
        treballadors.add(new Treballador("Marta", 27000.0, 2007, 7, 21));
        treballadors.add(cap1); // Polimorfisme

        // De major a menor
        //treballadors.sort(Collections.reverseOrder());
        // De menor a major
        treballadors.sort(Comparator.naturalOrder());
        for (Treballador t : treballadors) {
            System.out.println(t);
        }
    }
}