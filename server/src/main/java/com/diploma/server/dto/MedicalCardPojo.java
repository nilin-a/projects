package com.diploma.server.dto;

import com.diploma.server.entity.MedicalCard;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicalCardPojo {
    private long id;
    private int height;
    private int weight;
    private MedicalCard.BloodType bloodType;
    private MedicalCard.RhFactor rhFactor;
    private String  chronicDisease;
    private String  allergy;

    public static MedicalCardPojo fromEntity(MedicalCard entity) {
        MedicalCardPojo pojo = new MedicalCardPojo();
        pojo.setId(entity.getId());
        pojo.setHeight(entity.getHeight());
        pojo.setWeight(entity.getWeight());
        pojo.setBloodType(entity.getBloodType());
        pojo.setRhFactor(entity.getRhFactor());
        pojo.setChronicDisease(entity.getChronicDisease());
        pojo.setAllergy(entity.getAllergy());
        return pojo;
    }

    public static MedicalCard toEntity(MedicalCardPojo pojo) {
        MedicalCard entity = new MedicalCard();
        entity.setId(pojo.getId());
        entity.setHeight(pojo.getHeight());
        entity.setWeight(pojo.getWeight());
        entity.setBloodType(pojo.getBloodType());
        entity.setRhFactor(pojo.getRhFactor());
        entity.setChronicDisease(pojo.getChronicDisease());
        entity.setAllergy(pojo.getAllergy());
        return entity;
    }

}
