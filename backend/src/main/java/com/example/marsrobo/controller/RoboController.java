package com.example.marsrobo.controller;

import com.example.marsrobo.service.RoboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/mars")
public class RoboController {

    @Autowired
    private RoboService roboService;

    @GetMapping("/{commands}")
    public ResponseEntity<String> moveRobo(@PathVariable String commands) {
        try {
            String position = roboService.processCommands(commands);
            return ResponseEntity.ok(position);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("400 Bad Request");
        }
    }
}
