package com.example.ame.controller;

import com.example.ame.model.Animal;
import com.example.ame.model.Castracao;
import com.example.ame.model.Clinica;
import com.example.ame.model.Tutor;
import com.example.ame.model.dto.CastracaoDTO;
import com.example.ame.repository.ClinicaRepository;
import com.example.ame.service.AnimalService;
import com.example.ame.service.CastracaoService;
import com.example.ame.service.ClinicaService;
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
    private TutorService tutorService;
    @Autowired
    private AnimalService animalService;
    @Autowired
    private ClinicaService clinicaService;

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
    public ResponseEntity<Castracao> save(@RequestBody CastracaoDTO castracaoDTO) {
        Tutor tutor = castracaoDTO.getAnimal().getTutor();
        if (tutor != null) {
            tutor = tutorService.findByCpf(tutor.getCpf());
            if (tutor.getIdTutor() == null || tutorService.exists(tutor.getIdTutor())) {
                tutor = tutorService.save(tutor);
            }
            castracaoDTO.getAnimal().setTutor(tutor);
        }

        Animal animal = castracaoDTO.getAnimal();
        if (animal != null) {
            animal = animalService.findByAnimalNameAndTutor(animal.getAnimalName(), tutor);
            if (animal.getId() == null || !animalService.exists(animal.getId())) {
                animal = animalService.save(animal);
            }
            castracaoDTO.setAnimal(animal);
        }

        Clinica clinica = clinicaService.findById(castracaoDTO.getClinica().getId());
        if (clinica != null) {
            if (clinica.getId() == null || !clinicaService.exists(clinica.getId())) {
                clinica = clinicaRepository.save(clinica);
            }
            castracaoDTO.setClinica(clinica);
        }

        Castracao castracao;
        if (castracaoDTO.getId() != null && service.findById(castracaoDTO.getId()) != null) {
            castracao = service.findById(castracaoDTO.getId());
            setCastracaoData(castracaoDTO, castracao);
        } else {
            castracao = new Castracao();
            setCastracaoData(castracaoDTO, castracao);
        }
        Castracao novaCastracao = service.save(castracao);
        return ResponseEntity.ok(novaCastracao);
    }

    private void setCastracaoData(@RequestBody CastracaoDTO castracaoDTO, Castracao castracao) {
        castracao.setAnimal(castracaoDTO.getAnimal());
        castracao.setSolicitCode(castracaoDTO.getSolicitCode().toString());
        castracao.setKindPatient(castracaoDTO.getKindPatient().toString());
        castracao.setClinica(clinicaService.findById(castracaoDTO.getClinica().getId()));
        castracao.setConsultDate(castracaoDTO.getConsultDate());
        castracao.setSurgeryDate(castracaoDTO.getSurgeryDate());
        castracao.setSurgeryStatus(castracaoDTO.getSurgeryStatus());
        castracao.setProtectorName(castracaoDTO.getProtectorName());
        castracao.setVetId(castracaoDTO.getVetId());
        castracao.setProtocol(castracaoDTO.getProtocol());
    }
}