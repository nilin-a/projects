package com.coursework.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users", schema = "public")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String name;

    @Column(unique = true, nullable = false)
    private String login;

    private String password;

    public enum Role {
        STUDENT,
        TEACHER,
    }
}


