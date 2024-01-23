package daniel.Cabrera;

import daniel.Cabrera.Classes.IDades;
import daniel.Cabrera.Classes.Persona;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    private static int i = 0;

    public static void main(String[] args) {

        Persona persona1 = new Persona("12345678X", "Daniel", "Cabrera", 22, "daniel@danielcabrera.es", "file.txt");

        // Métodos de la clase Object
        provarMetodesObject(persona1);

        // Métodos de la clase Class
        provarMetodesClass(persona1.getClass());
    }

    private static void provarMetodesObject(Persona persona) {
        try {
            Persona clonedPersona = (Persona) persona.clone();
            System.out.println("Provem algunes classes d'Object");
            System.out.println("\nmetode clone():\n\nObjectes sen iguals");
            if (persona.equals(clonedPersona)) {
                System.out.println("Els objectes són iguals");
            } else {
                System.out.println("Els objectes no són iguals");
            }

            // equals()
            System.out.println("\nmetode equals():\n\nEls hash de cada objecte:\n\nObjecte p: " + persona.hashCode());
            System.out.println("\nObjecte p2: " + clonedPersona.hashCode());

            // getClass()
            System.out.println("\nmetode getClass():\n\nEl nom de la classe és: " + persona.getClass().getName());

            // getFields()
            System.out.println("\nTotes les propietats de la classe: (getFields() )");
            for (Field field : persona.getClass().getFields()) {
                System.out.println("propietat " + field.getName() + ": " + field);
            }

            // getMethods()
            System.out.println("\nTots els mètodes de la classe: (getMethods() )");
            for (Method method : persona.getClass().getMethods()) {
                System.out.println("mètode "+ i +" " + method.getName() + ": " + method);
                i++;
            }

            // hashCode() de les propietats
            System.out.println("\nHASH de totes les propietats de la classe: (hashCode)");
            System.out.println("El HashCode de fitxer és " + persona.getFitxer().hashCode());
            System.out.println("El HashCode de directori és " + IDades.directori.hashCode());

            // toString()
            System.out.println("\nDades encapsulades dins de l'objecte: (toString)");
            System.out.println(persona.toString());

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    private static void provarMetodesClass(Class<?> clazz) {
        // hashCode() de la classe
        System.out.println("\nHASH de la classe: (hashCode)");
        System.out.println("EL HashCode de la classe és " + clazz.hashCode());
    }
}
