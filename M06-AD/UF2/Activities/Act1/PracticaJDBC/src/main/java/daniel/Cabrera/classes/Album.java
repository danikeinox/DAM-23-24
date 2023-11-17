package daniel.Cabrera.classes;

import java.sql.*;
import java.util.Scanner;

public class Album {
    public static void altaAlbum(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdueix el códi que vols donar d'alta a l'álbum: ");
        String albumCode = scanner.nextLine();
        System.out.print("Introdueix el títol que quieres anomenar a l'álbum: ");
        String albumTitle = scanner.nextLine();
        System.out.print("Introdueix el códi del Artista asociat a l'álbum: ");
        String artistCode = scanner.nextLine();
        System.out.print("Introdueix l'any del álbum: ");
        String albumYear = scanner.nextLine();
        System.out.print("Introdueix el códi del estil del álbum: ");
        String albumStyle = scanner.nextLine();

        String sql = "INSERT INTO ALBUM (code, title, artist, year, style) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, albumCode);
            statement.setString(2, albumTitle);
            statement.setString(3, artistCode);
            statement.setString(4, albumYear);
            statement.setString(5, albumStyle);
            statement.executeUpdate();
            System.out.println("Album dado de alta correctamente.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void bajaAlbum(Connection connection) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("######################### BAIXA ALBUM #########################");
        System.out.println("Introdueix el códi del álbum que vols donar de baixa: ");
        String albumCode = scanner.nextLine();
        String sql = "DELETE FROM ALBUM WHERE code = ? ";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, albumCode);
            statement.executeUpdate();
            System.out.println("Album donat de baixa correctament.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public static void viewAlbums(Connection connection) {
        String sql = "SELECT * FROM ALBUM order by artist, year, style";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            // Verificar si no hay filas en el resultSet
            if (!resultSet.isBeforeFirst()) {
                System.out.println("No existeixen albums.");
            } else {
                int i = 1;
                System.out.println("######################### ALBUMS #########################");
                while (resultSet.next()) {
                    String albumCode = resultSet.getString("code");
                    String albumTitle = resultSet.getString("title");
                    String artistCode = resultSet.getString("artist");
                    String albumYear = resultSet.getString("year");
                    String albumStyle = resultSet.getString("style");

                    System.out.println("#" + i);
                    System.out.println("Album Code: " + albumCode);
                    System.out.println("Album Title: " + albumTitle);
                    System.out.println("Artist Code: " + artistCode);
                    System.out.println("Album Year: " + albumYear);
                    System.out.println("Album Style: " + albumStyle);
                    System.out.println();
                    i++;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void menuAlbum(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int opc;
        int submenu = 0;
        do {
            System.out.println("############################ Menú ALBUM ############################");
            System.out.println("1. ALTA ALBUM");
            System.out.println("2. BAIXA ALBUM");
            System.out.println("3. VISTA ALBUMS");
            ;
            System.out.println("0. Sortir");
            System.out.print("Introdueix una opció: ");
            opc = scanner.nextInt();
            switch (opc) {
                case 1:
                    altaAlbum(connection);
                    break;
                case 2:
                    bajaAlbum(connection);
                    break;
                case 3:
                    viewAlbums(connection);
                    break;
                case 0:
                    submenu = 1;
                default:
                    System.out.println("Opció incorrecta.");
            }
        } while (submenu == 0);
    }
}
