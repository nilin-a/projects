package com.diploma.server.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "patient", schema = "public")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private User user;

    @OneToOne(cascade = CascadeType.DETACH)
    private MedicalCard medicalCard;

    private String name;

    private Date birthDate;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    @ManyToMany(mappedBy = "patients", fetch = FetchType.LAZY)
    private List<Medic> medics;

    public enum Sex {
        MALE,
        FEMALE,
    }
}
