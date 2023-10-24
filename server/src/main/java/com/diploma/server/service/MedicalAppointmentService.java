package com.diploma.server.service;

import com.diploma.server.dto.MedicalAppointmentPojo;
import com.diploma.server.dto.MedicalCardPojo;
import com.diploma.server.entity.Medic;
import com.diploma.server.entity.MedicalAppointment;
import com.diploma.server.entity.MedicalCard;
import com.diploma.server.entity.Patient;
import com.diploma.server.repository.MedicalAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicalAppointmentService {
    @Autowired
    private MedicalAppointmentRepository medicalAppointmentRepository;
    @Autowired
    private MedicService medicService;
    @Autowired
    private MedicalCardService medicalCardService;

    public MedicalAppointmentPojo createMA(MedicalAppointmentPojo medicalAppointmentPojo, String token) throws Exception {
        MedicalAppointment medicalAppointment = MedicalAppointmentPojo.toEntity(medicalAppointmentPojo);
        medicalAppointment.setMedic(medicService.getMedic(token));
        medicalAppointmentRepository.save(medicalAppointment);
        return MedicalAppointmentPojo.fromEntity(medicalAppointment);
    }

    public List<MedicalAppointmentPojo> getAllByMedic(String token) throws Exception {
        Medic medic = medicService.getMedic(token);
        List<MedicalAppointment> medicalAppointmentList = medicalAppointmentRepository.findAllByMedic(medic);
        List<MedicalAppointmentPojo> medicalAppointmentPojos = new ArrayList<>();
        for (MedicalAppointment mA: medicalAppointmentList) {
            medicalAppointmentPojos.add(MedicalAppointmentPojo.fromEntity(mA));
        }
        return medicalAppointmentPojos;
    }

    public List<MedicalAppointmentPojo> getAllForPatientByMedicId(long id, String token) throws Exception {
        Medic medic = medicService.getMedicById(id);
        MedicalCard medicalCard = medicalCardService.getMedicalCardByToken(token);
        List<MedicalAppointment> medicalAppointmentList = medicalAppointmentRepository.findAllByMedicalCardAndMedic(medicalCard, medic);
        List<MedicalAppointmentPojo> medicalAppointmentPojos = new ArrayList<>();
        for (MedicalAppointment mA: medicalAppointmentList) {
            medicalAppointmentPojos.add(MedicalAppointmentPojo.fromEntity(mA));
        }
        return medicalAppointmentPojos;
    }

    public List<MedicalAppointmentPojo> getAllByPatientId(long id, String token) throws Exception {
        Medic medic = medicService.getMedic(token);
        MedicalCard medicalCard = MedicalCardPojo.toEntity(medicalCardService.getMedicalCardByPatientId(id));
        List<MedicalAppointment> medicalAppointmentList = medicalAppointmentRepository.findAllByMedicalCardAndMedic(medicalCard, medic);
        List<MedicalAppointmentPojo> medicalAppointmentPojos = new ArrayList<>();
        for (MedicalAppointment mA: medicalAppointmentList) {
            medicalAppointmentPojos.add(MedicalAppointmentPojo.fromEntity(mA));
        }
        return medicalAppointmentPojos;
    }

    public void deleteMedicalAppointment(long id) {
        MedicalAppointment medicalAppointment = medicalAppointmentRepository.findById(id).orElseThrow();
        medicalAppointmentRepository.delete(medicalAppointment);
    }

    public MedicalAppointmentPojo updateMedicalAppointment(MedicalAppointmentPojo medicalAppointmentPojo) {
        MedicalAppointment medicalAppointment = medicalAppointmentRepository.findById(medicalAppointmentPojo.getId()).orElseThrow();
        if (medicalAppointmentPojo.getDate() != null) {
            medicalAppointment.setDate(medicalAppointmentPojo.getDate());
        }
        if (medicalAppointmentPojo.getSymptoms() != null && !medicalAppointmentPojo.getSymptoms().trim().isEmpty()) {
            medicalAppointment.setSymptoms(medicalAppointmentPojo.getSymptoms());
        }
        if (medicalAppointmentPojo.getAnalyses() != null && !medicalAppointmentPojo.getAnalyses().trim().isEmpty()) {
            medicalAppointment.setAnalyses(medicalAppointmentPojo.getAnalyses());
        }
        if (medicalAppointmentPojo.getDiagnosis() != null && !medicalAppointmentPojo.getDiagnosis().trim().isEmpty()) {
            medicalAppointment.setDiagnosis(medicalAppointmentPojo.getDiagnosis());
        }
        if (medicalAppointmentPojo.getTreatment() != null && !medicalAppointmentPojo.getTreatment().trim().isEmpty()) {
            medicalAppointment.setTreatment(medicalAppointmentPojo.getTreatment());
        }
        if (medicalAppointmentPojo.getRecommendation() != null && !medicalAppointmentPojo.getRecommendation().trim().isEmpty()) {
            medicalAppointment.setRecommendation(medicalAppointmentPojo.getRecommendation());
        }
        medicalAppointmentRepository.save(medicalAppointment);
        return MedicalAppointmentPojo.fromEntity(medicalAppointment);
    }
}
