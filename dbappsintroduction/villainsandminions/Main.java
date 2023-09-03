package dbappsintroduction.villainsandminions;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        String dataBaseURL = "jdbc:mysql://localhost:3306/minions_db";
        String userName = "root";
        String password = "*****";

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(dataBaseURL,userName,password);

            PreparedStatement statement = connection.prepareStatement("select v.name, m.name, m.age" +
                    " from minions_villains as a, villains as v, minions m\n" +
                    "where v.id = a.villain_id\n" +
                    "and m.id = a.minion_id\n" +
                    "and v.id = ?\n" +
                    "order by m.name;");

            Scanner scanner = new Scanner(System.in);
            int villainID = Integer.parseInt(scanner.nextLine());

            statement.setInt(1, villainID);

            ResultSet resultSet = statement.executeQuery();

            boolean isPrinted = false;

            while (resultSet.next()) {
                if (!isPrinted) {
                    System.out.println("Villain: " + resultSet.getString(1));
                    isPrinted = true;
                }
                System.out.println(resultSet.getString(2) + " " + resultSet.getInt(3));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connection.close();
        }
    }
}
