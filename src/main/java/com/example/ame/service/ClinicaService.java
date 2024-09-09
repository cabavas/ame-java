package com.example.ame.service;
import com.example.ame.model.Animal;
import com.example.ame.model.Clinica;
import com.example.ame.repository.AnimalRepository;
import com.example.ame.repository.ClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClinicaService {

    @Autowired
    private ClinicaRepository repo;

    public Optional<Clinica> findById(Integer id) {
        return repo.findById(id);
    }

}
