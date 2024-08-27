package com.example.ame.repository;

import com.example.ame.model.Castracao;
import com.example.ame.model.Encaminhamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EncaminhamentoRepository extends JpaRepository<Encaminhamento, Integer> {
}
