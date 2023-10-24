package com.diploma.server.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "questionnaire", schema = "public")
public class Questionnaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private  MedicalCard  medicalCard;

    @ManyToOne
    private Medic medic;

    @Column(nullable = false)
    private Date date;

    @ManyToMany
    private List<MonitoredParameter> parameterList;

    private String optional;

    private int result;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String medicsRespond;

    @OneToMany(cascade = CascadeType.DETACH)
    private List<PatientResponse> filledPatientData;

    public enum Status {
        SENT_TO_PATIENT,
        SENT_TO_MEDIC,
        ANSWERED,
        DENIED,
    }
}
