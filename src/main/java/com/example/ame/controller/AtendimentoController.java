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
    public ResponseEntity<List<Atendimento>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atendimento> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Atendimento> save(@RequestBody AtendimentoDTO atendimentoDTO) {
        // Verificar e criar tutor se necessário
        Tutor tutor = atendimentoDTO.getAnimal().getTutor();
        if (tutor != null) {
            if (tutor.getIdTutor() == null || !tutorService.exists(tutor.getIdTutor())) {
                tutor = tutorService.save(tutor);
            }
            atendimentoDTO.getAnimal().setTutor(tutor);
        }

        // Verificar e criar animal se necessário
        Animal animal = atendimentoDTO.getAnimal();
        if (animal != null) {
            if (animal.getId() == null || !animalService.exists(animal.getId())) {
                animal = animalService.save(animal);
            }
            atendimentoDTO.setAnimal(animal);
        }

        // Converter AtendimentoDTO para Atendimento
        Atendimento atendimento = new Atendimento();
        atendimento.setConsultType(atendimentoDTO.getConsultType());
        atendimento.setConsultDate(atendimentoDTO.getConsultDate());
        atendimento.setInitialTime(atendimentoDTO.getInitialTime());
        atendimento.setKindPatient(atendimentoDTO.getKindPatient());
        atendimento.setSolicitCode(atendimentoDTO.getSolicitCode());
        atendimento.setAnimal(atendimentoDTO.getAnimal());
        atendimento.setEndTime(atendimentoDTO.getEndTime());
        atendimento.setProtocol(atendimentoDTO.getProtocol());
        atendimento.setVetId(atendimentoDTO.getVetId());

        try {
            Atendimento novoAtendimento = atendimentoService.save(atendimento);
            return ResponseEntity.ok(novoAtendimento);
        } catch (ChangeSetPersister.NotFoundException e) {
            return ResponseEntity.status(404).body(null);
        }
    }
}
