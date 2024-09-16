package com.example.ame.repository;

import com.example.ame.model.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento, Integer> {
    @Query("SELECT a FROM Atendimento a WHERE a.animal.tutor.cpf = :cpf")
    List<Atendimento> findByTutorCpf(@Param("cpf") String cpf);
}
