package com.diploma.server.controller;

import com.diploma.server.dto.MedicalCardPojo;
import com.diploma.server.entity.User;
import com.diploma.server.service.MedicalCardService;
import com.diploma.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/diploma/medical-card")
public class MedicalCardController {
    @Autowired
    private MedicalCardService medicalCardService;
    @Autowired
    private UserService userService;

    @GetMapping("/read")
    public ResponseEntity<MedicalCardPojo> getMedicalCardByToken(@RequestHeader("Authorization") String token) {
        try {
            return ResponseEntity.ok(MedicalCardPojo.fromEntity(medicalCardService.getMedicalCardByToken(token)));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/read-by-id")
    public ResponseEntity<MedicalCardPojo> getMedicalCardByPatientId(@RequestBody long id, @RequestHeader("Authorization") String token) {
        try {
            User user = userService.validateUser(token);
            if (user.getRole() != User.Role.MEDIC) {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            return ResponseEntity.ok(medicalCardService.getMedicalCardByPatientId(id));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateMedicalCard(@RequestBody MedicalCardPojo medicalCardPojo, @RequestHeader("Authorization") String token) {
        try {
            return ResponseEntity.ok(medicalCardService.updateMedicalCard(medicalCardPojo, token));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
