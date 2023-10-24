package com.diploma.server.controller;

import com.diploma.server.dto.MedicPojo;
import com.diploma.server.dto.PatientPojo;
import com.diploma.server.service.MedicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/diploma/medic")
public class MedicController {
    @Autowired
    private MedicService medicService;

    @GetMapping("/me")
    public ResponseEntity<MedicPojo> getUser(@RequestHeader("Authorization") String token) {
        try {
            return ResponseEntity.ok(medicService.getMedicPojo(token));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> editMedic(@RequestBody MedicPojo medicPojo, @RequestHeader("Authorization") String token) {
        try {
            return ResponseEntity.ok(medicService.updateMedic(medicPojo, token));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add-patient")
    public ResponseEntity<MedicPojo> addPatient(@RequestBody String login, @RequestHeader("Authorization") String token) {
        try {
            return ResponseEntity.ok(medicService.addPatient(login, token));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-my-patients")
    public ResponseEntity<List<PatientPojo>> getMyPatients(@RequestHeader("Authorization") String token) {
        try {
            return ResponseEntity.ok(medicService.getMyPatients(token));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete-patient/{id}")
    public void deleteMyPatient(@PathVariable long id, @RequestHeader("Authorization") String token) {
        try {
            medicService.deleteMyPatient(id, token);
        } catch (Exception e) {
            e.printStackTrace();
            new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

