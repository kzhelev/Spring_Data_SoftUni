package dbappsintroduction.increaseage;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String dataBaseURL = "jdbc:mysql://localhost:3306/minions_db";
        String userName = "root";
        String password = "*****";

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(dataBaseURL,userName,password);

            PreparedStatement statement = connection.prepareStatement("Call IncreaseAge(?);");

            Scanner scanner = new Scanner(System.in);
            int minionID = Integer.parseInt(scanner.nextLine());

            statement.setInt(1,minionID);

            statement.executeUpdate();

            PreparedStatement selectStatement = connection.prepareStatement("Select m.name, m.age from minions m where m.id = ?");

/*
            Used procedure:
            CREATE DEFINER=`root`@`localhost` PROCEDURE `IncreaseAge`(IN id INT)
            BEGIN
            UPDATE minions M
            SET M.AGE = M.AGE + 1
            WHERE M.ID = id;
            END
 */

            selectStatement.setInt(1,minionID);

            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) {

                System.out.println(resultSet.getString(1) + " " + resultSet.getInt(2));
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
