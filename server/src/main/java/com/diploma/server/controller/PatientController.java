package com.diploma.server.controller;

import com.diploma.server.dto.MedicPojo;
import com.diploma.server.dto.PatientPojo;
import com.diploma.server.entity.User;
import com.diploma.server.service.PatientService;
import com.diploma.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/diploma/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private UserService userService;

    @GetMapping("/me")
    public ResponseEntity<PatientPojo> getPatient(@RequestHeader("Authorization") String token) {
        try {
            return ResponseEntity.ok(patientService.getPatientPojo(token));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> edit(@RequestBody PatientPojo patientPojo, @RequestHeader("Authorization") String token) {
        try {
            return ResponseEntity.ok(patientService.updatePatient(patientPojo, token));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-my-medics")
    public ResponseEntity<List<MedicPojo>> getMyMedics(@RequestHeader("Authorization") String token) {
        try {
            return ResponseEntity.ok(patientService.getMyMedics(token));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/get-by-medical-card-id")
    public ResponseEntity<PatientPojo> getPatientByMedicalCard(@RequestBody long id, @RequestHeader("Authorization") String token) {
        try {
            User user = userService.validateUser(token);
            if (user.getRole() != User.Role.MEDIC) {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            return ResponseEntity.ok(patientService.getPatientByMedicalCardId(id));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
