package com.example.ame.controller;

import com.example.ame.model.Castracao;
import com.example.ame.model.dto.AtendimentoDTO;
import com.example.ame.service.EmailService;
import com.example.ame.service.PDFGeneratorService;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.time.LocalDate;

@Controller
public class PDFExportController {

    @Autowired
    private PDFGeneratorService pdfGeneratorService;
    @Autowired
    private EmailService emailService;

    @PostMapping("/pdf/generate/atendimento")
    public void generatePDFWithData(@RequestBody AtendimentoDTO atendimentoDTO, HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        String currentDate = String.valueOf(LocalDate.now());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=pdf_"  + currentDate + ".pdf";
        response.setHeader(headerKey, headerValue);

        this.pdfGeneratorService.exportAtendimento(atendimentoDTO, response);
    }

    @PostMapping("/pdf/generate/castracao")
    public void generatePDFWithData(@RequestBody Castracao castracao, HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        String currentDate = String.valueOf(LocalDate.now());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=pdf_" + currentDate + ".pdf";
        response.setHeader(headerKey, headerValue);

        this.pdfGeneratorService.exportCastracao(castracao, response);
    }

    @PostMapping("/pdf/send")
    public void generatePDFAndSendEmail(@RequestBody Castracao castracao, @RequestParam String to) throws IOException, MessagingException {
        byte[] pdfBytes = pdfGeneratorService.generatePDFBytes(castracao);
        System.out.println("========================" + to + "============================");
        emailService.sendEmailWithAttachment(
                to,
                "Confirmação de Castração",
                "Segue em anexo a ficha de castração.",
                pdfBytes,
                "ficha castração.pdf"
        );
    }


}
