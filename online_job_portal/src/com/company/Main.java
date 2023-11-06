package com.company;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        //String dataBaseDriver = "org.postgresql.Driver";
        //Class.forName(dataBaseDriver);
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

        //insert into applicants table
        /*
        try {
            if (Creation.checkTableExistence("applicants")) {
                int insertedRows = Insertion.applicantsInsert("Михаил", "Иванов", "supermike111@gmail.com",
                        "+79107401278", Date.valueOf("2000-11-21"), "Россия", "Самара", null);
                System.out.println(insertedRows + " was added");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
         */

        //insert into skills table
        /*
        try {
            if (Creation.checkTableExistence("skills")) {
                int insertedRows = Insertion.skillsInsert("Agile");
                System.out.println(insertedRows + " was added");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
         */
        //insert into applicants_skills table
        /*
        try {
            if (Creation.checkTableExistence("applicants_skills")) {
                int insertedRows = Insertion.applicantSkillsInsert(8,7);
                System.out.println(insertedRows + " was added");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

         */
        //insert into conditions table
        /*
        try {
            if(Creation.checkTableExistence("conditions")) {
                int insertedRows = Insertion.conditionsInsert("Участие в корпоративных мероприятиях");
                System.out.println(insertedRows + " was added");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

         */
        //insert into applicants_conditions table
        /*
        try {
            if (Creation.checkTableExistence("applicants_conditions")) {
                int insertedRows = Insertion.applicantsConditionsInsert(7, 3);
                System.out.println(insertedRows + " was added");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

         */
        //insert into educations table
        /*
        try {
            if (Creation.checkTableExistence("educations")) {
                int insertedRows = Insertion.educationsInsert("СНИУ", "Информатика", "ПМИ", Date.valueOf("2020-09-01"), Date.valueOf("2022-07-01"));
                System.out.println(insertedRows + " was added");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
         */
        //insert into applicants_educations table
        /*
        try {
            if (Creation.checkTableExistence("applicants_educations")) {
                int insertedRows = Insertion.applicantsEducationsInsert(8, 3);
                System.out.println(insertedRows + " was added");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
         */
        //insert into employment_types table
        /*
        try {
            if (Creation.checkTableExistence("employment_types")) {
                int insertedRows = Insertion.employmentTypesInsert("Сутки через двое", 72, 3);
                System.out.println(insertedRows + " was added");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
         */
        //insert into applicants_employment_types table
        /*
        try {
            if (Creation.checkTableExistence("applicants_employment_types")) {
                int insertedRows = Insertion.applicantsEmploymentTypesInsert(8, 5);
                System.out.println(insertedRows + " was added");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
         */

        /*
        //insert into jobs table
        try {
            if (Creation.checkTableExistence("jobs")) {
                int insertedRows = Insertion.jobsInsert(8, 3, "Системный администратор", Date.valueOf("2023-08-01"), Date.valueOf("2023-11-01"), "Администрировал");
                System.out.println(insertedRows + " was added");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

         */

        //insert into responsibilities table
        /*
        try {
            if (Creation.checkTableExistence("responsibilities")) {
                int insertedRows = Insertion.responsibilitiesInsert("Ведение документации");
                System.out.println(insertedRows + " was added");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        */
        //insert into vacancies table
        /*
        try {
            if (Creation.checkTableExistence("vacancies")) {
                int insertedRows = Insertion.vacanciesInsert(2, "Системный аналитик", 57000, 2, 4);
                System.out.println(insertedRows + " was added");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

         */
        //insert into vacancies_conditions table
        /*
        try {
            if (Creation.checkTableExistence("vacancies_conditions")) {
                int insertedRows = Insertion.vacanciesConditionsInsert(3, 7);
                System.out.println(insertedRows + " was added");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

         */

        //insert into vacancies_responsibilities table
        /*
        try {
            if (Creation.checkTableExistence("vacancies_responsibilities")) {
                int insertedRows = Insertion.vacanciesResponsibilitiesInsert(3,  4);
                System.out.println(insertedRows + " was added");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

         */

        //insert into vacancies_skills table
        /*
        try {
            if (Creation.checkTableExistence("vacancies_skills")) {
                int insertedRows = Insertion.vacanciesSkillsInsert(3,  3);
                System.out.println(insertedRows + " was added");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
         */

        //insert into vacancies_applicants table
        /*
        try {
            if (Creation.checkTableExistence("vacancies_applicants")) {
                int insertedRows = Insertion.vacanciesApplicantsInsert(2,  8, "Отказ");
                System.out.println(insertedRows + " was added");
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
                System.out.println("Insertion to the companies table");
                UserInteraction.showTable("companies");
                UserInteraction.makeInsertionToCompaniesTable();
                UserInteraction.showTable("companies");
                System.out.println("\nChoose your interaction: insert, read, edit, delete, metadata. Enter exit for exit.");
                function = in.nextLine().toLowerCase();
                break;
            case ("read"):
                System.out.println("Reading the data from table. Choose the table: ");
                UserInteraction.showTablesNames();
                String tableName = in.nextLine().toLowerCase();
                UserInteraction.showTable(tableName);
                System.out.println("\nChoose your interaction: insert, read, edit, delete, metadata. Enter exit for exit.");
                function = in.nextLine().toLowerCase();
                break;
            case ("edit"):
                System.out.println("Edition the data");
                UserInteraction.showTable("companies");
                UserInteraction.makeUpdatingToCompaniesTable();
                UserInteraction.showTable("companies");
                System.out.println("\nChoose your interaction: insert, read, edit, delete, metadata. Enter exit for exit.");
                function = in.nextLine().toLowerCase();
                break;
            case ("delete"):
                System.out.println("Deletion the data");
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
        }
        System.out.println("Goodbye!");
    }
}
