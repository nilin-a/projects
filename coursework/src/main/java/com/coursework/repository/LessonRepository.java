package com.coursework.repository;

import com.coursework.entity.Lesson;
import com.coursework.entity.LessonType;
import com.coursework.entity.Subject;
import com.coursework.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
    List<Lesson> findLessonsByStudentsContains(User student);

    List<Lesson> findLessonsByTeacher(User teacher);

    List<Lesson> findLessonsByLessonType(LessonType lessonType);

    List<Lesson> findLessonsBySubject(Subject subject);
}
