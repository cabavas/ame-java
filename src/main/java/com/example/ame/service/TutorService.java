package com.example.ame.service;

import com.example.ame.model.Tutor;
import com.example.ame.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorService {

    @Autowired
    private TutorRepository repo;

    public List<Tutor> findAll() {
        return repo.findAll();
    }

    public Tutor getTutorById(Long id) {
        return repo.findById(id).orElse(null);
    }

}
