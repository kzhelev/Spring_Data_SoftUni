package dbappsintroduction.addminion;

import java.sql.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        String dataBaseURL = "jdbc:mysql://localhost:3306/minions_db";
        String userName = "root";
        String password = "*****";

        Connection connection = null;

        Scanner scanner = new Scanner(System.in);

        String[] minionInfo = scanner.nextLine().split(": ")[1].split("\\s+");

        String villainName = scanner.nextLine().split(": ")[1];

        Map<String,Integer> townsInfo = new HashMap<>();
        Map<String,Integer> villainsInfo = new HashMap<>();

        try {
            connection = DriverManager.getConnection(dataBaseURL,userName,password);

            PreparedStatement selectStatementTowns = connection.prepareStatement("select a.name, a.id from towns a;");

            PreparedStatement selectStatementVillains = connection.prepareStatement("select a.name, a.id from villains a;");

            PreparedStatement insertStatement = connection.prepareStatement("insert into minions(name,age,town_id)\n" +
                    "values(?,?,(Select a.id from towns a where a.name = ?));");

            PreparedStatement insertTownStatement = connection.prepareStatement("insert into towns(name)\n" +
                    "values (?);");

            PreparedStatement insertVillain = connection.prepareStatement("insert into villains(name)\n" +
                    "values (?);");

            PreparedStatement villainMinionRelation = connection.prepareStatement("insert into minions_villains\n" +
                    "values((select a.id from minions a where a.name = ?),(select b.id from villains b where b.name = ?))");

            ResultSet resultSet = selectStatementTowns.executeQuery();

            while (resultSet.next()) {

                townsInfo.put(resultSet.getString(1),resultSet.getInt(2));
            }

            ResultSet resultSetTwo = selectStatementVillains.executeQuery();

            while (resultSet.next()) {

                villainsInfo.put(resultSet.getString(1),resultSet.getInt(2));
            }

            insertStatement.setString(1,minionInfo[0]);
            insertStatement.setInt(2,Integer.parseInt(minionInfo[1]));
            insertStatement.setString(3,minionInfo[2]);

            insertTownStatement.setString(1,minionInfo[2]);

            villainMinionRelation.setString(1,minionInfo[0]);
            villainMinionRelation.setString(2,villainName);

            insertVillain.setString(1,villainName);

            if (!townsInfo.containsKey(minionInfo[2])) {
                insertTownStatement.executeUpdate();
            }

            if (!villainsInfo.containsKey(villainName)) {
                insertVillain.executeUpdate();
            }

            insertStatement.executeUpdate();
            villainMinionRelation.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connection.close();
        }
    }
}
