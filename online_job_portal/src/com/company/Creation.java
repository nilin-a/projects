package com.company;

import java.sql.* ;
import java.text.SimpleDateFormat;

public class Creation {
    static final String create_sequence_for_applicants_table = "CREATE SEQUENCE sequence_for_applicants_table START WITH 1;";
    static final String drop_sequence_for_applicants_table = "DROP SEQUENCE IF EXISTS sequence_for_applicants_table;";
    static final String create_applicants_table = "CREATE TABLE applicants (" +
            "applicant_id INT NOT NULL DEFAULT nextval('sequence_for_applicants_table') PRIMARY KEY," +
            "first_name VARCHAR(255) NOT NULL," +
            "last_name VARCHAR(255) NOT NULL," +
            "mail_address VARCHAR(255) UNIQUE," +
            "phone_number VARCHAR(255) UNIQUE," +
            "birth_date DATE," +
            "country VARCHAR(255)," +
            "city VARCHAR(255)," +
            "bio text," +
            "CONSTRAINT mail_address_check CHECK (mail_address LIKE '%@%.%')," +
            "CONSTRAINT phone_number_check CHECK (phone_number LIKE '+7__________' OR phone_number LIKE '8__________')," +
            "CONSTRAINT birth_date_check CHECK (birth_date > '1900-01-01' AND birth_date < CURRENT_DATE)" +
            ");";

    static final String create_sequence_for_skills_table = "CREATE SEQUENCE sequence_for_skills_table START WITH 1;";
    static final String drop_sequence_for_skills_table = "DROP SEQUENCE IF EXISTS sequence_for_skills_table;";
    static final String create_skills_table = "CREATE TABLE skills (" +
            "skill_id INT NOT NULL DEFAULT nextval('sequence_for_skills_table') PRIMARY KEY," +
            "skill_name VARCHAR(255) NOT NULL UNIQUE" +
            ");";

    static final String create_sequence_for_applicants_skills_table = "CREATE SEQUENCE sequence_for_applicants_skills_table START WITH 1;";
    static final String drop_sequence_for_applicants_skills_table = "DROP SEQUENCE IF EXISTS sequence_for_applicants_skills_table;";
    static final String create_applicants_skills_table = "CREATE TABLE applicants_skills (" +
            "id INT NOT NULL DEFAULT NEXTVAL('sequence_for_applicants_skills_table') PRIMARY KEY," +
            "applicant_id INT NOT NULL REFERENCES applicants ON DELETE CASCADE," +
            "skill_id INT NOT NULL REFERENCES skills ON DELETE CASCADE" +
            ");";

    static final String create_sequence_for_educations_table = "CREATE SEQUENCE sequence_for_educations_table START WITH 1;";
    static final String drop_sequence_for_educations_table = "DROP SEQUENCE IF EXISTS sequence_for_educations_table;";
    static final String create_educations_table = "CREATE TABLE educations (" +
            "education_id INT NOT NULL DEFAULT nextval('sequence_for_educations_table') PRIMARY KEY," +
            "institution_name VARCHAR(255) NOT NULL," +
            "faculty_name VARCHAR(255) NOT NULL," +
            "specialty_name VARCHAR(255) NOT NULL," +
            "start_year DATE," +
            "end_year DATE," +
            "CONSTRAINT start_year_check CHECK (start_year > '1900-01-01' AND start_year < CURRENT_DATE)," +
            "CONSTRAINT end_year_check CHECK (end_year > start_year)" +
            ");";

    static final String create_sequence_for_applicants_educations_table = "CREATE SEQUENCE sequence_for_applicants_educations_table START WITH 1;";
    static final String drop_sequence_for_applicants_educations_table = "DROP SEQUENCE IF EXISTS sequence_for_applicants_educations_table;";
    static final String create_applicants_educations_table = "CREATE TABLE applicants_educations (" +
            "id INT NOT NULL DEFAULT NEXTVAL('sequence_for_applicants_educations_table') PRIMARY KEY," +
            "applicant_id INT NOT NULL REFERENCES applicants ON DELETE CASCADE," +
            "education_id INT NOT NULL REFERENCES educations ON DELETE CASCADE" +
            ");";


