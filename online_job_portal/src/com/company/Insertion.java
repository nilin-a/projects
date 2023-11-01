package com.company;

import java.sql.*;

public class Insertion {
    static final String insert_into_applicants_table = "INSERT INTO applicants " +
            "(first_name, last_name, mail_address, phone_number, birth_date, country, city, bio) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
    static final String insert_into_skills_table = "INSERT INTO skills (skill_name) VALUES (?);";
    static final String insert_into_applicants_skills_table = "INSERT INTO applicants_skills (applicant_id, skill_id) VALUES (?, ?);";
    static final String insert_into_conditions_table = "INSERT INTO conditions (condition_name) VALUES (?);";
    static final String insert_into_applicants_conditions_table = "INSERT INTO applicants_conditions (applicant_id, condition_id) VALUES (?, ?);";
    static final String insert_into_educations_table = "INSERT INTO educations (institution_name, faculty_name, specialty_name, start_year, end_year) VALUES (?, ?, ?, ?, ?);";
    static final String insert_into_applicants_educations_table = "INSERT INTO applicants_educations (applicant_id, education_id) VALUES (?, ?);";
    static final String insert_into_employment_types_table = "INSERT INTO employment_types (employment_type_name, work_hours_per_week, work_days_per_week) VALUES (?, ?, ?);";
    static final String insert_into_applicants_employment_types_table = "INSERT INTO applicants_employment_types (applicant_id, employment_type_id) VALUES (?, ?);";
    static final String insert_into_companies_table = "INSERT INTO companies (company_name, founding_day, description, country_address, city_address, street_address, building_address) VALUES (?, ?, ?, ?, ?, ?, ?);";
    static final String insert_into_jobs_table = "INSERT INTO jobs (applicant_id, company_id, job_title, start_date, end_date, successes) VALUES (?, ?, ?, ?, ?, ?);";

