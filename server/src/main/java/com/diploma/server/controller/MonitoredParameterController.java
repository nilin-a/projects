package com.diploma.server.controller;

import com.diploma.server.dto.MonitoredParameterPojo;
import com.diploma.server.entity.User;
import com.diploma.server.service.MonitoredParameterService;
import com.diploma.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/diploma/monitored-parameter")
public class MonitoredParameterController {
    @Autowired
    private MonitoredParameterService monitoredParameterService;
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<MonitoredParameterPojo> create(@RequestBody MonitoredParameterPojo pojo, @RequestHeader("Authorization") String token) {
        try {
            User user = userService.validateUser(token);
            if (user.getRole() != User.Role.MEDIC) {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            return ResponseEntity.ok(monitoredParameterService.createMP(pojo));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/read")
    public ResponseEntity<List<MonitoredParameterPojo>> findAll(@RequestHeader("Authorization") String token) {
        try {
            User user = userService.validateUser(token);
            if (user.getRole() != User.Role.MEDIC) {
                new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            return ResponseEntity.ok(monitoredParameterService.findAllPojo());
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateMonitoredParameter(@RequestBody MonitoredParameterPojo monitoredParameterPojo, @RequestHeader("Authorization") String token) {
        try {
            User user = userService.validateUser(token);
            if (user.getRole() != User.Role.MEDIC) {
                new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            return ResponseEntity.ok(monitoredParameterService.updateMonitoredParameter(monitoredParameterPojo));
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id, @RequestHeader("Authorization") String token) {
        try {
            User user = userService.validateUser(token);
            if (user.getRole() != User.Role.MEDIC) {
                new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            monitoredParameterService.delete(id);
        } catch (Exception e) {
            new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
