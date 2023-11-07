package com.company;

import java.sql.*;
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

    public static void chooseInsertionTable() {
        showTablesNames();
        System.out.println("Enter table name for insertion: ");
        Scanner in = new Scanner(System.in);
        String tableName = in.nextLine().toLowerCase();
        showTable(tableName);
        switch (tableName){
            case ("applicants"):
                System.out.println("\nInsertion to the applicants table");
                makeInsertionToApplicantsTable();
                break;
            case ("skills"):
                System.out.println("\nInsertion to the skills table");
                makeInsertionToSkillsTable();
                break;
            case ("companies"):
                System.out.println("\nInsertion to the companies table");
                makeInsertionToCompaniesTable();
                break;
            case ("responsibilities"):
                System.out.println("\nInsertion to the responsibilities table (with bathing)");
                makeInsertionToResponsibilitiesTable();
                showTable("responsibilities");
            default:
                System.out.println("Not done yet");
                break;
        }
        showTable(tableName);

    }

    public static void makeInsertionToApplicantsTable() {
        Scanner in = new Scanner(System.in);
        try {
            if (Creation.checkTableExistence("applicants")) {
                System.out.println("\nEnter first name: ");
                String firstName = in.nextLine();
                System.out.println("Enter last name: ");
                String lastName = in.nextLine();
                System.out.println("Enter mail address: ");
                String mailAddress = in.nextLine();
                System.out.println("Enter phone number: ");
                String phoneNumber = in.nextLine();
                System.out.println("Enter birth date: ");
                String birthDate = in.nextLine();
                System.out.println("Enter country: ");
                String country = in.nextLine();
                System.out.println("Enter city: ");
                String city = in.nextLine();
                System.out.println("Enter bio: ");
                String bio = in.nextLine();
                int insertedRows = Insertion.applicantsInsert(firstName, lastName, mailAddress, phoneNumber,
                        Date.valueOf(birthDate), country, city, bio);
                System.out.println(insertedRows + " was added");
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

    public static void makeInsertionToSkillsTable() {
        Scanner in = new Scanner(System.in);
        try {
            if (Creation.checkTableExistence("skills")) {
                System.out.println("Enter skill name");
                String skillName = in.nextLine();
                int insertedRows = Insertion.skillsInsert(skillName);
                System.out.println(insertedRows + " was added");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void makeInsertionToResponsibilitiesTable() {
        System.out.println("Enter responsibility names. To stop enter - end");
        Scanner in = new Scanner(System.in);
        String responsibilityName = in.nextLine().toLowerCase();
        try {
            Connection connection = Start.getDBConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(Insertion.insert_into_responsibilities_table);
            while (!responsibilityName.equals("end")) {
                preparedStatement.setString(1, responsibilityName);
                preparedStatement.addBatch();
                System.out.println("Enter responsibility names. To stop enter - end");
                responsibilityName = in.nextLine().toLowerCase();
            }
            preparedStatement.executeBatch();
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
                int insertedRows = Updating.updateTable(companyName, Date.valueOf(date), description,
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

    public static void makeDeletionFromCompanies() {
        Scanner in = new Scanner(System.in);
        showTable("companies");
        System.out.println("Enter id for row deletion: ");
        int id = in.nextInt();
        try {
            Deletion.deleteFromCompanies(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        showTable("companies");
    }
}
