package com.example.ame.controller;

import com.example.ame.model.Animal;
import com.example.ame.model.Encaminhamento;
import com.example.ame.model.Tutor;
import com.example.ame.service.AnimalService;
import com.example.ame.service.EncaminhamentoService;
import com.example.ame.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("encaminhamentos")
public class EncaminhamentoController {

    @Autowired
    private EncaminhamentoService encaminhamentoService;
    @Autowired
    private TutorService tutorService;
    @Autowired
    private AnimalService animalService;

    @GetMapping
    public ResponseEntity<List<Encaminhamento>> findAll() {
        return ResponseEntity.ok(encaminhamentoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Encaminhamento> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(encaminhamentoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Encaminhamento> save(@RequestBody Encaminhamento encaminhamento) {

        Tutor tutor = encaminhamento.getAnimal().getTutor();
        if (tutor != null) {
            if (tutor.getIdTutor() == null || !tutorService.exists(tutor.getIdTutor())) {
                tutor = tutorService.save(tutor);
            }
            encaminhamento.getAnimal().setTutor(tutor);
        }

        Animal animal = encaminhamento.getAnimal();
        if (animal != null) {
            if (animal.getId() == null || !animalService.exists(animal.getId())) {
                animal = animalService.save(animal);
            }
            encaminhamento.setAnimal(animal);
        }

        Encaminhamento encaminhamentoNovo;
        if (encaminhamento.getId() != null && encaminhamentoService.findById(encaminhamento.getId()) != null) {
            encaminhamentoNovo = encaminhamentoService.findById(encaminhamento.getId());
            setEncaminhamentoData(encaminhamento, encaminhamentoNovo);
        } else {
            encaminhamentoNovo = new Encaminhamento();
            setEncaminhamentoData(encaminhamento, encaminhamentoNovo);
        }
        try {
            encaminhamentoNovo = encaminhamentoService.save(encaminhamento);
            return ResponseEntity.ok(encaminhamentoNovo);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(null);
        }
    }

    private void setEncaminhamentoData(@RequestBody Encaminhamento encaminhamento, Encaminhamento encaminhamentoNovo) {
        encaminhamentoNovo.setAnimal(encaminhamento.getAnimal());
        encaminhamentoNovo.setClinic(encaminhamento.getClinic());
        encaminhamentoNovo.setConsultDate(encaminhamento.getConsultDate());
        encaminhamentoNovo.setKindPatient(encaminhamento.getKindPatient());
        encaminhamentoNovo.setProtectorName(encaminhamento.getProtectorName());
        encaminhamentoNovo.setSolicitCode(encaminhamento.getSolicitCode());
        encaminhamentoNovo.setExam1(encaminhamento.getExam1());
        encaminhamentoNovo.setExam2(encaminhamento.getExam2());
        encaminhamentoNovo.setExam3(encaminhamento.getExam3());
    }
}
