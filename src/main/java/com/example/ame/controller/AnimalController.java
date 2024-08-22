package com.example.ame.controller;

import com.example.ame.model.Animal;
import com.example.ame.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    @Autowired
    private AnimalService service;

    @GetMapping
    public ResponseEntity<List<Animal>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Animal> save(@RequestBody Animal animal) {
        return ResponseEntity.ok(service.save(animal));}
}
