package com.diploma.server.dto;

import com.diploma.server.entity.Patient;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PatientPojo {
    private long id;
    private String name;
    private Date birthDate;
    private Patient.Sex sex;

    public static PatientPojo fromEntity(Patient patient) {
        PatientPojo patientPojo = new PatientPojo();
        patientPojo.setId(patient.getId());
        patientPojo.setName(patient.getName());
        patientPojo.setBirthDate(patient.getBirthDate());
        patientPojo.setSex(patient.getSex());
        return patientPojo;
    }

    public static Patient toEntity(PatientPojo patientPojo) {
        Patient patient = new Patient();
        patient.setId(patientPojo.getId());
        patient.setName(patientPojo.getName());
        patient.setBirthDate(patientPojo.getBirthDate());
        patient.setSex(patientPojo.getSex());
        return patient;
    }
}
