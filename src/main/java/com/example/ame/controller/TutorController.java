package com.example.ame.controller;

import com.example.ame.model.Tutor;
import com.example.ame.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tutors")
public class TutorController {

    @Autowired
    private TutorService service;

    @GetMapping
    public ResponseEntity<List<Tutor>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tutor> getAnimalById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getTutorById(id));
    }
}
