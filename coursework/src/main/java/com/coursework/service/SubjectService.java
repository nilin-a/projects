package com.coursework.service;

import com.coursework.dto.SubjectPojo;
import com.coursework.dto.UserPojo;
import com.coursework.entity.Lesson;
import com.coursework.entity.LessonType;
import com.coursework.entity.Subject;
import com.coursework.entity.User;
import com.coursework.repository.LessonRepository;
import com.coursework.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private LessonRepository lessonRepository;

    public SubjectPojo createSubject(SubjectPojo subjectPojo) {
        Subject subject = SubjectPojo.toEntity(subjectPojo);
        subjectRepository.save(subject);
        return SubjectPojo.fromEntity(subject);
    }

    public List<SubjectPojo> findAllSubject() {
        List<Subject> subjects = subjectRepository.findAll();
        List<SubjectPojo> result = new ArrayList<>();
        for (Subject subject : subjects) {
            result.add(SubjectPojo.fromEntity(subject));
        }
        return result;
    }

    public void deleteSubject(long subjectId) {
        Subject subject = subjectRepository.findById(subjectId).orElseThrow();
        List<Lesson> lessons = lessonRepository.findLessonsBySubject(subject);
        lessonRepository.deleteAll(lessons);
        subjectRepository.delete(subject);
    }
}
