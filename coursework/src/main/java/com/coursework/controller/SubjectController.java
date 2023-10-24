package com.coursework.controller;

import com.coursework.dto.SubjectPojo;
import com.coursework.entity.User;
import com.coursework.service.SubjectService;
import com.coursework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/coursework/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<SubjectPojo> createSubject(@RequestBody SubjectPojo subjectPojo, @RequestHeader("Authorization") String token) {
        try {
            User user = userService.validateUser(token);
            if (user.getRole() != User.Role.TEACHER) {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            return ResponseEntity.ok(subjectService.createSubject(subjectPojo));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{subjectId}")
    public ResponseEntity deleteSubject(@PathVariable long subjectId, @RequestHeader("Authorization") String token) {
        try {
            User user = userService.validateUser(token);
            if (user.getRole() != User.Role.TEACHER) {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            subjectService.deleteSubject(subjectId);
            return ResponseEntity.ok("");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/read")
    public List<SubjectPojo> findAllSubject() {
        return subjectService.findAllSubject();
    }
}
