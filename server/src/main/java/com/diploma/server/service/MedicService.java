package com.diploma.server.service;
import com.diploma.server.dto.MedicPojo;
import com.diploma.server.dto.MedicalCardPojo;
import com.diploma.server.dto.PatientPojo;
import com.diploma.server.entity.*;
import com.diploma.server.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicService {
    @Autowired
    private MedicRepository medicRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private QuestionnaireRepository questionnaireRepository;
    @Autowired
    private MedicalCardService medicalCardService;

    public MedicPojo updateMedic(MedicPojo newMedic, String token) throws Exception {
        Medic medic = getMedic(token);
        if(newMedic.getName() != null && !newMedic.getName().trim().isEmpty()) {
            medic.setName(newMedic.getName());
        }
        if(newMedic.getSpecialty() != null && !newMedic.getSpecialty().trim().isEmpty()) {
            medic.setSpecialty(newMedic.getSpecialty());
        }
        if(newMedic.getEducation() != null && !newMedic.getEducation().trim().isEmpty()) {
            medic.setEducation(newMedic.getEducation());
        }
        if(newMedic.getWorkPlace() != null && !newMedic.getWorkPlace().trim().isEmpty()) {
            medic.setWorkPlace(newMedic.getWorkPlace());
        }
        medicRepository.save(medic);
        return MedicPojo.fromEntity(medic);
    }

    public Medic getMedic(String token) throws Exception{
        User user = userService.validateUser(token);
        return medicRepository.findMedicByUser(user);
    }

    public Medic getMedicById(long id) {
        return  medicRepository.findMedicById(id);
    }

    public MedicPojo getMedicPojo(String token) throws Exception {
        return MedicPojo.fromEntity(getMedic(token));
    }

    public MedicPojo addPatient(String login, String token) throws Exception{
        Medic medic = getMedic(token);
        User user = userRepository.findUserByLogin(login);
        Patient patient = patientRepository.findPatientByUser(user);
        if (!medic.getPatients().contains(patient)) {
            List<Patient> patientList = medic.getPatients();
            patientList.add(patient);
            medic.setPatients(patientList);
            medicRepository.save(medic);
        }
        return MedicPojo.fromEntity(medic);
    }

    public List<PatientPojo> getMyPatients(String token) throws Exception {
        Medic medic = getMedic(token);
        List<Patient> patients = medic.getPatients();
        List<PatientPojo> patientPojos = new ArrayList<>();
        for (Patient patient: patients) {
            patientPojos.add(PatientPojo.fromEntity(patient));
        }
        return patientPojos;
    }

    public void deleteMyPatient(long id, String token) throws Exception{
        Medic medic = getMedic(token);
        Patient patient = patientRepository.findPatientById(id);
        List<Questionnaire> questionnaireList = questionnaireRepository.findAllByMedicalCard(MedicalCardPojo.toEntity(medicalCardService.getMedicalCardByPatientId(id)));
        List<Questionnaire> questionnaireListDelete = new ArrayList<>();
        for (Questionnaire questionnaire: questionnaireList) {
            if (questionnaire.getStatus() != Questionnaire.Status.ANSWERED) {
                questionnaireListDelete.add(questionnaire);
            }
        }
        questionnaireRepository.deleteAll(questionnaireListDelete);
        medic.getPatients().remove(patient);
        medicRepository.save(medic);
    }
}
