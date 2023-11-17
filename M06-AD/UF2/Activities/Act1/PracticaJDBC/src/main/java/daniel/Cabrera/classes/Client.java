package daniel.Cabrera.classes;

import java.sql.*;
import java.util.Scanner;

public class Client {
    public static void menuClient(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int opc;
        int submenu = 0;
        do {
            System.out.println("############################ Menú CLIENTS ############################");
            System.out.println("1. ALTA CLIENT");
            System.out.println("»»» 4. ALTA TARJETA");
            System.out.println("2. BAIXA CLIENT");
            System.out.println("»»» 5. BAIXA TARJETA");
            System.out.println("3. VISTA CLIENT");
            System.out.println("»»» 6. VISTA TARJETA");
            System.out.println("0. Sortir");
            System.out.print("Introdueix una opció: ");
            opc = scanner.nextInt();
            switch (opc) {
                case 1:
                    altaClient(connection);
                    break;
                case 2:
                    bajaClient(connection);
                    break;
                case 3:
                    viewClients(connection);
                    break;
                case 4:
                    Tarjeta.altaTarjeta(connection);
                    break;
                case 5:
                    Tarjeta.bajaTarjeta(connection);
                    break;
                case 6:
                    Tarjeta.viewTarjeta(connection);
                    break;
                case 0:
                    submenu = 1;
                default:
                    System.out.println("Opció incorrecta.");
            }
        } while (submenu == 0);
    }

    public static void altaClient(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el código del client: ");
        String clientID = scanner.nextLine();
        System.out.print("Introduce el nombre del client: ");
        String clientName = scanner.nextLine();
        System.out.print("Introduce el primer cognom del client: ");
        String clientSurname1 = scanner.nextLine();
        System.out.print("Introduce el segon cognom del client: ");
        String clientSurname2 = scanner.nextLine();
        System.out.print("Introduce la regió del client: ");
        String clientRegion = scanner.nextLine();
        String sql = "INSERT INTO CLIENT (clientID, name, surname1, surname2, region) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, clientID);
            statement.setString(2, clientName);
            statement.setString(3, clientSurname1);
            statement.setString(4, clientSurname2);
            statement.setString(5, clientRegion);
            statement.executeUpdate();
            System.out.println("Client dado de alta correctamente.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void bajaClient(Connection connection) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("######################### BAIXA CLIENT #########################");
        System.out.println("Introduce el código del client que quieres dar de baja: ");
        String clientID = scanner.nextLine();
        String sql = "DELETE FROM CLIENT WHERE clientID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, clientID);
            statement.executeUpdate();
            System.out.println("Client dado de baja correctamente.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void viewClients(Connection connection) {
        String sql = "SELECT * FROM CLIENT ORDER BY clientID";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            // Verificar si no hay filas en el resultSet
            if (!resultSet.isBeforeFirst()) {
                System.out.println("No existen clients.");
            } else {
                int i = 1;
                System.out.println("######################### CLIENTS #########################");
                while (resultSet.next()) {
                    String clientID = resultSet.getString("clientID");
                    String clientName = resultSet.getString("name");
                    String clientSurname1 = resultSet.getString("surname1");
                    String clientSurname2 = resultSet.getString("surname2");
                    String clientRegion = resultSet.getString("region");

                    System.out.println("#" + i);
                    System.out.println("Client ID: " + clientID);
                    System.out.println("Client Name: " + clientName);
                    System.out.println("Client Surname1: " + clientSurname1);
                    System.out.println("Client Surname2: " + clientSurname2);
                    System.out.println("Client Region: " + clientRegion);
                    System.out.println("Client Cards: " + Tarjeta.viewTarjeta(connection, clientID));
                    System.out.println();
                    i++;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
