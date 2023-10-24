package com.diploma.server.controller;
import com.diploma.server.dto.QuestionnairePojo;
import com.diploma.server.entity.User;
import com.diploma.server.service.QuestionnaireService;
import com.diploma.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/diploma/questionnaire")
public class QuestionnaireController {
    @Autowired
    private QuestionnaireService questionnaireService;
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<QuestionnairePojo> createQuestionnaire(@RequestBody QuestionnairePojo questionnairePojo, @RequestHeader("Authorization") String token) {
        try {
            User user = userService.validateUser(token);
            if(user.getRole() != User.Role.MEDIC) {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            return ResponseEntity.ok(questionnaireService.createQuestionnaire(questionnairePojo,token));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/patient/fill")
    public ResponseEntity<?> answeredByPatientQuestionnaire(@RequestBody QuestionnairePojo questionnairePojo, @RequestHeader("Authorization") String token) {
        try {
            User user = userService.validateUser(token);
            if(user.getRole() != User.Role.PATIENT) {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            return  ResponseEntity.ok(questionnaireService.answeredByPatientQuestionnaire(questionnairePojo, token));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/medic/respond")
    public ResponseEntity<?> answeredByMedicQuestionnaire(@RequestBody QuestionnairePojo questionnairePojo, @RequestHeader("Authorization") String token) {
        try {
            User user = userService.validateUser(token);
            if(user.getRole() != User.Role.MEDIC) {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            return ResponseEntity.ok(questionnaireService.answeredByMedicQuestionnaire(questionnairePojo,token));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/medic/read")
    public ResponseEntity<List<QuestionnairePojo>> findAllQuestionnaireByMedic(@RequestHeader("Authorization") String token) {
        try {
            User user = userService.validateUser(token);
            if(user.getRole() != User.Role.MEDIC) {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            return ResponseEntity.ok(questionnaireService.findAllQuestionnaireByMedic(token));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/patient/read")
    public ResponseEntity<List<QuestionnairePojo>> findAllQuestionnaireByPatient(@RequestHeader("Authorization") String token) {
        try {
            User user = userService.validateUser(token);
            if(user.getRole() != User.Role.PATIENT) {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            return ResponseEntity.ok(questionnaireService.findAllQuestionnaireByPatient(token));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/patient/curve")
    public ResponseEntity<List<QuestionnairePojo>> findAllQuestionnaireForCurve(@RequestHeader("Authorization") String token) {
        try {
            User user = userService.validateUser(token);
            if(user.getRole() != User.Role.PATIENT) {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            return ResponseEntity.ok(questionnaireService.findAllQuestionnaireForCurve(token));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateQuestionnaire(@RequestBody QuestionnairePojo questionnairePojo, @RequestHeader("Authorization") String token) {
        try {
            User user = userService.validateUser(token);
            if (user.getRole() != User.Role.PATIENT || user.getRole() != User.Role.MEDIC) {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            return ResponseEntity.ok(questionnaireService.updateQuestionnaire(questionnairePojo));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteQuestionnaire(@PathVariable long id, @RequestHeader("Authorization") String token) {
        try {
            User user = userService.validateUser(token);
            if(user.getRole() != User.Role.MEDIC) {
                new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            questionnaireService.deleteQuestionnaire(id);
        } catch (Exception e) {
            new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
