package com.company;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.net.MalformedURLException;
import java.net.URL;
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

    public static void retrieveWithRowSetFromTable(String query) {
        try {
            URL myURL = new URL("jdbc:postgresql://localhost:5432/online_job_portal_db");
            JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
            rowSet.setURL(1, myURL);
            rowSet.setUsername("postgres");
            rowSet.setPassword("123456");
            rowSet.setCommand(query);
            rowSet.execute();
            while (rowSet.next()) {
                System.out.println(rowSet.getObject(1));
                System.out.println(rowSet.getObject(2));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
