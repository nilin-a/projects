package com.company;
import java.sql.* ;

public class Retrieving {

    public static ResultSet retrieveFromTable(String query) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = Start.getDBConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        connection.close();
        return  resultSet;
    }
}
