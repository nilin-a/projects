package com.coursework.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private LessonType lessonType;

    @ManyToOne
    private User teacher;

    @ManyToOne
    private Subject subject;

    private Integer currentStudentAmount;

    private Integer maxStudentAmount;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date startTime;

    @JsonIgnore
    @ManyToMany
    private List<User> students;
}
