package com.example.ame.repository;

import com.example.ame.model.Procedimentos;
import com.example.ame.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcedimentosRepository extends JpaRepository<Procedimentos, Integer> {
}
