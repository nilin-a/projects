package com.company;

import java.sql.*;

public class Updating {
    static final String update_companies_table = "UPDATE companies SET " +
            "company_name = ?," +
            "founding_day = ?," +
            "description = ?," +
            "country_address = ?," +
            "city_address = ?," +
            "street_address = ?," +
            "building_address = ? " +
            "WHERE company_id = ?;";

    public static int updateTable(String companyName, Date foundingDay, String description, String countryAddress,
                                  String cityAddress, String streetAddress, String buildingAddress, int companyId) throws SQLException {
        Connection connection = null;
        int insertedRowsAmount = 0;
        try {
            connection = Start.getDBConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(update_companies_table);
            preparedStatement.setString(1, companyName);
            preparedStatement.setDate(2, foundingDay);
            preparedStatement.setString(3, description);
            preparedStatement.setString(4, countryAddress);
            preparedStatement.setString(5, cityAddress);
            preparedStatement.setString(6, streetAddress);
            preparedStatement.setString(7, buildingAddress);
            preparedStatement.setInt(8, companyId);
            insertedRowsAmount = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            connection.close();
        }
        return insertedRowsAmount;
    }
}
