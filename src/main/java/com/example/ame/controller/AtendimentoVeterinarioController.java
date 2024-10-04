package com.example.ame.controller;

import com.example.ame.model.Animal;
import com.example.ame.model.AtendimentoVeterinario;
import com.example.ame.service.AnimalService;
import com.example.ame.service.AtendimentoVeterinarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atendimentos-veterinarios")
public class AtendimentoVeterinarioController {

    @Autowired
    private AtendimentoVeterinarioService service;
    @Autowired
    private AnimalService animalService;

    @GetMapping
    public ResponseEntity<List<AtendimentoVeterinario>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtendimentoVeterinario> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<AtendimentoVeterinario> save(@RequestBody AtendimentoVeterinario atendimentoVeterinario) {
        Animal animal = atendimentoVeterinario.getAnimal();
        if (animal != null) {
            animalService.save(animal);
        }
        atendimentoVeterinario.setAnamnesis(animal.getAnamnesis());
        return ResponseEntity.ok(service.save(atendimentoVeterinario));
    }
}
