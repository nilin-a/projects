package com.coursework.controller;

import com.coursework.dto.LessonPojo;
import com.coursework.entity.User;
import com.coursework.service.LessonService;
import com.coursework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/coursework/lesson")
public class LessonController {
    @Autowired
    private LessonService lessonService;

    @Autowired
    private UserService userService;

    @PostMapping("/teach/create")
    public ResponseEntity<LessonPojo> createLesson(@RequestBody LessonPojo lessonPojo, @RequestHeader("Authorization") String token) {
        try {
            User user = userService.validateUser(token);
            if (user.getRole() != User.Role.TEACHER) {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            return ResponseEntity.ok(lessonService.createLesson(lessonPojo, user));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/teach/delete/{lessonId}")
    public ResponseEntity deleteLesson(@PathVariable long lessonId, @RequestHeader("Authorization") String token) {
        try {
            User user = userService.validateUser(token);
            if (user.getRole() != User.Role.TEACHER) {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            lessonService.deleteLesson(lessonId);
            return ResponseEntity.ok("");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/book")
    public ResponseEntity<LessonPojo> bookLesson(@RequestBody LessonPojo lessonPojo, @RequestHeader("Authorization") String token) {
        try {
            User user = userService.validateUser(token);
            if (user.getRole() != User.Role.STUDENT) {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            return ResponseEntity.ok(lessonService.bookLesson(lessonPojo, user));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/book/delete/{lessonId}")
    public ResponseEntity<?> unBookLesson(@PathVariable long lessonId, @RequestHeader("Authorization") String token) {
        try {
            User user = userService.validateUser(token);
            if (user.getRole() != User.Role.STUDENT) {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            lessonService.unBookLesson(lessonId, user);
            return ResponseEntity.ok("");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/readAll")
    public ResponseEntity<List<LessonPojo>> readAll() {
        try {
            return ResponseEntity.ok(lessonService.findAll());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/read/available")
    public ResponseEntity<List<LessonPojo>> readAvailable(@RequestHeader("Authorization") String token) {
        try {
            User user = userService.validateUser(token);
            return ResponseEntity.ok(lessonService.findAvailable(user));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Список уроков на которые записан ученик
    @GetMapping("/read")
    public ResponseEntity<List<LessonPojo>> read(@RequestHeader("Authorization") String token) {
        try {
            User user = userService.validateUser(token);
            return ResponseEntity.ok(lessonService.findByStudent(user));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Список уроков которые ведет учитель
    @GetMapping("/teach/read")
    public ResponseEntity<List<LessonPojo>> teachRead(@RequestHeader("Authorization") String token) {
        try {
            User user = userService.validateUser(token);
            if (user.getRole() != User.Role.TEACHER) {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            return ResponseEntity.ok(lessonService.findByTeacher(user));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
