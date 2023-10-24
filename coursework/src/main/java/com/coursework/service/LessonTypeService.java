package com.coursework.service;

import com.coursework.dto.LessonTypePojo;
import com.coursework.entity.Lesson;
import com.coursework.entity.LessonType;
import com.coursework.repository.LessonRepository;
import com.coursework.repository.LessonTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LessonTypeService {

    @Autowired
    private LessonTypeRepository lessonTypeRepository;

    @Autowired
    private LessonRepository lessonRepository;

    public LessonTypePojo createLessonType(LessonTypePojo lessonTypePojo) {
        LessonType lessonType = LessonTypePojo.toEntity(lessonTypePojo);
        lessonTypeRepository.save(lessonType);
        return LessonTypePojo.fromEntity(lessonType);
    }

    public void deleteLessonType(long lessonTypeId) {
        LessonType lessonType = lessonTypeRepository.findById(lessonTypeId).orElseThrow();
        List<Lesson> lessons = lessonRepository.findLessonsByLessonType(lessonType);
        lessonRepository.deleteAll(lessons);
        lessonTypeRepository.delete(lessonType);
    }

    public List<LessonTypePojo> findAll() {
        List<LessonType> lessonTypes = lessonTypeRepository.findAll();
        List<LessonTypePojo> lessonTypePojos = new ArrayList<>();
        for (LessonType lessonType : lessonTypes) {
            lessonTypePojos.add(LessonTypePojo.fromEntity(lessonType));
        }
        return lessonTypePojos;
    }
}
