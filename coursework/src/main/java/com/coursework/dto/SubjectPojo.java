package com.coursework.dto;

import com.coursework.entity.Subject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectPojo {

    private long id;
    private String name;

    public static SubjectPojo fromEntity(Subject subject) {
        SubjectPojo subjectPojo = new SubjectPojo();
        subjectPojo.setId(subject.getId());
        subjectPojo.setName(subject.getName());
        return subjectPojo;
    }

    public  static Subject toEntity(SubjectPojo subjectPojo) {
        Subject subject = new Subject();
        subject.setId(subjectPojo.getId());
        subject.setName(subjectPojo.getName());
        return subject;
    }
}
