package daniel.Cabrera.classes;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Shop {

    protected static int productoId;

    public static void addProduct(String fitxer) throws IOException, JDOMException {
        try {
            Document document;
            File file = new File(fitxer);
            if (file.exists()) {
                document = new SAXBuilder().build(file);
            } else {
                document = new Document(new Element("tienda"));
            }
            productoId = Integer.parseInt(demanarText("Introdueix el ID del producte: "));
            while (true) {
                List<Element> existingProducts = document.getRootElement().getChildren("computadora");
                for (Element existingProduct : existingProducts) {
                    if (existingProduct.getAttributeValue("id").equals(String.valueOf(productoId))) {
                        System.out.println("Ja existeix un producte amb aquest ID.");
                        productoId = Integer.parseInt(demanarText("Introdueix l'ID del producte (o prem -1 per sortir): "));
                        if (productoId == -1) {
                            return;
                        }
                    }
                }
                Element producto = new Element("computadora");
                producto.setAttribute("id", String.valueOf(productoId));
                String nombre = demanarText("Introdueix el nom del producte: ");
                Float precio = Float.valueOf(demanarText("Introdueix el preu del producte: "));
                Element nombreElement = new Element("nom").setText(nombre);
                Element precioElement = new Element("preu").setText(String.valueOf(precio) + "\u20AC");
                producto.addContent(nombreElement);
                producto.addContent(precioElement);
                document.getRootElement().addContent(producto);
                XMLOutputter xmlOutput = new XMLOutputter(Format.getPrettyFormat());
                xmlOutput.output(document, new FileOutputStream(fitxer));

                System.out.println("Producte afegit amb éxit.");
                return;
            }
        } catch (JDOMException | IOException e) {
            e.printStackTrace();
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Opcio no valida");
            addProduct(fitxer);
        }
    }


    public static void viewProduct(String fitxer) throws IOException, JDOMException {
        SAXBuilder builder = new SAXBuilder();
        Document documentJDOM = builder.build(new FileInputStream(fitxer));
        Element raiz = documentJDOM.getRootElement();
        List<Element> hijosRaiz = raiz.getChildren();
        for (Element hijo : hijosRaiz) {
            String nombre = hijo.getName();
            List<Element> subhijos = hijo.getChildren();
            StringBuilder subhijosValue = new StringBuilder();
            for (Element subSubhijo : subhijos) {
                subhijosValue.append(subSubhijo.getName() + " = " + subSubhijo.getValue() + "\n\t\t");
            }
            String nombreSubhijos = subhijosValue.toString();
            String id = hijo.getAttributeValue("id");
            if (id != null) {
                System.out.println("Id: " + id);
            }
            System.out.println("\tEtiqueta: " + nombre);
            System.out.println("\t\t" + nombreSubhijos);


        }
    }

    public static void removeProduct(String fitxer) {
        try {
            Document document = new SAXBuilder().build(new File(fitxer));
            Element root = document.getRootElement();
            productoId = Integer.parseInt(demanarText("Introdueix l'ID del producte que vols eliminar: "));
            while (true) {
                List<Element> products = root.getChildren("computadora");
                for (Element product : products) {
                    if (product.getAttributeValue("id").equals(String.valueOf(productoId))) {
                        root.removeContent(product);
                        XMLOutputter xmlOutput = new XMLOutputter(Format.getPrettyFormat());
                        xmlOutput.output(document, new FileOutputStream(fitxer));
                        System.out.println("Producte eliminat amb éxit.");
                        return;
                    }
                }
                System.out.println("No s'ha trobat ningún producte amb ID " + productoId + ".");
                productoId = Integer.parseInt(demanarText("Introdueix el ID del producte (o prem -1 per sortir): "));
                if (productoId == -1) {
                    return;
                }
            }
        } catch (JDOMException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void publicProduct(String fitxer, String fitxerHTML) {
        try {
            Document document = new SAXBuilder().build(new File(fitxer));
            Element root = document.getRootElement();

            Element htmlRoot = new Element("html");
            Document htmlDocument = new Document(htmlRoot);

            Element head = new Element("head");
            Element meta = new Element("meta").setAttribute("charset", "UTF-8");
            Element link = new Element("link").setAttribute("rel", "stylesheet").setAttribute("href", "style.css");
            head.addContent(link);
            Element title = new Element("title").setText("Botiga d'Informatica");
            head.addContent(meta);
            head.addContent(title);
            htmlRoot.addContent(head);

            Element body = new Element("body");
            Element h1 = new Element("h1").setText("Botiga d'Informatica");
            body.addContent(h1);
            Element table = new Element("table");
            table.setAttribute("border", "1");

            Element trHeader = new Element("tr");
            Element thId = new Element("th").setText("ID");
            trHeader.addContent(thId);
            Element thNombre = new Element("th").setText("Nom");
            trHeader.addContent(thNombre);
            Element thPrecio = new Element("th").setText("Preu");
            trHeader.addContent(thPrecio);
            table.addContent(trHeader);

            List<Element> products = root.getChildren("computadora");
            for (Element product : products) {
                Element tr = new Element("tr");
                Element tdId = new Element("td").setText(product.getAttributeValue("id"));
                tr.addContent(tdId);
                Element tdNombre = new Element("td").setText(product.getChildText("nom"));
                tr.addContent(tdNombre);
                Element tdPrecio = new Element("td").setText(product.getChildText("preu"));
                tr.addContent(tdPrecio);
                table.addContent(tr);
            }

            body.addContent(table);
            htmlRoot.addContent(body);

            XMLOutputter xmlOutput = new XMLOutputter(Format.getPrettyFormat());
            xmlOutput.output(htmlDocument, new FileOutputStream(fitxerHTML));

            System.out.println("Página HTML generada amb éxit.");
            System.out.println(fitxerHTML);
        } catch (JDOMException | IOException e) {
            e.printStackTrace();
        }
    }

    private static String demanarText(String mensaje) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(mensaje);
        return scanner.nextLine();
    }
}
