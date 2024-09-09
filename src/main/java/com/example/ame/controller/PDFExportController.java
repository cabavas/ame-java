package com.example.ame.controller;

import com.example.ame.model.dto.AtendimentoDTO;
import com.example.ame.service.PDFGeneratorService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.time.LocalDate;

@Controller
public class PDFExportController {

    @Autowired
    private PDFGeneratorService pdfGeneratorService;

    @PostMapping("/pdf/generate/atendimento")
    public void generatePDFWithData(@RequestBody AtendimentoDTO atendimentoDTO, HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        String currentDate = String.valueOf(LocalDate.now());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=pdf_"  + currentDate + ".pdf";
        response.setHeader(headerKey, headerValue);

        this.pdfGeneratorService.exportAtendimento(atendimentoDTO, response);
    }

}
