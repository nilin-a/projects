package com.company;
import java.sql.* ;

public class Retrieving {
    static final String select_from_applicants = "SELECT * FROM applicants;";
    static final String select_from_companies = "SELECT * FROM companies;";

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
