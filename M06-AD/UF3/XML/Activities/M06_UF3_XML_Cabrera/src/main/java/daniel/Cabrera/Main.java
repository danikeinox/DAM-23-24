package daniel.Cabrera;

import org.jdom2.JDOMException;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static daniel.Cabrera.classes.Shop.*;

public class Main {
    protected static Scanner scan = new Scanner(System.in);
    private static String fitxer = "C:\\Users\\K3IN0X\\Documents\\GitHub\\DAM-23-24\\M06-AD\\UF3\\XML\\Activities\\M06_UF3_XML_Cabrera\\src\\main\\resources\\tienda.xml";
    private static String fitxerHTML = "C:\\Users\\K3IN0X\\Documents\\GitHub\\DAM-23-24\\M06-AD\\UF3\\XML\\Activities\\M06_UF3_XML_Cabrera\\src\\main\\resources\\tienda.html";

    public static void main(String[] args) throws IOException, JDOMException {
        while (true) {
            menu();
            try {
                int op = scan.nextInt();
                switch (op) {
                    case 1:
                        addProduct(fitxer);
                        break;
                    case 2:
                        removeProduct(fitxer);
                        break;
                    case 3:
                        publicProduct(fitxer, fitxerHTML);
                        break;
                    case 4:
                        viewProduct(fitxer);
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Opcio no valida");
                        break;
                }
            } catch (IOException | JDOMException e) {
                e.printStackTrace();
            } catch (InputMismatchException e) {
                System.out.println("Opcio no valida");
                scan.next();
            }
        }
    }

    public static void menu() {
        System.out.println("########## MENU ##########");
        System.out.println("1. Afegir Producte");
        System.out.println("2. Eliminar Producte");
        System.out.println("3. Publicar");
        System.out.println("4. Ver Productes");
        System.out.println("0. Tancar");
    }
}