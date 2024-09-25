package com.example.ame.service;

import com.example.ame.model.TipoProcedimento;
import com.example.ame.repository.TipoProcedimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TipoProcedimentoService {

    @Autowired
    private TipoProcedimentoRepository tipoProcedimentoRepository;

    public String findNomeById(Integer id) {
        TipoProcedimento tipoProcedimento = (TipoProcedimento) tipoProcedimentoRepository.findById(id).orElse(null);
        return tipoProcedimentoRepository.findById(id)
                .map(TipoProcedimento::getName)
                .orElse(null);
    }
}
