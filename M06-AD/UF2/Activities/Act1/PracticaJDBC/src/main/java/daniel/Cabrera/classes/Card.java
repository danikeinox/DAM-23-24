package daniel.Cabrera.classes;

import java.sql.*;
import java.util.Scanner;

public class Card {
    public static void altaCard(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdueix el ID de la tarjeta: ");
        String cardID = scanner.nextLine();
        System.out.print("Introdueix el codi de la tarjeta (16 DIGITS): ");
        String cardCodi = scanner.nextLine();
        System.out.print("Introdueix el CSV de la tarjeta: ");
        String cardCSV = scanner.nextLine();
        System.out.print("Introdueix la data d'exiració de la tarjeta (YYYY-MM-DD): ");
        String cardExpDate = scanner.nextLine();
        System.out.print("Introdueix el codi del client de la tarjeta: ");
        String cardClientID = scanner.nextLine();
        while (true) {
            String sqlCheckArtist = "SELECT * FROM CARD WHERE code = ?";
            try (PreparedStatement statementCheckCard = connection.prepareStatement(sqlCheckArtist)) {
                statementCheckCard.setString(1, cardID);
                ResultSet resultSet = statementCheckCard.executeQuery();
                if (!resultSet.next() || resultSet.getString("code").equals(cardID)) {
                    System.out.println("Ja existeix una tarjeta amb aquest codi.");
                    System.out.print("Introdueix el ID de la tarjeta. (prem -1 per sortir):");
                    cardID = scanner.nextLine();
                    if (cardID.equals("-1")) {
                        return;
                    }
                } else {
                    String sql = "INSERT INTO CARD (code, card_number, csv, exp_date, client) VALUES (?, ?, ?, ?, ?)";
                    try (PreparedStatement statement = connection.prepareStatement(sql)) {
                        statement.setString(1, cardID);
                        statement.setString(2, cardCodi);
                        statement.setString(3, cardCSV);
                        statement.setString(4, cardExpDate);
                        statement.setString(5, cardClientID);
                        statement.executeUpdate();
                        System.out.println("Tarjeta donada d'alta correctament.");
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void bajaCard(Connection connection) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("######################### BAIXA TARJETA #########################");
        System.out.println("Introdueix el códiID de la tarjeta que vols donar de baixa: ");
        String cardID = scanner.nextLine();

        while (true) {
            String sqlCheckArtist = "SELECT * FROM CARD WHERE code = ?";
            try (PreparedStatement statementCheckCard = connection.prepareStatement(sqlCheckArtist)) {
                statementCheckCard.setString(1, cardID);
                ResultSet resultSet = statementCheckCard.executeQuery();
                if (!resultSet.next() || !resultSet.getString("code").equals(cardID)) {
                    System.out.println("No existeix ningúna tarjeta amb aquest codi.");
                    System.out.println("Introdueix el códiID de la tarjeta que vols donar de baixa. (prem -1 per sortir):");
                    cardID = scanner.nextLine();
                    if (cardID.equals("-1")) {
                        return;
                    }
                } else {
                    String sql = "DELETE FROM CARD WHERE code = ?";
                    try (PreparedStatement statement = connection.prepareStatement(sql)) {
                        statement.setString(1, cardID);
                        statement.executeUpdate();
                        System.out.println("Tarjeta donada de baixa correctament.");
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void viewCard(Connection connection) {
        String sql = "SELECT * FROM CARD ORDER BY client";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            // Verificar si no hay filas en el resultSet
            if (!resultSet.next()) {
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

    public static String viewCard(Connection connection, String clientID) {
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