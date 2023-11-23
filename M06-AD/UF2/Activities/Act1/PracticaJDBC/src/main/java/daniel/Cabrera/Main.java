package daniel.Cabrera;

import daniel.Cabrera.classes.*;

import java.sql.*;
import java.util.Scanner;

public class Main {
    static String databaseName = System.getenv("DB_NAME");
    static String url = System.getenv("DB_URL") + "/" + databaseName;
    static String username = System.getenv("DB_USERNAME");
    static String password = System.getenv("DB_PASSWORD");

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            menu(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static void menu(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            logotype();
            System.out.println("############################ Menú JDBC ############################");
            System.out.println("1. Clients");
            System.out.println("2. Artistes");
            System.out.println("3. Albums");
            System.out.println("4. Cançons");
            System.out.println("5. Estils");
            System.out.println("6. Fer venda (demanarà codi tarjeta i codi canço)");
            System.out.println("7. Llistar Vendes per Artista");
            System.out.println("8. Llistar Compres per client");
            System.out.println("0. Sortir");

            System.out.print("Introdueix una opció: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    Client.menuClient(connection);
                    break;
                case 2:
                    Artist.menuArtist(connection);
                    break;
                case 3:
                    Album.menuAlbum(connection);
                    break;
                case 4:
                    Song.menuSong(connection);
                    break;
                case 5:
                    Style.menuStyle(connection);
                    break;
                case 6:
                    Shop.buySong(connection);
                    break;
                case 7:
                    // Lógica para listar ventas por artista
                    // TODO implementar la lógica para listar las ventas por artista
                    Shop.soldArtista(connection);
                    break;
                case 8:
                    // Lógica para listar compras por cliente
                    // TODO implementar la lógica para listar las compras por cliente
                    Shop.purchasedClient(connection);
                    break;
                case 0:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void logotype() {
        System.out.println(
                "\n" +
                        "█▀▄▀█   ▄      ▄▄▄▄▄   ▄█ ▄█▄              ▄▄▄▄▄ ██▄   ███   ▄█▄    \n" +
                        "█ █ █    █    █     ▀▄ ██ █▀ ▀▄          ▄▀  █   █  █  █  █  █▀ ▀▄  \n" +
                        "█ ▄ █ █   █ ▄  ▀▀▀▀▄   ██ █   ▀              █   █   █ █ ▀ ▄ █   ▀  \n" +
                        "█   █ █   █  ▀▄▄▄▄▀     █ █▄  ▄▀          ▄ █    █  █  █  ▄▀ █▄  ▄▀ \n" +
                        "   █  █▄ ▄█             █ ▀███▀            ▀     ███▀  ███   ▀███▀  \n" +
                        "  ▀    ▀▀▀              ▀                         by Daniel Cabrera"
        );
    }
}