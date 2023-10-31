package com.company;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        String dataBaseDriver = "org.postgresql.Driver";
        Class.forName(dataBaseDriver);
        //tables creation
        try {
            if (!Creation.checkTableExistence("vacancies_conditions")) {
                Creation.createTable(Creation.create_vacancies_conditions_table, Creation.create_sequence_for_vacancies_conditions_table);
            } else {
                System.out.println("This table already exists!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //drop table
        /*
        try {
            if (Creation.checkTableExistence("vacancies_conditions")) {
                Creation.dropTable("vacancies_conditions", Creation.drop_sequence_for_vacancies_conditions_table);
                System.out.println("The table was dropped!");
            } else {
                System.out.println("This table doesn't exist!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
         */


    }
}
