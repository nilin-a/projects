package com.diploma.server.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "medic", schema = "public")
public class Medic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    private User user;

    private String name;

    private String specialty;

    private String education;

    private String workPlace;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private List<Patient> patients;
}
