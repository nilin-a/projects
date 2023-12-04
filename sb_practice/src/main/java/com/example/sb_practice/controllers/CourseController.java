package com.example.sb_practice.controllers;

import com.example.sb_practice.entities.Course;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {
    @GetMapping("/courses")
    public List<Course> retrieveAllCourses() {
        return Arrays.asList(
                new Course(1, "java", "liza"),
                new Course(2, "java", "liza"),
                new Course(5, "java1", "liza1")
        );
    }

    @GetMapping("hi-html")
    public String greetingHtml() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<html>");
        stringBuffer.append("<head>");
        stringBuffer.append("<title>");
        stringBuffer.append("Title hi");
        stringBuffer.append("</title>");
        stringBuffer.append("</head>");
        stringBuffer.append("<body>");
        stringBuffer.append("Body hi");
        stringBuffer.append("</body>");
        stringBuffer.append("/<html>");
        return stringBuffer.toString();
    }
    @GetMapping("/hi")
    public ModelAndView helloJSP() {
        int a =0;
        return new ModelAndView("hello");
    }
}
