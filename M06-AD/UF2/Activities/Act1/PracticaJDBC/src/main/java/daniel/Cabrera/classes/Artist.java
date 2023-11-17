package daniel.Cabrera.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Artist {
    public static void altaArtista(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el código del artista: ");
        String artistCode = scanner.nextLine();
        System.out.print("Introduce el nombre del artista: ");
        String artistName = scanner.nextLine();

        String sql = "INSERT INTO ARTIST (code, name) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, artistCode);
            statement.setString(2, artistName);
            statement.executeUpdate();
            System.out.println("Artista dado de alta correctamente.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void bajaArtista(Connection connection) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("######################### BAIXE ARTISTA #########################");
        System.out.println("Introduce el código del artista que quieres dar de baja: ");
        String artistCode = scanner.nextLine();

        String sql = "DELETE FROM ARTIST WHERE code = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, artistCode);
            statement.executeUpdate();
            System.out.println("Artista dado de baja correctamente.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void viewArtistes(Connection connection) {
        String sql = "SELECT * FROM ARTIST";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            // Verificar si no hay filas en las columnas
            if (!resultSet.isBeforeFirst()) {
                System.out.println("No existen artistes.");
            } else {
                int i = 1;
                System.out.println("######################### ARTISTES #########################");
                while (resultSet.next()) {
                    String artistCode = resultSet.getString("code");
                    String artistName = resultSet.getString("name");

                    System.out.println("#" + i);
                    System.out.println("Artist Code: " + artistCode);
                    System.out.println("Artist Name: " + artistName);
                    System.out.println();
                    i++;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void menuArtist(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int opc;
        int submenu = 0;
        do {
            System.out.println("############################ Menú ARTISTES ############################");
            System.out.println("1. ALTA ARTISTA");
            System.out.println("2. BAIXA ARTISTA");
            System.out.println("3. VISTA ARTISTES");
            ;
            System.out.println("0. Sortir");
            System.out.print("Introdueix una opció: ");
            opc = scanner.nextInt();
            switch (opc) {
                case 1:
                    altaArtista(connection);
                    break;
                case 2:
                    bajaArtista(connection);
                    break;
                case 3:
                    viewArtistes(connection);
                    break;
                case 0:
                    submenu = 1;
                default:
                    System.out.println("Opció incorrecta.");
            }
        } while (submenu == 0);
    }
}
