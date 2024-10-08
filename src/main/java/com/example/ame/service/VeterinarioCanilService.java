package com.example.ame.service;

import com.example.ame.model.VeterinarioCanil;
import com.example.ame.repository.VeterinarioCanilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeterinarioCanilService {

    @Autowired
    private VeterinarioCanilRepository repo;

    public List<VeterinarioCanil> findAll() {
        return repo.findAll();
    }

    public VeterinarioCanil findById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public VeterinarioCanil save(VeterinarioCanil veterinarioCanil) {
        return repo.save(veterinarioCanil);
    }

}
