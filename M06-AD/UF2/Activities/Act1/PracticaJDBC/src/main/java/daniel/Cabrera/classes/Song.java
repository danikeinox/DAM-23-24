package daniel.Cabrera.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Song {
    public static void altaSong(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdueix el códi de la cançó: ");
        String songCode = scanner.nextLine();
        System.out.print("Introdueix el titol de la cançó: ");
        String songTitle = scanner.nextLine();
        System.out.print("Introdueix el códi del álbum: ");
        String albumCode = scanner.nextLine();
        System.out.print("Introdueix el número de la cançó: ");
        String songTrack = scanner.nextLine();

        String sql = "INSERT INTO SONG (code, title, album, track) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, songCode);
            statement.setString(2, songTitle);
            statement.setString(3, albumCode);
            statement.setString(4, songTrack);
            statement.executeUpdate();
            System.out.println("Canço donada d'alta correctament.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void bajaSong(Connection connection) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("######################### BAIXA CANÇON #########################");
        System.out.println("Introdueix el códi de la cançó que vols donar de baixa: ");
        String songCode = scanner.nextLine();

        String sql = "DELETE FROM SONG WHERE code = ? ";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, songCode);
            statement.executeUpdate();
            System.out.println("Cançó donada de baixa correctament.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void viewSongs(Connection connection) {
        String sql = "SELECT * FROM SONG order by album, track";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            // Verificar si no hay filas en el resultSet
            if (!resultSet.isBeforeFirst()) {
                System.out.println("No existeixen cançons.");
            } else {
                int i = 1;
                System.out.println("######################### CANÇONS #########################");
                while (resultSet.next()) {
                    String songCode = resultSet.getString("code");
                    String songTitle = resultSet.getString("title");
                    String albumCode = resultSet.getString("album");
                    String songTrack = resultSet.getString("track");

                    System.out.println("#" + i);
                    System.out.println("Song Code: " + songCode);
                    System.out.println("Song Title: " + songTitle);
                    System.out.println("Album Code: " + albumCode);
                    System.out.println("Song Track: " + songTrack);
                    System.out.println();
                    i++;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void menuSong(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int opc;
        int submenu = 0;
        do {
            System.out.println("############################ Menú CANÇONS ############################");
            System.out.println("1. ALTA CANÇÓ");
            System.out.println("2. BAIXA CANÇÓ");
            System.out.println("3. VISTA CANÇONS");;
            System.out.println("0. Sortir");
            System.out.print("Introdueix una opció: ");
            opc = scanner.nextInt();
            switch (opc) {
                case 1:
                    altaSong(connection);
                    break;
                case 2:
                    bajaSong(connection);
                    break;
                case 3:
                    viewSongs(connection);
                    break;
                case 0:
                    submenu = 1;
                default:
                    System.out.println("Opció incorrecta.");
            }
        } while (submenu == 0);
    }
}
