package dbappsintroduction.accessingdatabase;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String dataBaseURL = "jdbc:mysql://localhost:3306/soft_uni";
        String userName = "root";
        String password = "****";

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(dataBaseURL,userName,password);

            PreparedStatement statement = connection.prepareStatement("SELECT a.first_name,a.last_name FROM soft_uni.employees a " +
                    "WHERE a.salary > ?;");

            Scanner scanner = new Scanner(System.in);
            int number = Integer.parseInt(scanner.nextLine());

            statement.setInt(1,number);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
