package daniel.Cabrera.classes;

import java.sql.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class Shop {
    protected static Scanner scanner = new Scanner(System.in);

    // TODO autocheck clientID + cardID to buy songCode if tarjeta not from clientID deny purchase
    public static void buySong(Connection connection) throws SQLException {
        System.out.println("######################### COMPRAR CANÇON #########################");
        System.out.println("Avui estem a dia: " + LocalDate.now());
        System.out.println("Introdueix el códi de la cançó que vols comprar: ");
        String songCode = scanner.nextLine();
        while (true) {
            String sqlSongCode = "SELECT code FROM SONG WHERE code = ?";
            try (PreparedStatement statement = connection.prepareStatement(sqlSongCode)) {
                statement.setString(1, songCode);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    System.out.println("Introduce el ID del client: ");
                    String clientID = scanner.nextLine();
                    while (true) {
                        String sqlClientID = "SELECT clientID FROM CLIENT WHERE clientID= ?";
                        try (PreparedStatement statementClient = connection.prepareStatement(sqlClientID)) {
                            statementClient.setString(1, clientID);
                            ResultSet resultSetClient = statementClient.executeQuery();
                            if (resultSetClient.next()) {
                                String sqlCardID = "SELECT card_number, code FROM CARD WHERE client = ?";
                                try (PreparedStatement statementCardClient = connection.prepareStatement(sqlCardID)) {
                                    statementCardClient.setString(1, clientID);
                                    ResultSet resultSetCardClient = statementCardClient.executeQuery();
                                    if (resultSetCardClient.next()) {
                                        System.out.println("Introdueix el ID de la tarjeta de credit: ");
                                        String cardID = scanner.nextLine();
                                        while (true) {
                                            if (cardID.equals(resultSetCardClient.getString("code"))) {
                                                break;
                                            } else {
                                                System.out.println("La tarjeta no es del client.");
                                                System.out.println("Introdueix un ID de tarjeta correcte. (prem -1 per sortir): ");
                                                cardID = scanner.nextLine();
                                                if (cardID.equals("-1")) {
                                                    return;
                                                }
                                            }
                                        }
                                        String sqlCheckSale = "SELECT * FROM SALE WHERE song = ? AND card = ?";
                                        try (PreparedStatement statementCheckSale = connection.prepareStatement(sqlCheckSale)) {
                                            statementCheckSale.setString(1, songCode);
                                            statementCheckSale.setString(2, cardID);
                                            ResultSet resultSetCheckSale = statementCheckSale.executeQuery();
                                            if (resultSetCheckSale.next()) {
                                                System.out.println("La cançó ja s'ha comprat anteriorment el: " + resultSetCheckSale.getString("sale_date"));
                                                return;
                                            } else {
                                                String sqlSale = "INSERT INTO SALE (song, card, sale_date) VALUES (?, ?, ?)";
                                                try (PreparedStatement statementSale = connection.prepareStatement(sqlSale)) {
                                                    statementSale.setString(1, songCode);
                                                    statementSale.setString(2, cardID);
                                                    statementSale.setString(3, String.valueOf(LocalDate.now()));
                                                    statementSale.executeUpdate();
                                                    System.out.println("Canço comprada correctament.");
                                                    return;
                                                } catch (SQLException e) {
                                                    System.out.println("Error al comprar cançó.");
                                                    throw new RuntimeException(e);
                                                }
                                            }
                                        } catch (SQLException e) {
                                            throw new RuntimeException(e);
                                        }
                                    } else {
                                        System.out.println("No s'ha trobat la tarjeta.");
                                    }
                                } catch (SQLException e) {
                                    throw new RuntimeException(e);
                                }
                            } else {
                                System.out.println("No s'ha trobat el client.");
                                System.out.println("Introdueix un client correcte. (prem -1 per sortir): ");
                                clientID = scanner.nextLine();
                                if (clientID.equals("-1")) {
                                    return;
                                }
                            }
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                } else {
                    System.out.println("No s'ha trobat el cançó.");
                    System.out.println("Introdueix un cançó correcte. (prem -1 per sortir): ");
                    songCode = scanner.nextLine();
                    if (songCode.equals("-1")) {
                        return;
                    }
                }
            } catch (
                    SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }

    // TODO check compres clientID = "songCode - songTitle - songArtistName"
    // comprobar clientID = client (clientID), comprobar clientID = card (clientID) = sacar card code (cardID), comprobar cardID = sale card (cardID) = sacar sale song (songID), comprobar songID = song code (songID), sacar title (songTitle), sacar album (songAlbum), songAlbum = album artist (songArtistID), sacar artist (songArtistName)
    public static void purchasedClient(Connection connection) {
        System.out.println("######################### CANÇONS COMPRADES #########################");
        System.out.println("Indica el ID del client que vols veure les seves cançóns comprades:");
        String clientID = scanner.nextLine();
        String sqlClientID = "SELECT code, title FROM SONG WHERE code = ?";
        try (PreparedStatement statement = connection.prepareStatement(sqlClientID)) {
            statement.setString(1, clientID);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getString("title"));
            }
            if (resultSet.wasNull()) {
                System.out.println("No s'ha trobat cap cançó comprada per a aquest client.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // TODO check ventes codiArtista = "saleSong(numRows(card*song)) - songTitle"
    public static void soldArtista(Connection connection) {

    }
}
