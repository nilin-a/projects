package com.diploma.server.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="userSession", schema = "public")
public class UserSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String token;

    @ManyToOne
    private User user;

    public UserSession(String token, User user) {
        this.token = token;
        this.user = user;
    }
    public UserSession() {

    }
}
