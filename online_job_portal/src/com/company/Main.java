package com.company;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        //tables creation
        /*
        try {
            if (!Creation.checkTableExistence("vacancies_applicants")) {
                Creation.createTable(Creation.create_vacancies_applicants_table, Creation.create_sequence_for_vacancies_applicants_table);
            } else {
                System.out.println("This table already exists!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
         */

        //drop table
        /*
        try {
            if (Creation.checkTableExistence("jobs")) {
                Creation.dropTable("jobs", Creation.drop_sequence_for_jobs_table);
                System.out.println("The table was dropped!");
            } else {
                System.out.println("This table doesn't exist!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
         */

        Scanner in = new Scanner(System.in);
        System.out.println("Choose your interaction: insert, read, edit, delete, metadata. Enter exit for exit.");
        String function = in.nextLine().toLowerCase();
        while (!function.equals("exit"))
        switch (function) {
            case ("insert"):
                UserInteraction.chooseInsertionTable();
                System.out.println("\nChoose your interaction: insert, read, edit, delete, metadata. Enter exit for exit.");
                function = in.nextLine().toLowerCase();
                break;
            case ("read"):
                System.out.println("Enter the table name for reading: ");
                UserInteraction.showTablesNames();
                String tableName = in.nextLine().toLowerCase();
                UserInteraction.showTable(tableName);
                System.out.println("\nChoose your interaction: insert, read, edit, delete, metadata. Enter exit for exit.");
                function = in.nextLine().toLowerCase();
                break;
            case ("edit"):
                System.out.println("Edition the data in companies table");
                UserInteraction.showTable("companies");
                UserInteraction.makeUpdatingToCompaniesTable();
                UserInteraction.showTable("companies");
                System.out.println("\nChoose your interaction: insert, read, edit, delete, metadata. Enter exit for exit.");
                function = in.nextLine().toLowerCase();
                break;
            case ("delete"):
                System.out.println("Deletion the data from companies table: ");
                UserInteraction.makeDeletionFromCompanies();
                System.out.println("\nChoose your interaction: insert, read, edit, delete, metadata. Enter exit for exit.");
                function = in.nextLine().toLowerCase();
                break;
            case ("metadata"):
                System.out.println("Metadata");
                UserInteraction.showTablesNames();
                UserInteraction.showDriverInfo();
                UserInteraction.showProductInfo();
                System.out.println("\nChoose your interaction: insert, read, edit, delete, metadata. Enter exit for exit.");
                function = in.nextLine().toLowerCase();
                break;
            default:
                System.out.println("\nChoose your interaction: insert, read, edit, delete, metadata. Enter exit for exit.");
                function = in.nextLine().toLowerCase();
                break;
        }
        System.out.println("Goodbye!");
    }
}
