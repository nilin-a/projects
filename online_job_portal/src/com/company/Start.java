package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Start {
    private static final String url = "jdbc:postgre://localhost:5432/online_job_portal_db";
    private static final String user = "postgres";
    private static final String password = "123456";

    public static void getDBConnection() {
        Statement statement = null;
        try {
            Connection connection = DriverManager.getConnection(url,user,password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Error: something wrong with the sql request:\n" + e);
        }
    }
}