    static final String create_sequence_for_jobs_table = "CREATE SEQUENCE sequence_for_jobs_table START WITH 1;";
    static final String drop_sequence_for_jobs_table = "DROP SEQUENCE IF EXISTS sequence_for_jobs_table;";
    static final String create_jobs_table = "CREATE TABLE jobs (" +
            "job_id INT NOT NULL DEFAULT nextval('sequence_for_jobs_table') PRIMARY KEY," +
            "applicant_id INT NOT NULL REFERENCES applicants ON DELETE CASCADE," +
            "company_id INT NOT NULL REFERENCES companies ON DELETE SET NULL," +
            "job_title VARCHAR(255) NOT NULL," +
            "start_date DATE," +
            "end_date DATE," +
            "successes TEXT," +
            "CONSTRAINT start_date_check CHECK (start_date > '1900-01-01' AND start_date < CURRENT_DATE)," +
            "CONSTRAINT end_date_check CHECK (end_date > start_date)" +
            ");";

    static final String create_sequence_for_vacancies_table = "CREATE SEQUENCE sequence_for_vacancies_table START WITH 1;";
    static final String drop_sequence_for_vacancies_table = "DROP SEQUENCE IF EXISTS sequence_for_vacancies_table;";
    static final String create_vacancies_table = "CREATE TABLE vacancies (" +
            "vacancy_id INT NOT NULL DEFAULT nextval('sequence_for_vacancies_table') PRIMARY KEY," +
            "company_id INT NOT NULL REFERENCES companies ON DELETE CASCADE," +
            "vacancy_name VARCHAR(255) NOT NULL," +
            "salary NUMERIC(9, 2)," +
            "required_work_experience INT," +
            "employment_type_id INT NOT NULL REFERENCES employment_types ON DELETE SET NULL," +
            "CONSTRAINT salary_check CHECK (salary > 0)," +
            "CONSTRAINT required_work_experience_check CHECK (required_work_experience >= 0)" +
            ");";

    static final String create_sequence_for_employment_types_table = "CREATE SEQUENCE sequence_for_employment_types_table START WITH 1;";
    static final String drop_sequence_for_employment_types_table = "DROP SEQUENCE IF EXISTS sequence_for_employment_types_table;";
    static final String create_employment_types_table = "CREATE TABLE employment_types (" +
            "employment_type_id INT NOT NULL DEFAULT nextval('sequence_for_employment_types_table') PRIMARY KEY," +
            "employment_type_name VARCHAR(255) NOT NULL," +
            "work_hours_per_week INT CHECK(work_hours_per_week > 0)," +
            "work_days_per_week INT CHECK(work_hours_per_week > 0)" +
            ");";

    static final String create_sequence_for_companies_table = "CREATE SEQUENCE sequence_for_companies_table START WITH 1;";
    static final String drop_sequence_for_companies_table = "DROP SEQUENCE IF EXISTS sequence_for_companies_table;";
    static final String create_companies_table = "CREATE TABLE companies (" +
            "company_id INT NOT NULL DEFAULT nextval('sequence_for_companies_table') PRIMARY KEY," +
            "company_name VARCHAR(255) NOT NULL," +
            "founding_day DATE," +
            "description TEXT," +
            "country_address VARCHAR(255)," +
            "city_address VARCHAR(255)," +
            "street_address VARCHAR(255)," +
            "building_address VARCHAR(255)," +
            "CONSTRAINT founding_day_check CHECK (founding_day < CURRENT_DATE)" +
            ");";

