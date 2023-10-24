package com.diploma.server.controller;

import com.diploma.server.dto.MedicalAppointmentPojo;
import com.diploma.server.entity.User;
import com.diploma.server.service.MedicalAppointmentService;
import com.diploma.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/diploma/medical-appointment")
public class MedicalAppointmentController {
    @Autowired
    private MedicalAppointmentService medicalAppointmentService;
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<MedicalAppointmentPojo> createMedicalAppointment(@RequestBody MedicalAppointmentPojo medicalAppointmentPojo, @RequestHeader("Authorization") String token) {
        try {
            User user = userService.validateUser(token);
            if(user.getRole() != User.Role.MEDIC) {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            return ResponseEntity.ok(medicalAppointmentService.createMA(medicalAppointmentPojo, token));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/medic/read")
    public ResponseEntity<List<MedicalAppointmentPojo>> getAllByMedic(@RequestHeader("Authorization") String token) {
        try {
            User user = userService.validateUser(token);
            if(user.getRole() != User.Role.MEDIC) {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            return ResponseEntity.ok(medicalAppointmentService.getAllByMedic(token));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/medic/read/{id}")
    public ResponseEntity<List<MedicalAppointmentPojo>> getAllByPatientId(@PathVariable long id, @RequestHeader("Authorization") String token) {
        try {
            User user = userService.validateUser(token);
            if(user.getRole() != User.Role.MEDIC) {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            return ResponseEntity.ok(medicalAppointmentService.getAllByPatientId(id, token));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/patient/read/{id}")
    public ResponseEntity<List<MedicalAppointmentPojo>> getAllByMedicId(@PathVariable long id, @RequestHeader("Authorization") String token) {
        try {
            User user = userService.validateUser(token);
            if(user.getRole() != User.Role.PATIENT) {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            return ResponseEntity.ok(medicalAppointmentService.getAllForPatientByMedicId(id, token));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateMedicalAppointment(@RequestBody MedicalAppointmentPojo medicalAppointmentPojo, @RequestHeader("Authorization") String token) {
        try {
            User user = userService.validateUser(token);
            if(user.getRole() != User.Role.MEDIC) {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            return ResponseEntity.ok(medicalAppointmentService.updateMedicalAppointment(medicalAppointmentPojo));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMedicalAppointment(@RequestBody long id, @RequestHeader("Authorization") String token) {
        try {
            User user = userService.validateUser(token);
            if(user.getRole() != User.Role.MEDIC) {
                new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            medicalAppointmentService.deleteMedicalAppointment(id);
        } catch (Exception e)
        {
            new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
