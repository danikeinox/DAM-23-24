package daniel.Cabrera.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class Shop {
    protected static Scanner scanner = new Scanner(System.in);
    // TODO autocheck clientID + tarjetaID to buy songCode if tarjeta not from clientID deny purchase
    public static void buySong(Connection connection) {
        String sqlClientID = "SELECT clientID FROM CLIENT";
        String sqlSongCode = "SELECT code FROM SONG";
        System.out.println("######################### COMPRAR CANÇON #########################");
        System.out.println("Avui estem a dia: " + LocalDate.now());
        System.out.println("Introduce el códi de la cançó que vols comprar: ");
        String songCode = scanner.nextLine();
        if (Objects.equals(songCode, sqlSongCode)) {
            System.out.println("Introduce el ID del client: ");
            String clientID = scanner.nextLine();
            if (Objects.equals(clientID, sqlClientID)) {
                // select card_number from card where client = clientID
                String sqlCardID = "SELECT card_number FROM CARD WHERE client = {clientID}";
                String sqlCardNum = "SELECT card_number FROM CARD ORDER BY client";
                System.out.println("Introdueix el ID de la tarjeta de credit: ");
                String tarjetaID = scanner.nextLine();
                while (true) {
                    if (Objects.equals(tarjetaID, sqlCardNum)) {
                        System.out.println("Introdueix el ID del client de la tarjeta: ");
                        tarjetaID = scanner.nextLine();
                        if (Objects.equals(tarjetaID, sqlCardID)) {
                            break;
                        }
                    } else {
                        System.out.println("Introdueix un ID de tarjeta correcte.");
                    }
                }
                String sql = "INSERT INTO SALE (song, card, sale_date) VALUES (?, ?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setString(1, tarjetaID);
                    statement.setString(2, clientID);
                    statement.setString(3, String.valueOf(LocalDate.now()));
                    statement.executeUpdate();
                    System.out.println("Canço comprada correctament.");
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    // TODO check compres clientID = "songCode - songTitle - songArtistName"
    public static void purchasedClient(Connection connection) {
        System.out.println("######################### CANÇONS COMPRADES #########################");
        scanner.nextLine();
        String sqlClientID = "SELECT title FROM SONG WHERE code = {songCode}";
    }

    // TODO check ventes codiArtista = "saleSong(numRows(card*song)) - songTitle"
    public static void soldArtista(Connection connection) {

    }
}
