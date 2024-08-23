package com.example.ame.service;

import com.example.ame.model.Animal;
import com.example.ame.model.Atendimento;
import com.example.ame.model.dto.AtendimentoDTO;
import com.example.ame.repository.AnimalRepository;
import com.example.ame.repository.AtendimentoRepository;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
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

    public Atendimento findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Atendimento save(AtendimentoDTO atendimentoDTO) throws ChangeSetPersister.NotFoundException {
        Animal animal = animalRepo.findById(atendimentoDTO.getAnimalId()).
                orElseThrow(ChangeSetPersister.NotFoundException::new);
        Atendimento atendimento = new Atendimento();
        atendimento.setConsultType(atendimentoDTO.getConsultType());
        atendimento.setConsultDate(atendimentoDTO.getConsultDate());
        atendimento.setInitialTime(atendimentoDTO.getInitialTime());
        atendimento.setKindPatient(atendimentoDTO.getKindPatient());
        atendimento.setSolicitCode(atendimentoDTO.getSolicitCode());
        atendimento.setAnimalId(animal);
        atendimento.setEndTime(atendimentoDTO.getEndTime());
        atendimento.setProtocol(atendimentoDTO.getProtocol());
        atendimento.setVetId(atendimentoDTO.getVetId());

        return repo.save(atendimento);
    }

}
