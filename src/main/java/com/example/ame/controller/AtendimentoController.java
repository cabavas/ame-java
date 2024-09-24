package com.example.ame.controller;

import com.example.ame.model.Animal;
import com.example.ame.model.Atendimento;
import com.example.ame.model.Tutor;
import com.example.ame.model.dto.AtendimentoDTO;
import com.example.ame.service.AnimalService;
import com.example.ame.service.AtendimentoService;
import com.example.ame.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atendimentos")
public class AtendimentoController {

    @Autowired
    private AtendimentoService service;

    @Autowired
    private AnimalService animalService;
    @Autowired
    private TutorService tutorService;
    @Autowired
    private AtendimentoService atendimentoService;

    @GetMapping
    public ResponseEntity<List<Atendimento>> findAll(@RequestParam(required = false) String cpf) {
        if (cpf != null) {
            return ResponseEntity.ok(service.findByTutorCpf(cpf));
        } else {
            return ResponseEntity.ok(service.findAll());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atendimento> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Atendimento> save(@RequestBody AtendimentoDTO atendimentoDTO) {
        Tutor tutor = atendimentoDTO.getAnimal().getTutor();
        if (tutor != null) {
            tutor = tutorService.findByCpf(tutor.getCpf());
            if (tutor.getIdTutor() == null || !tutorService.exists(tutor.getIdTutor())) {
                tutor = tutorService.save(tutor);
            } else {
                tutor = tutorService.findById(tutor.getIdTutor());
            }
            atendimentoDTO.getAnimal().setTutor(tutor);
        }

        Animal animal = atendimentoDTO.getAnimal();
        if (animal != null) {
            animal = animalService.findByAnimalNameAndTutor(animal.getAnimalName(), tutor);
            if (animal.getId() == null || !animalService.exists(animal.getId())) {
                animal = animalService.save(animal);
            } else {
                animal = animalService.findById(animal.getId());
            }
            atendimentoDTO.setAnimal(animal);
        }

        Atendimento atendimento;
        if (atendimentoDTO.getId() != null && service.findById(atendimentoDTO.getId()) != null) {
            atendimento = service.findById(atendimentoDTO.getId());
            setData(atendimentoDTO, atendimento);
        } else {
            atendimento = new Atendimento();
            setData(atendimentoDTO, atendimento);
        }
        try {
            Atendimento novoAtendimento = atendimentoService.save(atendimento);
            return ResponseEntity.ok(novoAtendimento);
        } catch (ChangeSetPersister.NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    private void setData(@RequestBody AtendimentoDTO atendimentoDTO, Atendimento atendimento) {
        atendimento.setConsultType(atendimentoDTO.getConsultType());
        atendimento.setConsultDate(atendimentoDTO.getConsultDate());
        atendimento.setInitialTime(atendimentoDTO.getInitialTime());
        atendimento.setKindPatient(atendimentoDTO.getKindPatient());
        atendimento.setSolicitCode(atendimentoDTO.getSolicitCode());
        atendimento.setAnimal(atendimentoDTO.getAnimal());
        atendimento.setEndTime(atendimentoDTO.getEndTime());
        atendimento.setProtocol(atendimentoDTO.getProtocol());
        atendimento.setVetId(atendimentoDTO.getVetId());
    }
}
