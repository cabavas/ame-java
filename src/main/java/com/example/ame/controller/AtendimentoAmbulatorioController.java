package com.example.ame.controller;

import com.example.ame.model.AtendimentoAmbulatorio;
import com.example.ame.model.Tutor;
import com.example.ame.service.AtendimentoAmbulatorioService;
import com.example.ame.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atendimentos-ambulatorio")
public class AtendimentoAmbulatorioController {

    @Autowired
    private AtendimentoAmbulatorioService service;

    @GetMapping
    public ResponseEntity<List<AtendimentoAmbulatorio>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtendimentoAmbulatorio> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<AtendimentoAmbulatorio> save(@RequestBody AtendimentoAmbulatorio atendimentoAmbulatorio) {
        return ResponseEntity.ok(service.save(atendimentoAmbulatorio));
    }
}
