package com.diploma.server.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PatientResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String response;

    @ManyToOne
    private Questionnaire questionnaire;

    @ManyToOne
    private MonitoredParameter parameter;

    public PatientResponse() {
    }

    public PatientResponse(String response, Questionnaire questionnaire, MonitoredParameter parameter) {
        this.id = id;
        this.response = response;
        this.questionnaire = questionnaire;
        this.parameter = parameter;
    }
}
