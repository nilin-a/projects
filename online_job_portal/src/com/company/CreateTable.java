package com.company;

public class CreateTable {
    String create_sequence_for_applicants_table_query = "CREATE SEQUENCE sequence_for_applicants_table START WITH 1;";
    String drop_sequence_for_applicants_table_query = "DROP SEQUENCE sequence_for_applicants_table;";
    String create_applicants_table_query = "CREATE TABLE applicants (" +
            "applicant_id INT NOT NULL DEFAULT nextval('sequence_for_applicants_table')" +
            "first_name VARCHAR(255) NOT NULL" +
            "last_name VARCHAR(255) NOT NULL" +
            "mail_address VARCHAR(255)" +
            "phone_number VARCHAR(255)" +
            "birth_date DATE" +
            "country VARCHAR(255)" +
            "city VARCHAR(255)" +
            "bio text)";

    String create_sequence_for_educations_table_query = "CREATE SEQUENCE sequence_for_educations_table START WITH 1;";
    String drop_sequence_for_educations_table_query = "DROP SEQUENCE sequence_for_educations_table;";
    String create_educations_table = "CREATE TABLE education (" +
            "education_id INT NOT NULL DEFAULT nextval('sequence_for_educations_table')" +
            "institution_name VARCHAR(255) NOT NULL" +
            "faculty_name VARCHAR(255) NOT NULL" +
            "specialty_name VARCHAR(255) NOT NULL" +
            "start_year DATE" +
            "end_year DATE )";

    String create_sequence_for_skills_table_query = "CREATE SEQUENCE sequence_for_skills_table START WITH 1;";
    String drop_sequence_for_skills_table_query = "DROP SEQUENCE sequence_for_skills_table;";
    String create_skills_table = "CREATE TABLE skills (" +
            "skill_id INT NOT BULL DEFAULT nextval('sequence_for_skills_table')" +
            "skill_name VARCHAR(255) NOT NULL)";

    String create_sequence_for_jobs_table_query = "CREATE SEQUENCE sequence_for_jobs_table START WITH 1;";
    String drop_sequence_for_jobs_table_query = "DROP SEQUENCE sequence_for_jobs_table;";
    String create_jobs_table = "CREATE TABLE jobs (" +
            "job_id INT NOT NULL DEFAULT nextval('sequence_for_jobs_table')" +
            "job_name VARCHAR(255) NOT NULL" +
            "company_name VARCHAR(255) NOT NULL" +
            "start_date DATE" +
            "end_date DATE" +
            "responsibilities TEXT" +
            "successes TEXT;";

    String create_sequence_for_vacancies_table_query = "CREATE SEQUENCE sequence_for_vacancies_table START WITH 1;";
    String drop_sequence_for_vacancies_table_query = "DROP SEQUENCE sequence_for_vacancies_table;";
    String create_vacancies_table = "CREATE TABLE vacancies (" +
            "vacancy_id INT NOU NULL DEFAULT nextval('sequence_for_vacancies_table')" +
            "vacancy_name VARCHAR(255) NOT NULL" +
            "salary MONEY" +
            "required_work_experience INT" +
            "!employment_type" +
            "responsibilities TEXT" +
            "requirements TEXT" +
            "conditions";

    String create_sequence_for_employment_types_table_query = "CREATE SEQUENCE sequence_for_employment_types_table START WITH 1;";
    String drop_sequence_for_employment_types_table_query = "DROP SEQUENCE sequence_for_employment_types_table;";
    String create_employment_types_table = "CREATE TABLE employment_types (" +
            "employment_type_id INT NOT NULL DEFAULT nextval('sequence_for_employment_types_table')" +
            "employment_type_name VARCHAR(255) NOT NULL" +
            "work_hours_per_week INT" +
            "work_days_per_week INT;";

    String create_sequence_for_companies_table_query = "CREATE SEQUENCE sequence_for_companies_table START WITH 1;";
    String drop_sequence_for_companies_table_query = "DROP SEQUENCE sequence_for_companies_table;";
    String create_companies_table = "CREATE TABLE companies (" +
            "company_id INT NOT NULL DEFAULT nextval('sequence_for_companies_table')" +
            "company_name VARCHAR(255) NOT NULL" +
            "start_date DATE" +
            "founding_day TEXT;";
}
