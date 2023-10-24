package com.diploma.server.dto;

import com.diploma.server.entity.Medic;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicPojo {
    private long id;
    private String name;
    private String specialty;
    private String education;
    private String workPlace;

    public static MedicPojo fromEntity(Medic entity) {
        MedicPojo pojo = new MedicPojo();
        pojo.setId(entity.getId());
        pojo.setName(entity.getName());
        pojo.setSpecialty(entity.getSpecialty());
        pojo.setEducation(entity.getEducation());
        pojo.setWorkPlace(entity.getWorkPlace());
        return pojo;
    }

    public static Medic toEntity(MedicPojo pojo) {
        Medic entity = new Medic();
        entity.setId(pojo.getId());
        entity.setName(pojo.getName());
        entity.setSpecialty(pojo.getSpecialty());
        entity.setEducation(pojo.getEducation());
        entity.setWorkPlace(pojo.getWorkPlace());
        return entity;
    }
}
