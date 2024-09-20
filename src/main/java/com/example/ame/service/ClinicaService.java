package com.example.ame.service;
import com.example.ame.model.Clinica;
import com.example.ame.repository.ClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClinicaService {

    @Autowired
    private ClinicaRepository repo;

    public Clinica findById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public boolean exists(Integer id) {return repo.existsById(id);}

}
