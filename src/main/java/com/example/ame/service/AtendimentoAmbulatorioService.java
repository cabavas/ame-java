package com.example.ame.service;

import com.example.ame.model.Atendimento;
import com.example.ame.model.AtendimentoAmbulatorio;
import com.example.ame.repository.AtendimentoAmbulatorioRepository;
import com.example.ame.repository.AtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtendimentoAmbulatorioService {

    @Autowired
    private AtendimentoAmbulatorioRepository repo;

    public List<AtendimentoAmbulatorio> findAll() {
        return repo.findAll();
    }

    public AtendimentoAmbulatorio findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public AtendimentoAmbulatorio save(AtendimentoAmbulatorio ambulatorio) {
        return repo.save(ambulatorio);
    }

}
