package com.example.ame.controller;

import com.example.ame.model.Procedimentos;
import com.example.ame.service.ProcedimentosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/procedimentos")
public class ProcedimentosController {

    @Autowired
    private ProcedimentosService service;

    @GetMapping
    public ResponseEntity<List<Procedimentos>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Procedimentos> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Procedimentos> save(@RequestBody Procedimentos procedimentos) {
        return ResponseEntity.ok(service.save(procedimentos));
    }
}
