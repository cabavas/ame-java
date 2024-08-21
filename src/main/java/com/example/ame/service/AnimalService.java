package com.example.ame.service;
import com.example.ame.model.Animal;
import com.example.ame.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository repo;

    public List<Animal> findAll() {
        return repo.findAll();
    }

    public Animal getAnimalById(Long id) {
        return repo.findById(id).orElse(null);
    }

}
