package com.example.ame.service;

import com.example.ame.model.Procedimento;
import com.example.ame.repository.ProcedimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcedimentosService {

    @Autowired
    private ProcedimentoRepository repo;

    public List<Procedimento> findAll() {
        return repo.findAll();
    }

    public Procedimento findById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public Procedimento save(Procedimento procedimento) {
        return repo.save(procedimento);
    }

}
