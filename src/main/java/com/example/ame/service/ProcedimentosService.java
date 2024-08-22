package com.example.ame.service;

import com.example.ame.model.Procedimentos;
import com.example.ame.repository.ProcedimentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcedimentosService {

    @Autowired
    private ProcedimentosRepository repo;

    public List<Procedimentos> findAll() {
        return repo.findAll();
    }

    public Procedimentos findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Procedimentos save(Procedimentos procedimentos) {
        return repo.save(procedimentos);
    }

}