    static final String create_sequence_for_responsibilities_table = "CREATE SEQUENCE sequence_for_responsibilities_table START WITH 1;";
    static final String drop_sequence_for_responsibilities_table = "DROP SEQUENCE IF EXISTS sequence_for_responsibilities_table;";
    static final String create_responsibilities_table = "CREATE TABLE responsibilities (" +
            "responsibility_id INT NOT NULL DEFAULT NEXTVAL('sequence_for_responsibilities_table') PRIMARY KEY," +
            "responsibility_name VARCHAR(255) NOT NULL UNIQUE" +
            ");";
    /*
    static final String create_sequence_for_applicants_responsibilities_table = "CREATE SEQUENCE sequence_for_applicants_responsibilities_table START WITH 1;";
    static final String drop_sequence_for_applicants_responsibilities_table = "DROP SEQUENCE IF EXISTS sequence_for_applicants_responsibilities_table;";
    static final String create_applicants_responsibilities_table = "CREATE TABLE applicants_responsibilities (" +
            "id INT NOT NULL DEFAULT NEXTVAL('sequence_for_applicants_responsibilities_table') PRIMARY KEY," +
            "applicant_id INT NOT NULL REFERENCES applicants ON DELETE CASCADE," +
            "responsibility_id INT NOT NULL REFERENCES responsibilities ON DELETE CASCADE" +
            ");";
     */
    static final String create_sequence_for_applicants_employment_types_table = "CREATE SEQUENCE sequence_for_applicants_employment_types_table START WITH 1;";
    static final String drop_sequence_for_applicants_employment_types_table = "DROP SEQUENCE IF EXISTS sequence_for_applicants_employment_types_table;";
    static final String create_applicants_employment_types_table = "CREATE TABLE applicants_employment_types (" +
            "id INT NOT NULL DEFAULT NEXTVAL('sequence_for_applicants_employment_types_table') PRIMARY KEY," +
            "applicant_id INT NOT NULL REFERENCES applicants ON DELETE CASCADE," +
            "employment_type_id INT NOT NULL REFERENCES employment_types ON DELETE CASCADE" +
            ");";

    static final String create_sequence_for_vacancies_responsibilities_table = "CREATE SEQUENCE sequence_for_vacancies_responsibilities_table START WITH 1;";
    static final String drop_sequence_for_vacancies_responsibilities_table = "DROP SEQUENCE IF EXISTS sequence_for_vacancies_responsibilities_table;";
    static final String create_vacancies_responsibilities_table = "CREATE TABLE vacancies_responsibilities (" +
            "id INT NOT NULL DEFAULT NEXTVAL('sequence_for_vacancies_responsibilities_table') PRIMARY KEY," +
            "vacancy_id INT NOT NULL REFERENCES vacancies ON DELETE CASCADE," +
            "responsibility_id INT NOT NULL REFERENCES responsibilities ON DELETE CASCADE" +
            ");";
    /*
    static final String create_sequence_for_requirements_table = "CREATE SEQUENCE sequence_for_requirements_table START WITH 1;";
    static final String drop_sequence_for_requirements_table = "DROP SEQUENCE IF EXISTS sequence_for_requirements_table;";
    static final String create_requirements_table = "CREATE TABLE requirements (" +
            "requirement_id INT NOT NULL DEFAULT NEXTVAL('sequence_for_requirements_table') PRIMARY KEY," +
            "requirement_name VARCHAR(255) NOT NULL UNIQUE" +
            ");";

    static final String create_sequence_for_applicants_requirements_table = "CREATE SEQUENCE sequence_for_applicants_requirements_table START WITH 1;";
    static final String drop_sequence_for_applicants_requirements_table = "DROP SEQUENCE IF EXISTS sequence_for_applicants_requirements_table;";
    static final String create_applicants_requirements_table = "CREATE TABLE applicants_requirements (" +
            "id INT NOT NULL DEFAULT NEXTVAL('sequence_for_applicants_requirements_table') PRIMARY KEY," +
            "applicant_id INT NOT NULL REFERENCES applicants ON DELETE CASCADE," +
            "requirement_id INT NOT NULL REFERENCES requirements ON DELETE CASCADE" +
            ");";

     */

    static final String create_sequence_for_vacancies_skills_table = "CREATE SEQUENCE sequence_for_vacancies_skills_table START WITH 1;";
    static final String drop_sequence_for_vacancies_skills_table = "DROP SEQUENCE IF EXISTS sequence_for_vacancies_skills_table;";
    static final String create_vacancies_skills_table = "CREATE TABLE vacancies_skills (" +
            "id INT NOT NULL DEFAULT NEXTVAL('sequence_for_vacancies_skills_table') PRIMARY KEY," +
            "vacancy_id INT NOT NULL REFERENCES vacancies ON DELETE CASCADE," +
            "skills_id INT NOT NULL REFERENCES skills ON DELETE CASCADE" +
            ");";

