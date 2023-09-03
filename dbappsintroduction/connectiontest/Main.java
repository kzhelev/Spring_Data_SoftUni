package dbappsintroduction.connectiontest;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        String dataBaseURL = "jdbc:mysql://localhost:3306/soft_uni";
        String userName = "root";
        String password = "*****";

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(dataBaseURL,userName,password);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select a.first_name,a.last_name," +
                    " a.salary from soft_uni.employees a limit 10");

            while(resultSet.next()) {
                System.out.println(resultSet.getString(1) + " "
                        + resultSet.getString(2) + " "
                        + resultSet.getInt(3));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            connection.close();
        }
    }
}
