package com.company;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class UserInteraction {

    public static void roleSelection() {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose your role: admin or user. Enter exit for exit.");
        String role = in.nextLine().toLowerCase();
        /*
        while (!role.equals("admin")) {
            System.out.println("Wrong option! Enter admin, user or exit.");
            role = in.nextLine().toLowerCase();
        }
         */
        switch (role) {
            case ("admin"):
                System.out.println("You are admin");
                adminFunctionsSelection();
                break;
            case ("user"):
                System.out.println("You are user");
                break;
            case ("exit"):
                System.out.println("Goodbye");
                break;
        }
    }

    public static void adminFunctionsSelection() {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose functions: insert, read, edit, delete, metadata. Enter exit for exit.");
        String function = in.nextLine().toLowerCase();
        switch (function) {
            case ("insert"):
                System.out.println("Insertion to the table");
                tableForInsertionSelection();
                break;
            case ("read"):
                System.out.println("Reading the data");
                break;
            case ("edit"):
                System.out.println("Edition the data");
                break;
            case ("delete"):
                System.out.println("Deletion the data");
                break;
            case ("metadata"):
                System.out.println("Metadata");
                break;
            case ("exit"):
                System.out.println("Back to role selection");
                break;
        }
    }

    public static void tableForInsertionSelection() {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose the table for insertion: \n1 companies \n2 conditions \n3 employment_types" +
                "\n4 responsibilities \n5 skills \n6 vacancies \n7 vacancies_applicants \n7 vacancies_conditions " +
                "\n8 vacancies_responsibilities \n9 vacancies_skills \n0 exit");
        int insertionOption = in.nextInt();
        switch (insertionOption) {
            case (1):
                System.out.println();
                showCompaniesTable();
                break;
            case (2):
                System.out.println();
                break;
            case (3):
                System.out.println();
                break;
            case (4):
                System.out.println();
                break;
            case (5):
                System.out.println();
                break;
            case (6):
                System.out.println();
                break;
            case (7):
                System.out.println();
                break;
            case (8):
                System.out.println();
                break;
            case (9):
                System.out.println();
                break;
            case (0):
                System.out.println("Back to functions selection");
                break;
        }
    }

    public static void showCompaniesTable() {
        try {
            if (Creation.checkTableExistence("companies")) {
                ResultSet resultSet = Retrieving.retrieveFromTable(Retrieving.select_from_companies);
                int counter = 1;
                while (resultSet.next()) {
                    System.out.println("\nCompany №" + counter);
                    System.out.println("ID: " + resultSet.getInt("company_id"));
                    System.out.println("Name: " + resultSet.getString("company_name"));
                    System.out.println("Description: " + resultSet.getString("description"));
                    System.out.println("Founding: " + resultSet.getDate("founding_day"));
                    System.out.println("Address: " + resultSet.getString("street_address") + " " +
                            resultSet.getString("building_address") + ", " + resultSet.getString("city_address") + ", " +
                            resultSet.getString("country_address"));
                    counter++;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void makeInsertionToCompaniesTable() {
        Scanner in = new Scanner(System.in);
        //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if (Creation.checkTableExistence("companies")) {
                System.out.println("Enter company name: ");
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
                System.out.println("Enter company name: ");
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

}
