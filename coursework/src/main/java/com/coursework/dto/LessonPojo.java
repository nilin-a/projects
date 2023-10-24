package com.coursework.dto;

import com.coursework.entity.LessonType;
import com.coursework.entity.Lesson;
import com.coursework.entity.Subject;
import com.coursework.entity.User;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class LessonPojo {
    private long id;
    private LessonTypePojo lessonType;
    private UserPojo teacher;
    private SubjectPojo subject;
    private Integer currentStudentAmount;
    private Integer maxStudentAmount;
    private Date startTime;
    private List<UserPojo> students;

    public static LessonPojo fromEntity(Lesson lesson) {
        LessonPojo lessonPojo = new LessonPojo();
        lessonPojo.setId(lesson.getId());
        lessonPojo.setLessonType(LessonTypePojo.fromEntity(lesson.getLessonType()));
        lessonPojo.setTeacher(UserPojo.fromEntity(lesson.getTeacher()));
        lessonPojo.setSubject(SubjectPojo.fromEntity(lesson.getSubject()));
        lessonPojo.setCurrentStudentAmount(lesson.getCurrentStudentAmount());
        lessonPojo.setMaxStudentAmount(lesson.getMaxStudentAmount());
        lessonPojo.setStartTime(lesson.getStartTime());

        List<UserPojo> students = new ArrayList<>();
        lessonPojo.setStudents(students);
        for (User user : lesson.getStudents()) {
            students.add(UserPojo.fromEntity(user));
        }
        return lessonPojo;
    }

    public static Lesson toEntity(LessonPojo lessonPojo) {
        Lesson lesson = new Lesson();
        lesson.setId(lessonPojo.getId());
        lesson.setLessonType(LessonTypePojo.toEntity(lessonPojo.getLessonType()));
        lesson.setTeacher(UserPojo.toEntity(lessonPojo.getTeacher()));
        lesson.setSubject(SubjectPojo.toEntity(lessonPojo.getSubject()));
        lesson.setCurrentStudentAmount(lessonPojo.getCurrentStudentAmount());
        lesson.setMaxStudentAmount(lessonPojo.getMaxStudentAmount());
        lesson.setStartTime(lessonPojo.getStartTime());

        List<User> students = new ArrayList<>();
        lesson.setStudents(students);
        for (UserPojo userPojo : lessonPojo.getStudents()) {
            students.add(UserPojo.toEntity(userPojo));
        }
        return lesson;
    }

}
