package com.example.ame.service;

import com.example.ame.model.Castracao;
import com.example.ame.model.Encaminhamento;
import com.example.ame.repository.CastracaoRepository;
import com.example.ame.repository.EncaminhamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EncaminhamentoService {

    @Autowired
    private EncaminhamentoRepository repo;

    public List<Encaminhamento> findAll() {return repo.findAll();}

    public Encaminhamento findById(Long id) {return repo.findById(id).orElse(null);}

    public Encaminhamento save(Encaminhamento encaminhamento) {
        return repo.save(encaminhamento);
    }
}
