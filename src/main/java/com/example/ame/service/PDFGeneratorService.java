package com.example.ame.service;

import com.example.ame.model.Animal;
import com.example.ame.model.Castracao;
import com.example.ame.model.Clinica;
import com.example.ame.model.Encaminhamento;
import com.example.ame.model.dto.AtendimentoDTO;
import com.example.ame.model.dto.ComparecimentoDTO;
import com.example.ame.model.dto.ProcedimentoDTO;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class PDFGeneratorService {

    @Autowired
    private ClinicaService clinicaService;
    @Autowired
    private TipoProcedimentoService tipoProcedimentoService;

    public void exportProcedimento(ProcedimentoDTO dto, HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();

        Paragraph spacingAfter = new Paragraph();
        spacingAfter.setSpacingAfter(20);

        Font fontTitle = FontFactory.getFont(FontFactory.TIMES_BOLD);
        fontTitle.setSize(24);

        Font fontBody = FontFactory.getFont(FontFactory.TIMES);
        fontBody.setSize(14);

        Font fontTopic = FontFactory.getFont(FontFactory.TIMES_BOLD);
        fontTopic.setSize(14);

        Image header = Image.getInstanceFromClasspath("header.png");
        header.setAlignment(Image.ALIGN_MIDDLE);
        header.scaleAbsoluteWidth(640);
        document.add(header);

        Paragraph paragraph = new Paragraph("FICHA DE PROCEDIMENTOS DIVERSOS", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);
        paragraph.setSpacingBefore(30);
        paragraph.setSpacingAfter(40);
        document.add(paragraph);

        addAnimalDetails(document, dto.getAnimal(), fontBody, fontTopic);

        document.add(spacingAfter);
        document.add(new Paragraph("3. PROCEDIMENTOS", fontTopic));
        if (dto.getProcedure1() != null && dto.getProcedure1() > 0) {
            String procedure1Name = tipoProcedimentoService.findNomeById(dto.getProcedure1());
            document.add(new Paragraph("PROCEDIMENTO 1: " + procedure1Name));
        }
        if (dto.getProcedure2() != null && dto.getProcedure2() > 0) {
            String procedure2Name = tipoProcedimentoService.findNomeById(dto.getProcedure2());
            document.add(new Paragraph("PROCEDIMENTO 2: " + procedure2Name));
        }

        document.add(spacingAfter);

        document.add(new Paragraph("4. OBSERVAÇÕES", fontTopic));
        document.add(new Paragraph(dto.getObservations()));
        document.add(spacingAfter);
        document.add(new Paragraph("DATA DO AGENDAMENTO: " + dto.getAppointmentDate()));
        document.add(new Paragraph("STATUS DO ATENDIMENTO: " + dto.getAppointmentStatus()));

        document.close();
    }

    public void exportComparecimento(ComparecimentoDTO dto, HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.TIMES_BOLD);
        fontTitle.setSize(24);

        Font fontBody = FontFactory.getFont(FontFactory.TIMES);
        fontBody.setSize(14);

        Font fontTopic = FontFactory.getFont(FontFactory.TIMES_BOLD);
        fontTopic.setSize(14);

        Image header = Image.getInstanceFromClasspath("header.png");
        header.setAlignment(Image.ALIGN_MIDDLE);
        header.scaleAbsoluteWidth(640);
        document.add(header);

        Paragraph paragraph = new Paragraph("DECLARAÇÃO DE COMPARECIMENTO", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);
        paragraph.setSpacingBefore(30);
        paragraph.setSpacingAfter(40);
        document.add(paragraph);

        document.add(new Paragraph(
                "Declaramos para os devidos fins trabalhistas, que o(a) Sr(a): " + dto.getProtectorName() +
                        " compareceu a AME Animal - PREFEITURA DE CARUARU neste dia, no horário das " + dto.getBeginTime() +
                        "hs às " + dto.getEndTime() + "hs, ficando impossibilitado de comparecer para as suas atividades."
        ));

        Paragraph date = new Paragraph("Caruaru, ______ de _______________ de ______");
        date.setAlignment(Paragraph.ALIGN_CENTER);
        date.setSpacingBefore(30);
        date.setSpacingAfter(30);
        document.add(date);

        Paragraph signature = new Paragraph("___________________________________________________");
        signature.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(signature);

        Paragraph paragraph2 = new Paragraph("Médico Veterinário Responsável pelo Atendimento");
        paragraph2.setAlignment(Paragraph.ALIGN_CENTER);
        paragraph2.setSpacingAfter(20);
        document.add(paragraph2);

        document.close();
    }

    public void exportEncaminhamento(Encaminhamento encaminhamento, HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.TIMES_BOLD);
        fontTitle.setSize(24);

        Font fontBody = FontFactory.getFont(FontFactory.TIMES);
        fontBody.setSize(14);

        Font fontTopic = FontFactory.getFont(FontFactory.TIMES_BOLD);
        fontTopic.setSize(14);

        Image header = Image.getInstanceFromClasspath("header.png");
        header.setAlignment(Image.ALIGN_MIDDLE);
        header.scaleAbsoluteWidth(640);
        document.add(header);

        Paragraph paragraph = new Paragraph("FICHA DE ENCAMINHAMENTO", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);
        paragraph.setSpacingAfter(20);
        document.add(paragraph);

        addAnimalDetails(document, encaminhamento.getAnimal(), fontBody, fontTopic);

        document.add(new Paragraph("3. EXAMES", fontTopic));
        if (encaminhamento.getExam1() != null && !encaminhamento.getExam1().isEmpty()) {
            document.add((new Paragraph("Exame 1: " + encaminhamento.getExam1(), fontBody)));
        }
        if (encaminhamento.getExam2() != null && !encaminhamento.getExam2().isEmpty()) {
            document.add((new Paragraph("Exame 2: " + encaminhamento.getExam2(), fontBody)));
        }
        if (encaminhamento.getExam3() != null && !encaminhamento.getExam3().isEmpty()) {
            document.add((new Paragraph("Exame 3: " + encaminhamento.getExam3(), fontBody)));
        }

        Clinica clinica = clinicaService.findById(encaminhamento.getClinic().getId());
        encaminhamento.setClinic(clinica);
        document.add(new Paragraph("4. DADOS DA CLÍNICA", fontTopic));
        document.add(new Paragraph(
                "NOME DA CLÍNICA: " + encaminhamento.getClinic().getName() + "           " +
                        "ENDEREÇO: " + encaminhamento.getClinic().getAddress() + "           " +
                        "DATA DO AGENDAMENTO: " + encaminhamento.getAppointmentDate() + "           " +
                        "STATUS DO AGENDAMENTO: " + encaminhamento.getAppointmentStatus(), fontBody
        ));

        document.close();

    }

    public void exportAtendimento(AtendimentoDTO atendimentoDTO, HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.TIMES_BOLD);
        fontTitle.setSize(24);

        Font fontBody = FontFactory.getFont(FontFactory.TIMES);
        fontBody.setSize(14);

        Font fontTopic = FontFactory.getFont(FontFactory.TIMES_BOLD);
        fontTopic.setSize(14);

        Image header = Image.getInstanceFromClasspath("header.png");
        header.setAlignment(Image.ALIGN_MIDDLE);
        header.scaleAbsoluteWidth(640);
        document.add(header);

        Paragraph paragraph = new Paragraph("FICHA DE ATENDIMENTO", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);
        paragraph.setSpacingAfter(20);
        document.add(paragraph);

        addAtendimentoDetail(document, atendimentoDTO, fontBody, fontTopic);

        document.add(new Paragraph("3. TRIAGEM / HISTÓRICO", fontTopic));
        if (atendimentoDTO.getAnimal().getHistory() != null && !atendimentoDTO.getAnimal().getHistory().isEmpty()) {
            document.add((new Paragraph(atendimentoDTO.getAnimal().getHistory())));
        } else {
            document.add(new Paragraph("__________________________________________________________________________________________________________________________________________________________________________________________________________________________________________"));
        }

        document.add(new Paragraph("4. ANAMNESE", fontTopic));
        if (atendimentoDTO.getAnimal().getAnamnesis() != null && !atendimentoDTO.getAnimal().getAnamnesis().isEmpty()) {
            document.add((new Paragraph(atendimentoDTO.getAnimal().getAnamnesis())));
        } else {
            document.add(new Paragraph("__________________________________________________________________________________________________________________________________________________________________________________________________________________________________________"));
        }

        document.add(new Paragraph("5. TRATAMENTO / PRESCRIÇÕES", fontTopic));
        if (atendimentoDTO.getAnimal().getTreatment() != null && !atendimentoDTO.getAnimal().getTreatment().isEmpty()) {
            document.add((new Paragraph(atendimentoDTO.getAnimal().getTreatment())));
        } else {
            document.add(new Paragraph("__________________________________________________________________________________________________________________________________________________________________________________________________________________________________________"));
        }

        document.close();
    }

    private void addAtendimentoDetail(Document document, AtendimentoDTO atendimentoDTO, Font fontBody, Font fontTopic) throws DocumentException {
        // Adicione detalhes do atendimento ao documento
        Paragraph paragraph = new Paragraph("TIPO DE CONSULTA: " + atendimentoDTO.getConsultType(), fontBody);
        paragraph.setAlignment(Paragraph.ALIGN_LEFT);
        paragraph.setSpacingAfter(20);
        document.add(paragraph);

        addAnimalDetails(document, atendimentoDTO.getAnimal(), fontBody, fontTopic);
    }

    private void addAnimalDetails(Document document, Animal animal, Font fontBody, Font fontTopic) throws DocumentException {
        Paragraph spacing = new Paragraph();
        spacing.setSpacingAfter(20);

        document.add(new Paragraph("1. DADOS DO ANIMAL", fontTopic));
        document.add(new Paragraph(
                "NOME: " + animal.getAnimalName() + "           " +
                        "ESPÉCIE: " + animal.getSpecies() + "           " +
                        "RAÇA: " + animal.getBreed(), fontBody
        ));

        document.add(new Paragraph(
                "IDADE: " + animal.getAge() + "           " +
                        "COR: " + animal.getFur() + "           " +
                        "PESO: " + (animal.getWeight() == null ? "Não pesado" : animal.getWeight() + " KG") + "           " +
                        "PORTE: " + animal.getSize(), fontBody
        ));

        document.add(spacing);

        document.add(new Paragraph("2. DADOS DO PROPRIETÁRIO", fontTopic));
        document.add(new Paragraph(
                "NOME: " + animal.getTutor().getName() + "           " +
                        "ENDEREÇO: " + animal.getTutor().getAddress() + "           " +
                        "N°: " + animal.getTutor().getNumber(), fontBody
        ));
        document.add(new Paragraph(
                "COMPLEMENTO: " + animal.getTutor().getComplement() + "           " +
                        "BAIRRO: " + animal.getTutor().getNeighborhood() + "           " +
                        "CIDADE: " + animal.getTutor().getCity() + "           " +
                        "TELEFONE: " + animal.getTutor().getPhone(), fontBody
        ));
        document.add(new Paragraph(
                "WHATSAPP: " + animal.getTutor().getPhone() + "           " +
                        "RG: " + animal.getTutor().getRg() + "           " +
                        "CPF: " + animal.getTutor().getCpf(), fontBody
        ));
    }

    public void exportCastracao(Castracao castracao, HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.TIMES_BOLD);
        fontTitle.setSize(24);

        Font fontBody = FontFactory.getFont(FontFactory.TIMES);
        fontBody.setSize(14);

        Font fontTopic = FontFactory.getFont(FontFactory.TIMES_BOLD);
        fontTopic.setSize(14);

        Image header = Image.getInstanceFromClasspath("header.png");
        header.setAlignment(Image.ALIGN_MIDDLE);
        header.scaleAbsoluteWidth(640);
        document.add(header);

        Paragraph paragraph = new Paragraph("FICHA DE CASTRAÇÃO", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);
        paragraph.setSpacingAfter(20);
        document.add(paragraph);

        addAnimalDetails(document, castracao.getAnimal(), fontBody, fontTopic);

        // Dados do proprietário
        document.add(new Paragraph("3. DADOS DA CLÍNICA", fontTopic));
        document.add(new Paragraph(
                "NOME DA CLÍNICA: " + castracao.getClinica().getName() + "           " +
                        "ENDEREÇO: " + castracao.getClinica().getAddress() + "           " +
                        "DATA DA CIRURGIA: " + castracao.getSurgeryDate() + "           " +
                        "STATUS DA CIRURGIA: " + castracao.getSurgeryStatus(), fontBody
        ));

        document.close();
    }

    public byte[] generatePDFBytes(Castracao castracao) throws IOException {
        Document document = new Document(PageSize.A4);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, outputStream);

        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.TIMES_BOLD);
        fontTitle.setSize(24);

        Font fontBody = FontFactory.getFont(FontFactory.TIMES);
        fontBody.setSize(14);

        Font fontTopic = FontFactory.getFont(FontFactory.TIMES_BOLD);
        fontTopic.setSize(14);

        Image header = Image.getInstanceFromClasspath("header.png");
        header.setAlignment(Image.ALIGN_MIDDLE);
        header.scaleAbsoluteWidth(640);
        document.add(header);

        Paragraph paragraph = new Paragraph("FICHA DE CASTRAÇÃO", fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);
        paragraph.setSpacingAfter(20);
        document.add(paragraph);

        addAnimalDetails(document, castracao.getAnimal(), fontBody, fontTopic);

        // Dados do proprietário
        document.add(new Paragraph("3. DADOS DA CLÍNICA", fontTopic));
        document.add(new Paragraph(
                "NOME DA CLÍNICA: " + castracao.getClinica().getName() + "           " +
                        "ENDEREÇO: " + castracao.getClinica().getAddress() + "           " +
                        "DATA DA CIRURGIA: " + castracao.getSurgeryDate() + "           " +
                        "STATUS DA CIRURGIA: " + castracao.getSurgeryStatus(), fontBody
        ));

        document.close();

        return outputStream.toByteArray();
    }
}
