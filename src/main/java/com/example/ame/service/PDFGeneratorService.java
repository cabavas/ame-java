package com.example.ame.service;

import com.example.ame.model.Animal;
import com.example.ame.model.Castracao;
import com.example.ame.model.dto.AtendimentoDTO;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class PDFGeneratorService {
    public void export(HttpServletResponse response) throws IOException {
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

        String consulta = "Agendada";
        Paragraph paragraph2 = new Paragraph("TIPO DE CONSULTA: " + consulta, fontBody);
        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);
        paragraph2.setSpacingAfter(20);
        document.add(paragraph2);

        Paragraph paragraph3 = new Paragraph("1. DADOS DO ANIMAL", fontTopic);
        paragraph3.setAlignment(Paragraph.ALIGN_LEFT);
        paragraph3.setSpacingAfter(5);
        document.add(paragraph3);

        String nome = "Jonatha";
        String especie = "Canina";
        String raca = "Pug";
        Paragraph paragraph4 = new Paragraph(
                "NOME: " + nome + "           " +
                        "ESPÉCIE: " + especie + "           " +
                        "RAÇA: " + raca, fontBody);
        paragraph4.setAlignment(Paragraph.ALIGN_LEFT);
        paragraph4.setSpacingAfter(5);
        document.add(paragraph4);

        String idade = "2";
        String cor = "Preto";
        String peso = "3";
        String porte = "Pequeno";
        Paragraph paragraph5 = new Paragraph(
                "IDADE: " + idade + "           " +
                        "COR: " + cor + "           " +
                        "PESO: " + peso + "KG" + "           " +
                        "PORTE: " + porte, fontBody
        );
        paragraph5.setAlignment(Paragraph.ALIGN_LEFT);
        paragraph5.setSpacingAfter(5);
        document.add(paragraph5);

        Paragraph paragraph6 = new Paragraph("2. DADOS DO PROPRIETÁRIO", fontTopic);
        paragraph6.setAlignment(Paragraph.ALIGN_LEFT);
        paragraph6.setSpacingAfter(10);
        paragraph6.setSpacingBefore(10);
        document.add(paragraph6);

        String nomeTutor = "Caio Bastos Vasconcelos da Silva Sauro";
        String endereco = "Rua Magistrado Raul de Souza Girão";
        String numero = "347";
        Paragraph paragraph7 = new Paragraph(
                "NOME: " + nomeTutor + "           " +
                        "ENDEREÇO: " + endereco + "           " +
                        "N°: " + numero, fontBody
        );
        paragraph7.setAlignment(Paragraph.ALIGN_LEFT);
        paragraph7.setSpacingAfter(5);
        document.add(paragraph7);

        String complemento = "";
        String bairro = "Cidade dos funcionários";
        String cidade = "Caruaru";
        String telefone = "(81)99999-9999";

        Paragraph paragraph8 = new Paragraph(
                "COMPLEMENTO: " + "           " +
                        "BAIRRO: " + bairro + "           " +
                        "CIDADE: " + cidade + "           " +
                        "TELEFONE: " + telefone, fontBody
        );
        paragraph8.setAlignment(Paragraph.ALIGN_LEFT);
        paragraph8.setSpacingAfter(5);
        document.add(paragraph8);

        String whatsapp = "";
        String rg = "99999999";
        String cpf = "111.111.111-11";
        Paragraph paragraph9 = new Paragraph(
                "RG: " + rg + "           " +
                        "CPF: " + cpf, fontBody
        );
        paragraph9.setAlignment(Paragraph.ALIGN_LEFT);
        paragraph9.setSpacingAfter(5);
        document.add(paragraph9);

        Paragraph paragraph10 = new Paragraph("3. TRIAGEM / HISTÓRICO", fontTopic);
        paragraph10.setAlignment(Paragraph.ALIGN_LEFT);
        paragraph10.setSpacingAfter(10);
        paragraph10.setSpacingBefore(10);
        document.add(paragraph10);

        String historico = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur eu massa varius, tempor tellus in, blandit diam. Sed feugiat tempor ornare. Nam ut ex dignissim, imperdiet turpis non, malesuada orci. Nullam luctus tortor at eleifend iaculis. Sed quis ex id nisi condimentum volutpat id eu eros. Etiam tincidunt facilisis risus eu pulvinar. Sed viverra nulla nisl, id feugiat metus elementum sit amet. Vivamus viverra lorem ac justo vulputate, a consequat diam vehicula. Cras vulputate purus odio, auctor imperdiet diam iaculis sit amet. ";
        Paragraph paragraph11 = new Paragraph(
                historico, fontBody
        );
        paragraph11.setAlignment(Paragraph.ALIGN_LEFT);
        paragraph11.setSpacingAfter(5);
        document.add(paragraph11);

        Paragraph paragraph12 = new Paragraph("4. ANAMNESE", fontTopic);
        paragraph12.setAlignment(Paragraph.ALIGN_LEFT);
        paragraph12.setSpacingAfter(10);
        paragraph12.setSpacingBefore(10);
        document.add(paragraph12);

        String anamnese = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur eu massa varius, tempor tellus in, blandit diam. Sed feugiat tempor ornare. Nam ut ex dignissim, imperdiet turpis non, malesuada orci. Nullam luctus tortor at eleifend iaculis. Sed quis ex id nisi condimentum volutpat id eu eros. Etiam tincidunt facilisis risus eu pulvinar. Sed viverra nulla nisl, id feugiat metus elementum sit amet. Vivamus viverra lorem ac justo vulputate, a consequat diam vehicula. Cras vulputate purus odio, auctor imperdiet diam iaculis sit amet. ";
        Paragraph paragraph13 = new Paragraph(anamnese, fontBody);
        paragraph13.setAlignment(Paragraph.ALIGN_LEFT);
        paragraph13.setSpacingAfter(5);
        document.add(paragraph13);

        Paragraph paragraph14 = new Paragraph("5. TRATAMENTO / PRESCRIÇÕES", fontTopic);
        paragraph14.setAlignment(Paragraph.ALIGN_LEFT);
        paragraph14.setSpacingAfter(10);
        paragraph14.setSpacingBefore(10);
        document.add(paragraph14);

        String tratamento = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur eu massa varius, tempor tellus in, blandit diam. Sed feugiat tempor ornare. Nam ut ex dignissim, imperdiet turpis non, malesuada orci. Nullam luctus tortor at eleifend iaculis. Sed quis ex id nisi condimentum volutpat id eu eros. Etiam tincidunt facilisis risus eu pulvinar. Sed viverra nulla nisl, id feugiat metus elementum sit amet. Vivamus viverra lorem ac justo vulputate, a consequat diam vehicula. Cras vulputate purus odio, auctor imperdiet diam iaculis sit amet. ";
        Paragraph paragraph15 = new Paragraph(tratamento, fontBody);
        paragraph15.setAlignment(Paragraph.ALIGN_LEFT);
        paragraph15.setSpacingAfter(5);
        document.add(paragraph15);

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
        document.add((new Paragraph(atendimentoDTO.getAnimal().getHistory())));

        document.add(new Paragraph("4. ANAMNESE", fontTopic));
        document.add((new Paragraph(atendimentoDTO.getAnimal().getAnamnesis())));

        document.add(new Paragraph("5. TRATAMENTO / PRESCRIÇÕES", fontTopic));
        document.add((new Paragraph(atendimentoDTO.getAnimal().getTreatment())));

        document.close();
    }

    private void addAtendimentoDetail(Document document, AtendimentoDTO atendimentoDTO, Font fontBody, Font fontTopic) throws DocumentException {
        // Adicione detalhes do atendimento ao documento
        Paragraph paragraph = new Paragraph("TIPO DE CONSULTA: " + atendimentoDTO.getConsultType(), fontBody);
        paragraph.setAlignment(Paragraph.ALIGN_LEFT);
        paragraph.setSpacingAfter(20);
        document.add(paragraph);

        addDetails(document, atendimentoDTO.getAnimal(), fontBody, fontTopic);
    }

    private void addDetails(Document document, Animal animal, Font fontBody, Font fontTopic) throws DocumentException {
        // Dados do animal
        document.add(new Paragraph("1. DADOS DO ANIMAL", fontTopic));
        document.add(new Paragraph(
                "NOME: " + animal.getAnimalName() + "           " +
                        "ESPÉCIE: " + animal.getSpecies() + "           " +
                        "RAÇA: " + animal.getBreed(), fontBody
        ));
        document.add(new Paragraph(
                "IDADE: " + animal.getAge() + "           " +
                        "COR: " + animal.getFur() + "           " +
                        "PESO: " + (animal.getWeight() == null ? "Não pesado" : animal.getWeight()  + " KG") + "           " +
                        "PORTE: " + animal.getSize(), fontBody
        ));

        // Dados do proprietário
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

        addDetails(document, castracao.getAnimal(), fontBody, fontTopic);

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

        addDetails(document, castracao.getAnimal(), fontBody, fontTopic);

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
