package com.coursework.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="sessions", schema = "public")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String token;

    @ManyToOne()
    private User user;

    public Session(String token, User user) {
        this.token = token;
        this.user = user;
    }

    public Session() {

    }
}
