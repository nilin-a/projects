package com.example.sb_practice.controllers;

import com.example.sb_practice.entities.Course;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {
    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses() {
        return Arrays.asList(
                new Course(1, "java", "liza"),
                new Course(2, "java", "liza"),
                new Course(5, "java1", "liza1")
        );
    }

}
