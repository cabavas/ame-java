package com.example.ame.service;

import com.example.ame.model.Atendimento;
import com.example.ame.repository.AtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtendimentoService {

    @Autowired
    private AtendimentoRepository repo;

    public List<Atendimento> findAll() {
        return repo.findAll();
    }

    public Atendimento findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Atendimento save(Atendimento atendimento) {
        return repo.save(atendimento);
    }

}
