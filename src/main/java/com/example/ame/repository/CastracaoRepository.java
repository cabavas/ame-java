package com.example.ame.repository;

import com.example.ame.model.Castracao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CastracaoRepository extends JpaRepository<Castracao, Integer> {
    Castracao findByProtocol(String protocol);
    List<Castracao> findByClinicaId(int clinica);
    List<Castracao> findByClinicaIdNot(int clinica);

}
