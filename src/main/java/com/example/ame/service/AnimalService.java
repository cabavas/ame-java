package com.example.ame.service;
import com.example.ame.model.Animal;
import com.example.ame.model.Tutor;
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

    public Animal findById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public boolean exists(Integer id) {return repo.existsById(id);}

    public Animal save(Animal animal) {
        return repo.save(animal);
    }

    public Animal findByAnimalNameAndTutor(String name, Tutor tutor) {
        return repo.findByAnimalNameAndTutor(name, tutor);
    }

}
