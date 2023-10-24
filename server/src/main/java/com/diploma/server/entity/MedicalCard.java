package com.diploma.server.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "medicalCard", schema = "public")
public class MedicalCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int height;

    private int weight;

    private BloodType bloodType;

    private RhFactor rhFactor;

    private String  chronicDisease;

    private String  allergy;

    public enum  BloodType {
        O,
        A,
        B,
        AB,
    }

    public enum  RhFactor {
        RhPositive,
        RhNegative,
    }
}
