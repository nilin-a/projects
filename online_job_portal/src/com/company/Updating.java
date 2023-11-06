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

        ResultSet previousResultSet = Retrieving.retrieveFromTable("SELECT * FROM companies");
        previousResultSet.next();
        try {
            connection = Start.getDBConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(update_companies_table);
            preparedStatement.setInt(1, companyId);
            if (companyName.trim().isEmpty()) {
                preparedStatement.setString(2, previousResultSet.getString("company_name"));
            } else {
                preparedStatement.setString(2, companyName);
            }

            if (foundingDay.isEmpty()) {
                preparedStatement.setString(3, previousResultSet.getString("founding_day"));
            } else {
                preparedStatement.setDate(3, Date.valueOf(foundingDay));
            }

            if (description.isEmpty()) {
                preparedStatement.setString(4, previousResultSet.getString("description"));
            } else {
                preparedStatement.setString(4, description);
            }

            if (countryAddress.isEmpty()) {
                preparedStatement.setString(5, previousResultSet.getString("country_address"));
            } else {
                preparedStatement.setString(5, countryAddress);
            }

            if (cityAddress.isEmpty()) {
                preparedStatement.setString(6, previousResultSet.getString("city_address"));
            } else {
                preparedStatement.setString(6, cityAddress);
            }

            if (streetAddress.isEmpty()) {
                preparedStatement.setString(7, previousResultSet.getString("street_address"));
            } else {
                preparedStatement.setString(7, streetAddress);
            }

            if (buildingAddress.isEmpty()) {
                preparedStatement.setString(8, previousResultSet.getString("building_address"));
            } else {
                preparedStatement.setString(8, buildingAddress);
            }


            insertedRowsAmount = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            connection.close();
        }
        return insertedRowsAmount;
    }
}
