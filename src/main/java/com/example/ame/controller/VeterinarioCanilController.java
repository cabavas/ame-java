package com.example.ame.controller;

import com.example.ame.model.Tutor;
import com.example.ame.model.VeterinarioCanil;
import com.example.ame.service.TutorService;
import com.example.ame.service.VeterinarioCanilService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/veterinario-canil")
public class VeterinarioCanilController {

    @Autowired
    private VeterinarioCanilService service;

    @GetMapping
    public ResponseEntity<List<VeterinarioCanil>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeterinarioCanil> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<VeterinarioCanil> save(
            @RequestParam(value = "file", required = false) MultipartFile file,
            @RequestParam("data") String veterinarioCanilJson) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            VeterinarioCanil veterinarioCanil = objectMapper.readValue(veterinarioCanilJson, VeterinarioCanil.class);

            String uploadDir = Paths.get("src/main/resources/pictures").toAbsolutePath().toString();
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            if (file != null && !file.isEmpty()) {
                String filePath = Paths.get(uploadDir, file.getOriginalFilename()).toString();
                file.transferTo(new File(filePath));
                veterinarioCanil.setLink(filePath);
            } else {
                veterinarioCanil.setLink(null);
            }

            VeterinarioCanil savedVeterinarioCanil = service.save(veterinarioCanil);
            return ResponseEntity.ok(savedVeterinarioCanil);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

}
