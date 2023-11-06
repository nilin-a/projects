package com.company;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MetaData {
    static Connection connection = null;

    public static DatabaseMetaData getDatabaseMetaData() throws SQLException {
        DatabaseMetaData databaseMetaData = null;
        try {
            connection = Start.getDBConnection();
            databaseMetaData = connection.getMetaData();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return databaseMetaData;
    }

    public static ResultSet getTables() throws SQLException {
        ResultSet resultSet = null;
        try {
            resultSet = getDatabaseMetaData().getTables(null, null, null, new String[]{"TABLE"});
        } finally {
            connection.close();
        }
        return resultSet;
    }

    public static String getDriverName() throws SQLException {
        String result;
        try {
            result = getDatabaseMetaData().getDriverName();
        } finally {
            connection.close();
        }
        return result;
    }

    public static String getDriverVersion() throws SQLException {
        String result;
        try {
            result = getDatabaseMetaData().getDriverVersion();
        } finally {
            connection.close();
        }
        return result;
    }

    public static String getUserName() throws SQLException {
        String result;
        try {
            result = getDatabaseMetaData().getUserName();
        } finally {
            connection.close();
        }
        return result;
    }

    public static String getDatabaseProductName() throws SQLException {
        String result;
        try {
            result = getDatabaseMetaData().getDatabaseProductName();
        } finally {
            connection.close();
        }
        return result;
    }

    public static String getDatabaseProductVersion() throws SQLException {
        String result;
        try {
            result = getDatabaseMetaData().getDatabaseProductVersion();
        } finally {
            connection.close();
        }
        return result;
    }

}

