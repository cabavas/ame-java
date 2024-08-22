package com.example.ame.service;

import com.example.ame.model.AtendimentoAmbulatorio;
import com.example.ame.model.AtendimentoVeterinario;
import com.example.ame.repository.AtendimentoAmbulatorioRepository;
import com.example.ame.repository.AtendimentoVeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtendimentoVeterinarioService {

    @Autowired
    private AtendimentoVeterinarioRepository repo;

    public List<AtendimentoVeterinario> findAll() {
        return repo.findAll();
    }

    public AtendimentoVeterinario findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public AtendimentoVeterinario save(AtendimentoVeterinario atendimento) {
        return repo.save(atendimento);
    }

}
