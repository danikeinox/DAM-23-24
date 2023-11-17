package daniel.Cabrera.classes;

import java.sql.*;
import java.util.Scanner;

public class Tarjeta {
    public static void altaTarjeta(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdueix el ID de la tarjeta: ");
        String tarjetaID = scanner.nextLine();
        System.out.print("Introdueix el codi de la tarjeta (16 DIGITS): ");
        String tarjetaCodi = scanner.nextLine();
        System.out.print("Introdueix el CSV de la tarjeta: ");
        String tarjetaCSV = scanner.nextLine();
        System.out.print("Introdueix la data d'exiració de la tarjeta (YYYY-MM-DD): ");
        String tarjetaExpDate = scanner.nextLine();
        System.out.print("Introdueix el codi del client de la tarjeta: ");
        String tarjetaClientID = scanner.nextLine();
        String sql = "INSERT INTO CARD (code, card_number, csv, exp_date, client) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, tarjetaID);
            statement.setString(2, tarjetaCodi);
            statement.setString(3, tarjetaCSV);
            statement.setString(4, tarjetaExpDate);
            statement.setString(5, tarjetaClientID);
            statement.executeUpdate();
            System.out.println("Tarjeta dada de alta correctamente.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void bajaTarjeta(Connection connection) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("######################### BAIXA TARJETA #########################");
        System.out.println("Introdueix el códiID de la tarjeta que vols donar de baixa: ");
        String tarjetaID = scanner.nextLine();
        String sql = "DELETE FROM CARD WHERE code = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, tarjetaID);
            statement.executeUpdate();
            System.out.println("Tarjeta donada de baixa correctament.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void viewTarjeta(Connection connection) {
        String sql = "SELECT * FROM CARD ORDER BY client";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            // Verificar si no hay filas en el resultSet
            if (!resultSet.isBeforeFirst()) {
                System.out.println("No existeixen tarjetes.");
            } else {
                int i = 1;
                System.out.println("######################### TARJETES #########################");
                while (resultSet.next()) {
                    String tarjetID = resultSet.getString("code");
                    String tarjetCodi = resultSet.getString("card_number");
                    // Add - on tarjetCodi on 4 positions
                    String part1 = tarjetCodi.substring(0, 4);
                    String part2 = tarjetCodi.substring(4, 8);
                    String part3 = tarjetCodi.substring(8, 12);
                    String part4 = tarjetCodi.substring(12, 16);
                    String tarjetCodiFormatted = part1 + "-" + part2 + "-" + part3 + "-" + part4;
                    String tarjetCSV = resultSet.getString("csv");
                    String tarjetExpDate = resultSet.getString("exp_date");
                    String tarjetClient = resultSet.getString("client");

                    System.out.println("#" + i);
                    System.out.println("Tarjet ID: " + tarjetID);
                    System.out.println("Tarjet Codi: " + tarjetCodiFormatted);
                    System.out.println("Tarjet CSV: " + tarjetCSV);
                    System.out.println("Tarjet ExpDate: " + tarjetExpDate);
                    System.out.println("Tarjet Client: " + tarjetClient);
                    System.out.println();
                    i++;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String viewTarjeta(Connection connection, String clientID) {
        String sql = "SELECT * FROM CARD WHERE client = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, clientID);
            // mostrar cuantas filas hay en el resultSet
            ResultSet resultSet = statement.executeQuery();
            // Get the current row number
            int rowCount = resultSet.getFetchSize();

            // Rest of the code to process the resultSet
            // ...
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "0";
    }
}