package daniel.Cabrera.classes;

import java.sql.*;
import java.util.Scanner;

public class Style {
    public static void altaEstilo(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introdueix el códi del estil que vols donar d'alta: ");
        String styleCode = scanner.nextLine();
        System.out.print("Introdueix el nom del estil que vols donar d'alta: ");
        String styleName = scanner.nextLine();

        while (true) {
            String sqlCheckArtist = "SELECT * FROM STYLE WHERE code = ?";
            try (PreparedStatement statementCheckClient = connection.prepareStatement(sqlCheckArtist)) {
                statementCheckClient.setString(1, styleCode);
                ResultSet resultSet = statementCheckClient.executeQuery();
                if (!resultSet.next() || resultSet.getString("code").equals(styleCode)) {
                    System.out.println("No existeix ningún estil amb aquest codi.");
                    System.out.println("Introdueix el códi del estil que vols donar d'alta. (prem -1 per sortir):");
                    styleCode = scanner.nextLine();
                    if (styleCode.equals("-1")) {
                        return;
                    }
                } else {
                    String sql = "INSERT INTO STYLE (code, name) VALUES (?, ?)";
                    try (PreparedStatement statement = connection.prepareStatement(sql)) {
                        statement.setString(1, styleCode);
                        statement.setString(2, styleName);
                        statement.executeUpdate();
                        System.out.println("Album dado de alta correctamente.");
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public static void bajaEstilo(Connection connection) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("######################### BAIXE ESTILO #########################");
        System.out.println("Introdueix el códi del estil que vols donar de baixa: ");
        String styleCode = scanner.nextLine();

        while (true) {
            String sqlCheckArtist = "SELECT * FROM STYLE WHERE code = ?";
            try (PreparedStatement statementCheckClient = connection.prepareStatement(sqlCheckArtist)) {
                statementCheckClient.setString(1, styleCode);
                ResultSet resultSet = statementCheckClient.executeQuery();
                if (!resultSet.next() || resultSet.getString("code").equals(styleCode)) {
                    System.out.println("No existeix ningún estil amb aquest codi.");
                    System.out.println("Introdueix el códi del estil que vols donar de baixa. (prem -1 per sortir):");
                    styleCode = scanner.nextLine();
                    if (styleCode.equals("-1")) {
                        return;
                    }
                } else {
                    String sql = "DELETE FROM STYLE WHERE code = ?";
                    try (PreparedStatement statement = connection.prepareStatement(sql)) {
                        statement.setString(1, styleCode);
                        statement.executeUpdate();
                        System.out.println("Estilo dado de baja correctamente.");
                        break;
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void viewEstils(Connection connection) {
        String sql = "SELECT * FROM STYLE";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();

            // Verificar si no hay filas en el resultSet
            if (!resultSet.next()) {
                System.out.println("No existen estils.");
            } else {
                int i = 1;
                System.out.println("######################### ESTILS #########################");
                while (resultSet.next()) {
                    String estilCode = resultSet.getString("code");
                    String estilName = resultSet.getString("name");

                    System.out.println("#" + i);
                    System.out.println("Estil Code: " + estilCode);
                    System.out.println("Estil Name: " + estilName);
                    System.out.println();
                    i++;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void menuStyle(Connection connection) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        int opc;
        int submenu = 0;
        do {
            System.out.println("############################ Menú ESTILS ############################");
            System.out.println("1. ALTA ESTIL");
            System.out.println("2. BAIXA ESTIL");
            System.out.println("3. VISTA ESTILS");
            ;
            System.out.println("0. Sortir");
            System.out.print("Introdueix una opció: ");
            opc = scanner.nextInt();
            switch (opc) {
                case 1:
                    altaEstilo(connection);
                    break;
                case 2:
                    bajaEstilo(connection);
                    break;
                case 3:
                    viewEstils(connection);
                    break;
                case 0:
                    submenu = 1;
                default:
                    System.out.println("Opció incorrecta.");
            }
        } while (submenu == 0);
    }
}
