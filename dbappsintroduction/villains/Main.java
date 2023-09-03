package dbappsintroduction.villains;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        String dataBaseURL = "jdbc:mysql://localhost:3306/minions_db";
        String userName = "root";
        String password = "*****";

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(dataBaseURL,userName,password);

            PreparedStatement statement = connection.prepareStatement("select v.name, COUNT(a.minion_id) as minions_number" +
                    " from minions_villains as a, villains as v\n" +
                    "where v.id = a.villain_id\n" +
                    "GROUP BY a.villain_id\n" +
                    "order by minions_number desc;");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next() && resultSet.getInt(2) > 15) {
                System.out.println(resultSet.getString(1) + " " +resultSet.getInt(2));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connection.close();
        }
    }
}
