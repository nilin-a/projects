package com.coursework.controller;

import com.coursework.dto.LessonTypePojo;
import com.coursework.entity.User;
import com.coursework.service.LessonTypeService;
import com.coursework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/coursework/lessontype")
public class LessonTypeController {
    @Autowired
    private LessonTypeService lessonTypeService;

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<LessonTypePojo> createLessonType(@RequestBody LessonTypePojo lessonTypePojo, @RequestHeader("Authorization") String token) {
        try {
            User user = userService.validateUser(token);
            if (user.getRole() != User.Role.TEACHER) {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            return ResponseEntity.ok(lessonTypeService.createLessonType(lessonTypePojo));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/read")
    public List<LessonTypePojo> findAllLessonTypes() {
        return lessonTypeService.findAll();
    }

    @DeleteMapping("/delete/{typeId}")
    public void deleteLessonType(@PathVariable long typeId, @RequestHeader("Authorization") String token) {
        try {
            User user = userService.validateUser(token);
            if (user.getRole() != User.Role.TEACHER) {
                return;
            }
            lessonTypeService.deleteLessonType(typeId);
        } catch (Exception e) {
            return;
        }
    }
}
