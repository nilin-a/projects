package com.coursework.service;

import com.coursework.dto.LessonPojo;
import com.coursework.entity.Lesson;
import com.coursework.entity.User;
import com.coursework.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class LessonService {
    @Autowired
    private LessonRepository lessonRepository;

    public LessonPojo createLesson(LessonPojo lessonPojo, User teacher) {
        Lesson lesson = LessonPojo.toEntity(lessonPojo);
        lesson.setCurrentStudentAmount(0);
        lesson.setTeacher(teacher);
        lessonRepository.save(lesson);
        return LessonPojo.fromEntity(lesson);
    }

    public LessonPojo bookLesson(LessonPojo lessonPojo, User user) {
        Lesson lesson = lessonRepository.findById(lessonPojo.getId()).orElseThrow();
        if (lesson.getCurrentStudentAmount() < lesson.getMaxStudentAmount() && !lesson.getStudents().contains(user)) {
            lesson.getStudents().add(user);
        }
        lesson.setCurrentStudentAmount(lesson.getCurrentStudentAmount() + 1);
        lessonRepository.save(lesson);
        return LessonPojo.fromEntity(lesson);
    }

    public void unBookLesson(long lessonId, User user) {
        Lesson lesson = lessonRepository.findById(lessonId).orElseThrow();
        if (lesson.getStudents().contains(user)) {
            lesson.getStudents().remove(user);
            lesson.setCurrentStudentAmount(lesson.getCurrentStudentAmount() - 1);
        }
        lessonRepository.save(lesson);
    }

    public List<LessonPojo> findAll() {
        List<Lesson> lessons = lessonRepository.findAll();
        List<LessonPojo> lessonPojos = new ArrayList<>();
        for (Lesson lesson : lessons) {
            lessonPojos.add(LessonPojo.fromEntity(lesson));
        }
        return lessonPojos;
    }

    public List<LessonPojo> findByStudent(User user) {
        List<Lesson> lessons = lessonRepository.findLessonsByStudentsContains(user);
        List<LessonPojo> lessonPojos = new ArrayList<>();
        for (Lesson lesson : lessons) {
            lessonPojos.add(LessonPojo.fromEntity(lesson));
        }
        return lessonPojos;
    }

    public List<LessonPojo> findByTeacher(User user) {
        List<Lesson> lessons = lessonRepository.findLessonsByTeacher(user);
        List<LessonPojo> lessonPojos = new ArrayList<>();
        for (Lesson lesson : lessons) {
            lessonPojos.add(LessonPojo.fromEntity(lesson));
        }
        return lessonPojos;
    }

    public List<LessonPojo> findAvailable(User user) {
        List<Lesson> lessons = lessonRepository.findAll();
        List<LessonPojo> lessonPojos = new ArrayList<>();
        for (Lesson lesson : lessons) {
            if (lesson.getCurrentStudentAmount() < lesson.getMaxStudentAmount() && lesson.getStartTime().after(java.sql.Date.valueOf(LocalDate.now())) && !lesson.getStudents().contains(user) ) {
                lessonPojos.add(LessonPojo.fromEntity(lesson));
            }
        }
        return lessonPojos;
    }

    public void deleteLesson(long lessonId) {
        lessonRepository.deleteById(lessonId);
    }
}
