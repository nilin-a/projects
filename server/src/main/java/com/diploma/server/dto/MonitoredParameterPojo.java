package com.diploma.server.dto;

import com.diploma.server.entity.MonitoredParameter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MonitoredParameterPojo {
    private long id;
    private String name;
    private String description;

    public static MonitoredParameterPojo fromEntity(MonitoredParameter entity) {
        MonitoredParameterPojo pojo = new MonitoredParameterPojo();
        pojo.setId(entity.getId());
        pojo.setName(entity.getName());
        pojo.setDescription(entity.getDescription());
        return pojo;
    }

    public static MonitoredParameter toEntity(MonitoredParameterPojo pojo) {
        MonitoredParameter entity = new MonitoredParameter();
        entity.setId(pojo.getId());
        entity.setName(pojo.getName());
        entity.setDescription(pojo.getDescription());
        return entity;
    }
}
