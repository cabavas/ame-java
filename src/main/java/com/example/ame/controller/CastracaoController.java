package com.example.ame.controller;

import com.example.ame.model.AtendimentoAmbulatorio;
import com.example.ame.model.Castracao;
import com.example.ame.service.CastracaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("castracoes")
public class CastracaoController {

    @Autowired
    private CastracaoService service;

    @GetMapping
    public ResponseEntity<List<Castracao>> findAll() {return ResponseEntity.ok(service.findAll());}

    @GetMapping("/{id}")
    public ResponseEntity<Castracao> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Castracao> save(@RequestBody Castracao castracao) {
        return ResponseEntity.ok(service.save(castracao));
    }

}
