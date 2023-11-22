package daniel.Cabrera.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Testing {
    protected static Scanner scanner = new Scanner(System.in);

    public static void checkSelection(String selection, String tableSelected, String varSelected, Connection connection) {
        String sqlCheck = "SELECT ? FROM ? WHERE ? = ?";
        try (PreparedStatement statement = connection.prepareStatement(sqlCheck)) {
            statement.setString(1, selection);
            statement.setString(2, tableSelected);
            statement.setString(3, selection);
            statement.setString(4, varSelected);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next() || resultSet.getString(selection).equals(varSelected)) {
                System.out.println("Ya existe un álbum con ese código.");
                System.out.print("Introdueix el códi que vols donar d'alta a l'álbum. (prem -1 per sortir):");
                varSelected = scanner.nextLine();
                if (varSelected.equals("-1")) {
                    return;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void altaSelection(String tableSelected, String selection1, String selection2, String selection3, String selection4, String selection5, String varSelected1, String varSelected2, String varSelected3, String varSelected4, String varSelected5, Connection connection) {
        String sqlCheck = "INSERT INTO ? (" + selection1 + ", " + selection2 + ", " + selection3 + ", " + selection4 + ", " + selection5 + ") VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sqlCheck)) {
            statement.setString(1, tableSelected);
            statement.setString(2, varSelected1);
            statement.setString(3, varSelected2);
            statement.setString(4, varSelected3);
            statement.setString(5, varSelected4);
            statement.setString(6, varSelected5);
            statement.executeUpdate();
            System.out.println(tableSelected + " dado de alta correctamente.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void altaSelection(String tableSelected, String selection1, String selection2, String selection3, String selection4, String varSelected1, String varSelected2, String varSelected3, String varSelected4, Connection connection) {
        String sqlCheck = "INSERT INTO ? (" + selection1 + ", " + selection2 + ", " + selection3 + ", " + selection4 + ") VALUES ( ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sqlCheck)) {
            statement.setString(1, tableSelected);
            statement.setString(2, varSelected1);
            statement.setString(3, varSelected2);
            statement.setString(4, varSelected3);
            statement.setString(5, varSelected4);
            statement.executeUpdate();
            System.out.println(tableSelected + " dado de alta correctamente.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void altaSelection(String tableSelected, String selection1, String selection2, String selection3, String varSelected1, String varSelected2, String varSelected3, Connection connection) {
        String sqlCheck = "INSERT INTO ? (" + selection1 + ", " + selection2 + ", " + selection3 + ") VALUES ( ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sqlCheck)) {
            statement.setString(1, tableSelected);
            statement.setString(2, varSelected1);
            statement.setString(3, varSelected2);
            statement.setString(4, varSelected3);
            statement.executeUpdate();
            System.out.println(tableSelected + " dado de alta correctamente.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void altaSelection(String tableSelected, String selection1, String selection2, String varSelected1, String varSelected2, Connection connection) {
        String sqlCheck = "INSERT INTO ? (" + selection1 + ", " + selection2 + ") VALUES ( ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sqlCheck)) {
            statement.setString(1, tableSelected);
            statement.setString(2, varSelected1);
            statement.setString(3, varSelected2);
            statement.executeUpdate();
            System.out.println(tableSelected + " dado de alta correctamente.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void baixaSelection(String tableSelected, String selection, String varSelected, Connection connection) {
        String sqlCheck = "DELETE FROM ? WHERE ? = ?";
        try (PreparedStatement statement = connection.prepareStatement(sqlCheck)) {
            statement.setString(1, tableSelected);
            statement.setString(2, selection);
            statement.setString(3, varSelected);
            statement.executeUpdate();
            System.out.println(tableSelected + " dado de baixa.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}