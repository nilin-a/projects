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
            "building_address = ?" +
            "WHERE company_id = ?;";

    public static int updateTable(String companyName, String foundingDay, String description, String countryAddress,
                                  String cityAddress, String streetAddress, String buildingAddress, int companyId) throws SQLException {
        Connection connection = null;
        int insertedRowsAmount = 0;

        ResultSet previousResultSet = Retrieving.retrieveFromTable(Retrieving.select_from_companies);

        try {
            connection = Start.getDBConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(update_companies_table);
            if (companyName.isEmpty()) {
                preparedStatement.setString(1, previousResultSet.getString("company_name"));
            } else {
                preparedStatement.setString(1, companyName);
            }
            if (foundingDay.isEmpty()) {
                preparedStatement.setString(2, previousResultSet.getString("founding_day"));
            } else {
                preparedStatement.setDate(2, Date.valueOf(foundingDay));
            }
            if (description.isEmpty()) {
            } else {
                preparedStatement.setString(3, description);
            }
            if (countryAddress.isEmpty()) {
            } else {
                preparedStatement.setString(4, countryAddress);
            }
            if (cityAddress.isEmpty()) {

            } else {
                preparedStatement.setString(5, cityAddress);
            }
            if (streetAddress.isEmpty()) {

            } else {
                preparedStatement.setString(6, streetAddress);
            }
            if (buildingAddress.isEmpty()) {

            } else {
                preparedStatement.setString(7, buildingAddress);
            }
            preparedStatement.setInt(7, companyId);
            insertedRowsAmount = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            connection.close();
        }
        return insertedRowsAmount;
    }
}