    public static int applicantsInsert(String firstName, String lastName, String mailAddress, String phoneNumber,
                                       Date birthDate, String country, String city, String bio) throws SQLException {
        Connection connection = Start.getDBConnection();
        PreparedStatement preparedStatement = null;
        int insertedRowsAmount = 0;
        try {
            preparedStatement = connection.prepareStatement(insert_into_applicants_table);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, mailAddress);
            preparedStatement.setString(4, phoneNumber);
            preparedStatement.setDate(5, birthDate);
            preparedStatement.setString(6, country);
            preparedStatement.setString(7, city);
            preparedStatement.setString(8, bio);
            insertedRowsAmount = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            preparedStatement.close();
            connection.close();
        }
        return insertedRowsAmount;
    }

    public static int skillsInsert(String skillName) throws SQLException {
        Connection connection = Start.getDBConnection();
        PreparedStatement preparedStatement = null;
        int insertedRowsAmount = 0;
        try {
            preparedStatement = connection.prepareStatement(insert_into_skills_table);
            preparedStatement.setString(1, skillName);
            insertedRowsAmount = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            preparedStatement.close();
            connection.close();
        }
        return insertedRowsAmount;
    }

    public static int applicantSkillsInsert(int applicantId, int skillId) throws SQLException {
        Connection connection = Start.getDBConnection();
        PreparedStatement preparedStatement = null;
        int insertedRowsAmount = 0;
        try {
            preparedStatement = connection.prepareStatement(insert_into_applicants_skills_table);
            preparedStatement.setInt(1, applicantId);
            preparedStatement.setInt(2, skillId);
            insertedRowsAmount = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            preparedStatement.close();
            connection.close();
        }
        return insertedRowsAmount;
    }

    public static int conditionsInsert(String conditionName) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int insertedRowsAmount = 0;
        try {
            connection = Start.getDBConnection();
            preparedStatement = connection.prepareStatement(insert_into_conditions_table);
            preparedStatement.setString(1, conditionName);
            insertedRowsAmount = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            preparedStatement.close();
            connection.close();
        }
        return insertedRowsAmount;
    }

    public static int applicantsConditionsInsert(int applicantId, int conditionId) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int insertedRowsAmount = 0;
        try {
            connection = Start.getDBConnection();
            preparedStatement = connection.prepareStatement(insert_into_applicants_conditions_table);
            preparedStatement.setInt(1, applicantId);
            preparedStatement.setInt(2, conditionId);
            insertedRowsAmount = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            preparedStatement.close();
            connection.close();
        }
        return insertedRowsAmount;
    }

    public static int educationsInsert(String institutionName, String facultyName, String specialtyName, Date startYear, Date endYear) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int insertedRowsAmount = 0;
        try {
            connection = Start.getDBConnection();
            preparedStatement = connection.prepareStatement(insert_into_educations_table);
            preparedStatement.setString(1, institutionName);
            preparedStatement.setString(2, facultyName);
            preparedStatement.setString(3, specialtyName);
            preparedStatement.setDate(4, startYear);
            preparedStatement.setDate(5, endYear);
            insertedRowsAmount = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            preparedStatement.close();
            connection.close();
        }
        return insertedRowsAmount;
    }

    public static int applicantsEducationsInsert(int applicantId, int educationId) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int insertedRowsAmount = 0;
        try {
            connection = Start.getDBConnection();
            preparedStatement = connection.prepareStatement(insert_into_applicants_educations_table);
            preparedStatement.setInt(1, applicantId);
            preparedStatement.setInt(2, educationId);
            insertedRowsAmount = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            preparedStatement.close();
            connection.close();
        }
        return insertedRowsAmount;
    }

    public static int employmentTypesInsert(String employmentTypeName, int workHoursPerWeek, int workDaysPerWeek) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int insertedRowsAmount = 0;
        try {
            connection = Start.getDBConnection();
            preparedStatement = connection.prepareStatement(insert_into_employment_types_table);
            preparedStatement.setString(1, employmentTypeName);
            preparedStatement.setInt(2, workHoursPerWeek);
            preparedStatement.setInt(3, workDaysPerWeek);
            insertedRowsAmount = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            preparedStatement.close();
            connection.close();
        }
        return insertedRowsAmount;
    }

    public static int applicantsEmploymentTypesInsert(int applicantId, int employmentTypeId) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int insertedRowsAmount = 0;
        try {
            connection = Start.getDBConnection();
            preparedStatement = connection.prepareStatement(insert_into_applicants_employment_types_table);
            preparedStatement.setInt(1, applicantId);
            preparedStatement.setInt(2, employmentTypeId);
            insertedRowsAmount = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            preparedStatement.close();
            connection.close();
        }
        return insertedRowsAmount;
    }

    public static int companiesInsert(String companyName, Date foundingDay, String description, String countryAddress,
                                      String cityAddress, String streetAddress, String buildingAddress) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int insertedRowsAmount = 0;
        try {
            connection = Start.getDBConnection();
            preparedStatement = connection.prepareStatement(insert_into_companies_table);
            preparedStatement.setString(1, companyName);
            preparedStatement.setDate(2, foundingDay);
            preparedStatement.setString(3, description);
            preparedStatement.setString(4, countryAddress);
            preparedStatement.setString(5, cityAddress);
            preparedStatement.setString(6, streetAddress);
            preparedStatement.setString(7, buildingAddress);
            insertedRowsAmount = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            preparedStatement.close();
            connection.close();
        }
        return insertedRowsAmount;
    }
    public static int jobsInsert(int applicantId, int companyId, String jobTitle, Date startDate, Date endDate, String successes) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int insertedRowsAmount = 0;
        try {
            connection = Start.getDBConnection();
            preparedStatement = connection.prepareStatement(insert_into_jobs_table);
            preparedStatement.setInt(1, applicantId);
            preparedStatement.setInt(2, companyId);
            preparedStatement.setString(3, jobTitle);
            preparedStatement.setDate(4, startDate);
            preparedStatement.setDate(5, endDate);
            preparedStatement.setString(6, successes);
            insertedRowsAmount = preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            preparedStatement.close();
            connection.close();
        }
        return insertedRowsAmount;
    }

}
