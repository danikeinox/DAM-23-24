package daniel.Cabrera.classes;

import java.sql.*;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class Shop {
    protected static Scanner scanner = new Scanner(System.in);
    private static int venut = -1;

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
                                    System.out.println("Introdueix el ID de la tarjeta de credit: ");
                                    String cardID = scanner.nextLine();
                                    while (true) {
                                        if (resultSetCardClient.next()) {
                                            if (cardID.equals(resultSetCardClient.getString("code"))) {
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
                                            }
                                        }
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
                    System.out.println("No s'ha trobat la cançó.");
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
        String sqlClientID = "SELECT clientID FROM CLIENT WHERE clientID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sqlClientID)) {
            statement.setString(1, clientID);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Client: " + resultSet.getString("clientID"));
                String sqlCardID = "SELECT code FROM CARD WHERE client = ?";
                try (PreparedStatement statementCard = connection.prepareStatement(sqlCardID)) {
                    statementCard.setString(1, clientID);
                    ResultSet resultSetSong = statementCard.executeQuery();
                    while (true) {
                        if (resultSetSong.next()) {
                            System.out.println("    Card: " + resultSetSong.getString("code"));
                            String sqlSongID = "SELECT song FROM SALE WHERE card = ?";
                            try (PreparedStatement statementSaleSong = connection.prepareStatement(sqlSongID)) {
                                statementSaleSong.setString(1, resultSetSong.getString("code"));
                                ResultSet resultSetSongID = statementSaleSong.executeQuery();
                                while (true) {
                                    if (resultSetSongID.next()) {
                                        String sqlSongTitle = "SELECT title, code FROM SONG WHERE code = ?";
                                        try (PreparedStatement statementSongTitle = connection.prepareStatement(sqlSongTitle)) {
                                            statementSongTitle.setString(1, resultSetSongID.getString("song"));
                                            ResultSet resultSetSongTitle = statementSongTitle.executeQuery();
                                            while (true) {
                                                try {
                                                    if (resultSetSongTitle.next()) {
                                                        System.out.println("        Song: " + resultSetSongTitle.getString("title") + " (ID: " + resultSetSongTitle.getString("code") + ")");
                                                    } else {
                                                        break;
                                                    }
                                                } catch (SQLException e) {
                                                    throw new RuntimeException(e);
                                                }
                                            }
                                        } catch (SQLException e) {
                                            throw new RuntimeException(e);
                                        }
                                    } else {
                                        break;
                                    }
                                }
                            } catch (SQLException e) {
                                throw new RuntimeException(e);
                            }
                        } else {
                            break;
                        }
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

    // TODO check ventes codiArtista = "saleSong(numRows(card*song)) - songTitle"
    public static void soldArtista(Connection connection) {
        System.out.println("######################### CANÇONS VENDUES #########################");
        System.out.println("Indica el ID del artista que vols veure les seves cançóns vendudes:");
        String codiArtista = scanner.nextLine();

        String sqlArtistaID = "SELECT code, name FROM ARTIST WHERE code = ?";
        try (PreparedStatement statement = connection.prepareStatement(sqlArtistaID)) {
            statement.setString(1, codiArtista);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println("Artista: " + resultSet.getString("name") + ", (ID: " + resultSet.getString("code") + ")");
                String sqlAlbumCode = "SELECT code, title FROM ALBUM WHERE code = ?";
                try (PreparedStatement statementAlbumCode = connection.prepareStatement(sqlAlbumCode)) {
                    statementAlbumCode.setString(1, resultSet.getString("code"));
                    ResultSet resultSetAlbumCode = statementAlbumCode.executeQuery();
                    while (resultSetAlbumCode.next()) {
                        System.out.println("    Album: " + resultSetAlbumCode.getString("title") + ", (ID: " + resultSetAlbumCode.getString("code") + ")");
                        String sqlSongAlbum = "SELECT code, title FROM SONG WHERE album = ?";
                        try (PreparedStatement statementSongAlbum = connection.prepareStatement(sqlSongAlbum)) {
                            statementSongAlbum.setString(1, resultSetAlbumCode.getString("code"));
                            ResultSet resultSetSongAlbum = statementSongAlbum.executeQuery();
                            while (resultSetSongAlbum.next()) {
                                System.out.print("      Song - " + resultSetSongAlbum.getString("title") + ", (ID: " + resultSetSongAlbum.getString("code") + "): ");
                                String sqlSaleSong = "SELECT * FROM SALE WHERE song = ?";
                                try (PreparedStatement statementSaleSong = connection.prepareStatement(sqlSaleSong)) {
                                    statementSaleSong.setString(1, resultSetSongAlbum.getString("code"));
                                    ResultSet resultSetSaleSong = statementSaleSong.executeQuery();
                                    while (resultSetSaleSong.next()) {
                                        venut = venut + 1;
                                    }
                                    if (venut > 0) {
                                        System.out.println(venut + " copies venudes");
                                    }
                                } catch (SQLException e) {
                                    throw new RuntimeException(e);
                                }
                                venut = 0;
                            }
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                if (venut == -1) {
                    System.out.println("Aquest artista no te cap venta.");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
