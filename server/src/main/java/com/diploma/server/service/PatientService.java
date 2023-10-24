package com.diploma.server.service;
import com.diploma.server.dto.MedicPojo;
import com.diploma.server.dto.PatientPojo;
import com.diploma.server.entity.Medic;
import com.diploma.server.entity.Patient;
import com.diploma.server.entity.User;
import com.diploma.server.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private UserService userService;

    public PatientPojo updatePatient(PatientPojo newPatient, String token) throws Exception {
        Patient patient = getPatient(token);
        if(newPatient.getName() != null && !newPatient.getName().trim().isEmpty()) {
            patient.setName(newPatient.getName());
        }
        if(newPatient.getBirthDate() != null) {
            patient.setBirthDate(newPatient.getBirthDate());
        }
        if(newPatient.getSex() != null) {
            patient.setSex(newPatient.getSex());
        }
        patientRepository.save(patient);
        return PatientPojo.fromEntity(patient);
    }
    public Patient getPatient(String token) throws Exception {
        User user = userService.validateUser(token);
        return patientRepository.findPatientByUser(user);
    }

    public PatientPojo getPatientPojo(String token) throws Exception {
        return PatientPojo.fromEntity(getPatient(token));
    }

    public Patient getPatientById(long id) throws Exception {
        return patientRepository.findPatientById(id);
    }

    public List<MedicPojo> getMyMedics(String token) throws Exception{
        Patient patient = getPatient(token);
        List<Medic> medicList = patient.getMedics();
        List<MedicPojo> medicPojoList = new ArrayList<>();
        for (Medic medic: medicList) {
            medicPojoList.add(MedicPojo.fromEntity(medic));
        }
        return medicPojoList;
    }

    public PatientPojo getPatientByMedicalCardId(long id) {
        Patient patient = patientRepository.findPatientByMedicalCardId(id);
        return PatientPojo.fromEntity(patient);
    }
}
