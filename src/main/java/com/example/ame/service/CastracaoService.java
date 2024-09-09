package com.example.ame.service;

import com.example.ame.model.Castracao;
import com.example.ame.repository.CastracaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CastracaoService {

    @Autowired
    private CastracaoRepository repo;

    public List<Castracao> findAll() {return repo.findAll();}

    public Castracao findById(Integer id) {return repo.findById(id).orElse(null);}

    public Castracao save(Castracao castracao) {
        return repo.save(castracao);
    }

    public Castracao findByProtocol(String protocol) {return repo.findByProtocol(protocol);}
}
