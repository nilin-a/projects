package com.company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Deletion {

    public static final String delete_from_companies_table = "DELETE FROM companies WHERE company_id = ?;";
    public static int deleteFromCompanies(int rowId) throws SQLException {
        Connection connection = Start.getDBConnection();
        PreparedStatement preparedStatement = null;
        int rowsDeleted = 0;
        try {
            preparedStatement = connection.prepareStatement(delete_from_companies_table);
            preparedStatement.setInt(1, rowId);
            rowsDeleted = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return rowsDeleted;
    }
}
