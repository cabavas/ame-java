package com.example.ame.repository;

import com.example.ame.model.Animal;
import com.example.ame.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    public Animal findByAnimalNameAndTutor(String animalName, Tutor tutor);
}
