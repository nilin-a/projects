package com.diploma.server.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "medicalAppointment", schema = "public")
public class MedicalAppointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private MedicalCard medicalCard;

    @OneToOne
    private Medic medic;

    private Date date;

    private String symptoms;

    private String  diagnosis;

    private String analyses;

    private String  treatment;

    private String recommendation;
}
