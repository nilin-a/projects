package com.coursework.controller;

import com.coursework.service.UserService;
import com.coursework.dto.UserPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/coursework/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public ResponseEntity<String> createUser(@RequestBody UserPojo userPojo) {
        try {
            return ResponseEntity.ok(userService.registration(userPojo));
        }
        catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> edit(@RequestBody UserPojo userPojo, @RequestHeader("Authorization") String token) {
        try {
            return ResponseEntity.ok(userService.updateUser(userPojo, token));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserPojo userPojo) {
        try {
            return ResponseEntity.ok(userService.login(userPojo));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/logout")
    public ResponseEntity logout(@RequestHeader("Authorization") String token) {
        try {
            userService.logout(token);
            return ResponseEntity.ok("");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/me")
    public ResponseEntity<UserPojo> getUser(@RequestHeader("Authorization") String token) {
        try {
            return ResponseEntity.ok(userService.getUser(token));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
