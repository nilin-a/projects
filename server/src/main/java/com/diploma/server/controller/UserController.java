package com.diploma.server.controller;

import com.diploma.server.dto.RegistrationMedicPojo;
import com.diploma.server.dto.RegistrationPatientPojo;
import com.diploma.server.dto.UserPojo;
import com.diploma.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/diploma")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/registration/patient")
    public ResponseEntity<String> createPatient(@RequestBody RegistrationPatientPojo patientPojo) {
        try {
            return ResponseEntity.ok(userService.registrationPatient(patientPojo));
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/registration/medic")
    public ResponseEntity<String> createMedic(@RequestBody RegistrationMedicPojo medicPojo) {
        try {
            return ResponseEntity.ok(userService.registrationMedic(medicPojo));
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserPojo userPojo) {
        try {
            return ResponseEntity.ok(userService.login(userPojo));
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
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

    @GetMapping("/user/me")
    public ResponseEntity<UserPojo> getUser(@RequestHeader("Authorization") String token) {
        try {
            return ResponseEntity.ok(userService.getUser(token));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/user/update")
    public ResponseEntity<?> updateUser(@RequestBody UserPojo userPojo, @RequestHeader("Authorization") String token) {
        try {
            return ResponseEntity.ok(userService.updateUser(userPojo, token));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


}
