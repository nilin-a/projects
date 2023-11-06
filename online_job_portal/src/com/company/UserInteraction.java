package com.company;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class UserInteraction {

    public static void showTable(String tableName) {
        try {
            if (Creation.checkTableExistence(tableName)) {
                ResultSet columns = MetaData.getColumns(tableName);
                ResultSet tableData = Retrieving.retrieveFromTable("SELECT * FROM " + tableName);
                int columnCounter = 0;
                while (columns.next()) {
                    System.out.print(columns.getString("COLUMN_NAME") + "  ---  ");
                    columnCounter++;
                }
                while (tableData.next()) {
                    System.out.println("\n");
                    for (int i = 1; i <= columnCounter; i++) {
                        System.out.print(tableData.getObject(i) + "  ---  ");
                    }
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void makeInsertionToCompaniesTable() {
        Scanner in = new Scanner(System.in);
        try {
            if (Creation.checkTableExistence("companies")) {
                System.out.println("\nEnter company name: ");
                String companyName = in.nextLine();
                System.out.println("Enter company date of founding (format yyyy-MM-dd): ");
                String date = in.nextLine();
                System.out.println("Enter description: ");
                String description = in.nextLine();
                System.out.println("Enter country: ");
                String country = in.nextLine();
                System.out.println("Enter city: ");
                String city = in.nextLine();
                System.out.println("Enter street: ");
                String street = in.nextLine();
                System.out.println("Enter building: ");
                String building = in.nextLine();
                int insertedRows = Insertion.companiesInsert(companyName, Date.valueOf(date), description,
                        country, city, street, building);
                System.out.println(insertedRows + " was added");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void makeUpdatingToCompaniesTable() {
        Scanner in = new Scanner(System.in);
        try {
            if (Creation.checkTableExistence("companies")) {
                System.out.println("\nEnter company name: ");
                String companyName = in.nextLine();
                System.out.println("Enter company date of founding (format yyyy-MM-dd): ");
                String date = in.nextLine();
                System.out.println("Enter description: ");
                String description = in.nextLine();
                System.out.println("Enter country: ");
                String country = in.nextLine();
                System.out.println("Enter city: ");
                String city = in.nextLine();
                System.out.println("Enter street: ");
                String street = in.nextLine();
                System.out.println("Enter building: ");
                String building = in.nextLine();
                System.out.println("Enter company id: ");
                int companyId = in.nextInt();
                int insertedRows = Updating.updateTable(companyName, date, description,
                        country, city, street, building, companyId);
                System.out.println(insertedRows + " was updated");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void showTablesNames() {
        System.out.println("Tables' names: ");
        try {
            ResultSet resultSet = MetaData.getTables();
            int counter = 1;
            while (resultSet.next()) {
                System.out.println("Table " + counter + " name: " + resultSet.getString("TABLE_NAME"));
                counter++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void showDriverInfo() {
        try {
            System.out.println("Driver's information:\nName: " + MetaData.getDriverName() + ", version: " + MetaData.getDriverVersion());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void showProductInfo() {
        try {
            System.out.println("Product's information:\nName: " + MetaData.getDatabaseProductName() + ", version: " + MetaData.getDatabaseProductVersion());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
