package com.example.ame.controller;

import com.example.ame.model.Tutor;
import com.example.ame.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veterinarios-canil")
public class VeterinarioCanilController {

    @Autowired
    private TutorService service;

    @GetMapping
    public ResponseEntity<List<Tutor>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tutor> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Tutor> save(@RequestBody Tutor tutor) {
        return ResponseEntity.ok(service.save(tutor));
    }
}
