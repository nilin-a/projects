package com.company;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Start {
    private static final String url = "jdbc:postgresql://localhost:5432/online_job_portal_db";
    private static final String user = "postgres";
    private static final String password = "123456";
    private static final String dataBaseDriver = "org.postgresql.Driver";

    public static Connection getDBConnection() {
        Connection connection = null;
        try {
            Class.forName(dataBaseDriver);
            connection = DriverManager.getConnection(url,user,password);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
