package com.example.ame.controller;

import com.example.ame.model.Animal;
import com.example.ame.model.Procedimento;
import com.example.ame.model.Tutor;
import com.example.ame.service.AnimalService;
import com.example.ame.service.ProcedimentosService;
import com.example.ame.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("procedimentos")
public class ProcedimentoController {

    @Autowired
    private ProcedimentosService service;
    @Autowired
    private AnimalService animalService;
    @Autowired
    private TutorService tutorService;

    @GetMapping
    public ResponseEntity<List<Procedimento>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Procedimento> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Procedimento> save(@RequestBody Procedimento procedimentoData) {
        Tutor tutor = procedimentoData.getAnimal().getTutor();
        if(tutor != null) {
            if(tutor.getIdTutor() == null || !tutorService.exists(tutor.getIdTutor())) {
                tutor = tutorService.save(tutor);
            } else {
                tutor = tutorService.findById(tutor.getIdTutor());
            }
            procedimentoData.getAnimal().setTutor(tutor);
        }

        Animal animal = procedimentoData.getAnimal();
        if (animal != null) {
            if (animal.getId() == null || !animalService.exists(animal.getId())) {
                animal = animalService.save(animal);
            } else {
                animal = animalService.findById(animal.getId());
            }
            procedimentoData.setAnimal(animal);
        }

        Procedimento procedimento;
        if (procedimentoData.getId() != null && service.findById(procedimentoData.getId()) != null) {
            procedimento = service.findById(procedimentoData.getId());
            setData(procedimentoData, procedimento);
        } else {
            procedimento = new Procedimento();
            setData(procedimentoData, procedimento);
        }
        Procedimento novoProcedimento = service.save(procedimento);
        return ResponseEntity.ok(novoProcedimento);
    }

    private void setData(@RequestBody Procedimento procedimentoData, Procedimento procedimento) {
        procedimento.setAppointmentDate(procedimentoData.getAppointmentDate());
        procedimento.setAppointmentStatus(procedimentoData.getAppointmentStatus());
        procedimento.setConsultDate(procedimentoData.getConsultDate());
        procedimento.setKindPatient(procedimentoData.getKindPatient());
        procedimento.setObservations(procedimentoData.getObservations());
        procedimento.setProcedure1(procedimentoData.getProcedure1());
        procedimento.setProcedure2(procedimentoData.getProcedure2());
        procedimento.setProtectorName(procedimentoData.getProtectorName());
        procedimento.setSolicitCode(procedimentoData.getSolicitCode());
    }
}
