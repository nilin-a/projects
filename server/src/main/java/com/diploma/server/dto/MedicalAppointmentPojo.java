package com.diploma.server.dto;

import com.diploma.server.entity.MedicalAppointment;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MedicalAppointmentPojo {
    private long id;
    private MedicPojo medic;
    private MedicalCardPojo medicalCard;
    private Date date;
    private String symptoms;
    private String  diagnosis;
    private String analyses;
    private String  treatment;
    private String recommendation;

    public static MedicalAppointmentPojo fromEntity(MedicalAppointment entity){
        MedicalAppointmentPojo pojo = new MedicalAppointmentPojo();
        pojo.setId(entity.getId());
        pojo.setMedic(MedicPojo.fromEntity(entity.getMedic()));
        pojo.setMedicalCard(MedicalCardPojo.fromEntity(entity.getMedicalCard()));
        pojo.setDate(entity.getDate());
        pojo.setSymptoms(entity.getSymptoms());
        pojo.setDiagnosis(entity.getDiagnosis());
        pojo.setAnalyses(entity.getAnalyses());
        pojo.setTreatment(entity.getTreatment());
        pojo.setRecommendation(entity.getRecommendation());
        return pojo;
    }

    public static MedicalAppointment toEntity(MedicalAppointmentPojo pojo){
        MedicalAppointment entity = new MedicalAppointment();
        entity.setMedicalCard(MedicalCardPojo.toEntity(pojo.getMedicalCard()));
        entity.setDate(pojo.getDate());
        entity.setSymptoms(pojo.getSymptoms());
        entity.setDiagnosis(pojo.getDiagnosis());
        entity.setAnalyses(pojo.getAnalyses());
        entity.setTreatment(pojo.getTreatment());
        entity.setRecommendation(pojo.getRecommendation());
        return entity;
    }
}
