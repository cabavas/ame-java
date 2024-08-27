package com.example.ame.service;

import com.example.ame.model.Animal;
import com.example.ame.model.Atendimento;
import com.example.ame.repository.AnimalRepository;
import com.example.ame.repository.AtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtendimentoService {

    @Autowired
    private AtendimentoRepository repo;

    @Autowired
    private AnimalRepository animalRepo;

    public List<Atendimento> findAll() {
        return repo.findAll();
    }

    public Atendimento findById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public Atendimento save(Atendimento atendimento) throws ChangeSetPersister.NotFoundException {
        Animal animal = animalRepo.findById(atendimento.getAnimal().getId())
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
        atendimento.setAnimal(animal);

        return repo.save(atendimento);
    }

}
