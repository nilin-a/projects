package com.company;

import java.sql.Date;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        String dataBaseDriver = "org.postgresql.Driver";
        Class.forName(dataBaseDriver);
        //tables creation
        /*
        try {
            if (!Creation.checkTableExistence("jobs")) {
                Creation.createTable(Creation.create_jobs_table, Creation.create_sequence_for_jobs_table);
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
        //insert into companies table
        /*
        try {
            if (Creation.checkTableExistence("companies")) {
                int insertedRows = Insertion.companiesInsert("Огонек", Date.valueOf("2002-11-19"), "IT компания",
                        "Россия", "Саратов", "Прямая", "9");
                System.out.println(insertedRows + " was added");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
         */
        //insert into jobs table
        try {
            if (Creation.checkTableExistence("jobs")) {
                int insertedRows = Insertion.jobsInsert(8, 3, "Системный администратор", Date.valueOf("2023-08-01"), Date.valueOf("2023-11-01"), "Администрировал");
                System.out.println(insertedRows + " was added");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



    }
}
