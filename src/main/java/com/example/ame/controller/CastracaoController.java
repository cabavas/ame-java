package com.example.ame.controller;

import com.example.ame.model.Animal;
import com.example.ame.model.Castracao;
import com.example.ame.model.Clinica;
import com.example.ame.model.Tutor;
import com.example.ame.repository.ClinicaRepository;
import com.example.ame.service.AnimalService;
import com.example.ame.service.CastracaoService;
import com.example.ame.service.ProtocoloService;
import com.example.ame.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("castracoes")
public class CastracaoController {

    @Autowired
    private CastracaoService service;
    @Autowired
    private ClinicaRepository clinicaRepository;
    @Autowired
    private ProtocoloService protocoloService;
    @Autowired
    private TutorService tutorService;
    @Autowired
    private AnimalService animalService;

    @GetMapping
    public ResponseEntity<List<Castracao>> findAll(@RequestParam(value = "clinica", required = false, defaultValue = "0") Integer clinicaId) {
        List<Castracao> castracoes;

        if (clinicaId == 1) {
            castracoes = service.findByClinicaId(1);
        } else {
            castracoes = service.findByClinicaIdNot(1);
        }
        return ResponseEntity.ok(castracoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Castracao> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Castracao> save(@RequestBody Castracao castracao) {
        Tutor tutor = castracao.getAnimal().getTutor();
        Tutor existingTutor = tutorService.findByCpf(tutor.getCpf());
        if (existingTutor == null) {
            tutor = tutorService.save(tutor);
        } else {
            tutor = existingTutor;
        }

        Animal animal = castracao.getAnimal();
        animal.setTutor(tutor);
        Animal existingAnimal = animalService.findByAnimalNameAndTutor(animal.getAnimalName(), tutor);
        if (existingAnimal == null) {
            animal = animalService.save(animal);
        } else {
            animal = existingAnimal;
        }

        Clinica clinica = castracao.getClinica();
        if (clinica.getId() == null) {
            clinica = clinicaRepository.save(clinica);
        }

        castracao.setAnimal(animal);
        castracao.setClinica(clinica);

        if (castracao.getProtocol() == null || castracao.getProtocol().isEmpty()) {
            String protocol = protocoloService.generateProtocol();
            castracao.setProtocol(protocol);
            return ResponseEntity.ok(service.save(castracao));
        }
        Castracao existingCastracao = service.findByProtocol(castracao.getProtocol());
        if (existingCastracao != null) {
            existingCastracao.setAnimal(animal);
            existingCastracao.setSolicitCode(castracao.getSolicitCode());
            existingCastracao.setKindPatient(castracao.getKindPatient());
            existingCastracao.setClinica(clinica);
            existingCastracao.setConsultDate(castracao.getConsultDate());
            existingCastracao.setSurgeryDate(castracao.getSurgeryDate());
            existingCastracao.setSurgeryStatus(castracao.getSurgeryStatus());
            existingCastracao.setProtectorName(castracao.getProtectorName());
            return ResponseEntity.ok(service.save(existingCastracao));
        }
        return ResponseEntity.ok(service.save(castracao));
    }
}