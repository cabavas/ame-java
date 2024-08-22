package com.example.ame.controller;

import com.example.ame.model.Atendimento;
import com.example.ame.service.AtendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atendimentos")
public class AtendimentoController {

    @Autowired
    private AtendimentoService service;

    @GetMapping
    public ResponseEntity<List<Atendimento>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atendimento> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Atendimento> save(@RequestBody Atendimento atendimento) {
        return ResponseEntity.ok(service.save(atendimento));
    }
}
