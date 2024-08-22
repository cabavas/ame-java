package com.example.ame.controller;

import com.example.ame.model.AtendimentoVeterinario;
import com.example.ame.service.AtendimentoVeterinarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atendimentos-veterinario")
public class AtendimentoVeterinarioController {

    @Autowired
    private AtendimentoVeterinarioService service;

    @GetMapping
    public ResponseEntity<List<AtendimentoVeterinario>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtendimentoVeterinario> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<AtendimentoVeterinario> save(@RequestBody AtendimentoVeterinario atendimentoVeterinario) {
        return ResponseEntity.ok(service.save(atendimentoVeterinario));
    }
}
