package com.example.ame.controller;

import com.example.ame.model.Tutor;
import com.example.ame.model.VeterinarioCanil;
import com.example.ame.service.TutorService;
import com.example.ame.service.VeterinarioCanilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veterinario-canil")
public class VeterinarioCanilController {

    @Autowired
    private VeterinarioCanilService service;

    @GetMapping
    public ResponseEntity<List<VeterinarioCanil>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeterinarioCanil> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<VeterinarioCanil> save(@RequestBody VeterinarioCanil veterinarioCanil) {
        return ResponseEntity.ok(service.save(veterinarioCanil));
    }
}
