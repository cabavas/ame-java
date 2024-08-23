package com.example.ame.controller;

import com.example.ame.model.Atendimento;
import com.example.ame.model.dto.AtendimentoDTO;
import com.example.ame.service.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/web")
public class GeneralController {

    @Autowired
    private AtendimentoService atendimentoService;
    @Autowired
    private CastracaoService castracaoService;
    @Autowired
    private EncaminhamentoService encaminhamentoService;
    @Autowired
    private ProcedimentosService procedimentosService;
    @Autowired
    private VeterinarioCanilService veterinarioCanilService;
    @Autowired
    private AtendimentoAmbulatorioService atendimentoAmbulatorioService;

    @PostMapping
    public ResponseEntity<?> handlePost(@RequestBody Map<String, Object> data) {
        String type = (String) data.get("type");

        data.remove("type");

        switch (type) {
            case "atendimento":
                ObjectMapper objectMapper = new ObjectMapper();
                AtendimentoDTO atendimentoDTO = objectMapper.convertValue(data, AtendimentoDTO.class);
                try {
                    return ResponseEntity.ok(atendimentoService.save(atendimentoDTO));
                } catch (Exception e) {
                    return ResponseEntity.badRequest().body("Erro ao salvar atendimento: " + e.getMessage());
                }
//            case "castracao":
//                return ResponseEntity.ok(castracaoService.create(data));
//            case "encaminhamento":
//                return ResponseEntity.ok(encaminhamentoService.create(data));
//            case "procedimentos":
//                return handleProcedimentos(data);
//            case "veterinario":
//                return ResponseEntity.ok(veterinarioService.create(data));
//            case "ambulatorio":
//                return ResponseEntity.ok(ambulatorioService.create(data));
            default:
                return ResponseEntity.badRequest().body("Tipo de pesquisa inválido.");
        }
    }
}
