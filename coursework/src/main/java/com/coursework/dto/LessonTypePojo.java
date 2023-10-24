package com.coursework.dto;

import com.coursework.entity.LessonType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class LessonTypePojo {
    private long id;
    private String name;
    private int lasting;
    private String description;

    public static LessonTypePojo fromEntity(LessonType lessonType) {
        LessonTypePojo lessonTypePojo = new LessonTypePojo();
        lessonTypePojo.setId(lessonType.getId());
        lessonTypePojo.setName(lessonType.getName());
        lessonTypePojo.setLasting(lessonType.getLasting());
        lessonTypePojo.setDescription(lessonType.getDescription());
        return lessonTypePojo;
    }

    public  static LessonType toEntity(LessonTypePojo lessonTypePojo) {
        LessonType lessonType = new LessonType();
        lessonType.setId(lessonTypePojo.getId());
        lessonType.setName(lessonTypePojo.getName());
        lessonType.setLasting(lessonTypePojo.getLasting());
        lessonType.setDescription(lessonTypePojo.getDescription());
        return lessonType;
    }
}
