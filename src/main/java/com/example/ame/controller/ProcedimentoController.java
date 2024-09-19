package com.example.ame.controller;

import com.example.ame.model.Procedimento;
import com.example.ame.service.ProcedimentosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("procedimentos")
public class ProcedimentoController {

    @Autowired
    private ProcedimentosService service;

    @GetMapping
    public ResponseEntity<List<Procedimento>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Procedimento> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Procedimento> save(@RequestBody Procedimento procedimento) {
        return ResponseEntity.ok(service.save(procedimento));
    }
}
