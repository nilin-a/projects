package com.diploma.server.service;

import com.diploma.server.dto.MedicalCardPojo;
import com.diploma.server.entity.MedicalCard;
import com.diploma.server.entity.Patient;
import com.diploma.server.repository.MedicalCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalCardService {
    @Autowired
    private MedicalCardRepository medicalCardRepository;
    @Autowired
    private PatientService patientService;

    public MedicalCard getMedicalCardById(long id) {
        return medicalCardRepository.findById(id).orElseThrow();
    }
    public MedicalCard getMedicalCardByToken(String token) throws Exception {
        Patient patient = patientService.getPatient(token);
        return patient.getMedicalCard();
    }
    public MedicalCardPojo updateMedicalCard(MedicalCardPojo medicalCardPojo, String token) throws Exception {
        Patient patient = patientService.getPatient(token);
        MedicalCard medicalCard = patient.getMedicalCard();
        if (medicalCardPojo.getHeight() >= 140 && medicalCardPojo.getHeight() <= 230) {
            medicalCard.setHeight(medicalCardPojo.getHeight());
        }
        if (medicalCardPojo.getWeight() >= 35 && medicalCardPojo.getWeight() <= 250) {
            medicalCard.setWeight(medicalCardPojo.getWeight());
        }
        if (medicalCardPojo.getBloodType() != null) {
            medicalCard.setBloodType(medicalCardPojo.getBloodType());
        }
        if (medicalCardPojo.getRhFactor() != null) {
            medicalCard.setRhFactor(medicalCardPojo.getRhFactor());
        }
        if (medicalCardPojo.getChronicDisease() != null && !medicalCardPojo.getChronicDisease().trim().isEmpty()) {
            medicalCard.setChronicDisease(medicalCardPojo.getChronicDisease());
        }
        if (medicalCardPojo.getAllergy() != null && !medicalCardPojo.getAllergy().trim().isEmpty()) {
            medicalCard.setAllergy(medicalCardPojo.getAllergy());
        }
        medicalCardRepository.save(medicalCard);
        return MedicalCardPojo.fromEntity(medicalCard);
    }

    public MedicalCardPojo getMedicalCardByPatientId(long id) throws Exception {
        Patient patient = patientService.getPatientById(id);
       return MedicalCardPojo.fromEntity(patient.getMedicalCard());
    }
}