    static final String create_sequence_for_conditions_table = "CREATE SEQUENCE sequence_for_conditions_table START WITH 1;";
    static final String drop_sequence_for_conditions_table = "DROP SEQUENCE IF EXISTS sequence_for_conditions_table;";
    static final String create_conditions_table = "CREATE TABLE conditions (" +
            "condition_id INT NOT NULL DEFAULT NEXTVAL('sequence_for_conditions_table') PRIMARY KEY," +
            "condition_name VARCHAR(255) NOT NULL UNIQUE" +
            ");";

    static final String create_sequence_for_applicants_conditions_table = "CREATE SEQUENCE sequence_for_applicants_conditions_table START WITH 1;";
    static final String drop_sequence_for_applicants_conditions_table = "DROP SEQUENCE IF EXISTS sequence_for_applicants_conditions_table;";
    static final String create_applicants_conditions_table = "CREATE TABLE applicants_conditions (" +
            "id INT NOT NULL DEFAULT NEXTVAL('sequence_for_applicants_conditions_table') PRIMARY KEY," +
            "applicant_id INT NOT NULL REFERENCES applicants ON DELETE CASCADE," +
            "condition_id INT NOT NULL REFERENCES conditions ON DELETE CASCADE" +
            ");";

    static final String create_sequence_for_vacancies_conditions_table = "CREATE SEQUENCE sequence_for_vacancies_conditions_table START WITH 1;";
    static final String drop_sequence_for_vacancies_conditions_table = "DROP SEQUENCE IF EXISTS sequence_for_vacancies_conditions_table;";
    static final String create_vacancies_conditions_table = "CREATE TABLE vacancies_conditions (" +
            "id INT NOT NULL DEFAULT NEXTVAL('sequence_for_vacancies_conditions_table') PRIMARY KEY," +
            "vacancy_id INT NOT NULL REFERENCES vacancies ON DELETE CASCADE," +
            "condition_id INT NOT NULL REFERENCES conditions ON DELETE CASCADE" +
            ");";

    static final String create_sequence_for_vacancies_applicants_table = "CREATE SEQUENCE sequence_for_vacancies_applicants_table START WITH 1;";
    static final String drop_sequence_for_vacancies_applicants_table = "DROP SEQUENCE IF EXISTS sequence_for_vacancies_applicants_table;";
    static final String create_vacancies_applicants_table = "CREATE TABLE vacancies_applicants (" +
            "id INT NOT NULL DEFAULT NEXTVAL('sequence_for_vacancies_applicants_table') PRIMARY KEY," +
            "vacancy_id INT NOT NULL REFERENCES vacancies ON DELETE CASCADE," +
            "applicant_id INT NOT NULL REFERENCES applicants ON DELETE CASCADE," +
            "status VARCHAR(255) NOT NULL," +
            "CONSTRAINT status_check CHECK(status IN ('Не просмотрено', 'Просмотренно', 'Приглашение', 'Отказ'))" +
            ");";

    static final String alter_drop_constraint_table = "ALTER TABLE applicants DROP CONSTRAINT phone_number_check;";
    static final String alter_add_constraint_table = "ALTER TABLE applicants ADD CONSTRAINT phone_number_check CHECK (phone_number LIKE '+7__________' OR phone_number LIKE '8__________');";

    public static boolean checkTableExistence(String tableName) throws SQLException {
        DatabaseMetaData databaseMetaData = Start.getDBConnection().getMetaData();
        ResultSet resultSet = databaseMetaData.getTables(null, null, tableName, null);
        return resultSet.next();
    }
    public static void createTable(String createTable, String createSequence) throws SQLException {
        Connection connection = Start.getDBConnection();
        Statement statement = connection.createStatement();
        try {
            //statement.execute(createSequence);
            statement.execute(createTable);
        } finally {
            statement.close();
            connection.close();
        }
    }
    public static void dropTable(String tableName, String sequenceName) throws SQLException {
        Connection connection = Start.getDBConnection();
        Statement statement = connection.createStatement();
        try {
            statement.execute("DROP TABLE " + tableName);
            statement.execute(sequenceName);
        } finally {
            statement.close();
            connection.close();
        }
    }
}
