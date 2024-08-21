package com.example.ame.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "tb_veterinario_canil")
public class VeterinarioCanil implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_veterinario_canil")
    private Long id;

    @Column(name = "protocolo")
    private String protocol;

    @Column(name = "ordem")
    private String order;

    @Column(name = "data_ordem")
    private LocalDate orderDate;

    @Column(name = "nome_denunciante")
    private String complainantName;

    @Column(name = "endereco_denuncia")
    private String complaintAddress;

    @Column(name = "nome_animal")
    private String animalName;

    @Column(name = "especie")
    private String species;

    @Column(name = "idade")
    private Integer age;

    @Column(name = "raca")
    private String breed;

    @Column(name = "peso")
    private String weight;

    @Column(name = "nome_proprietario")
    private String ownerName;

    @Column(name = "endereco")
    private String address;

    @Column(name = "numero")
    private String number;

    @Column(name = "complemento")
    private String complement;

    @Column(name = "bairro")
    private String neighborhood;

    @Column(name = "cidade")
    private String city;

    @Column(name = "telefone")
    private String phone;

    @Column(name = "whatsapp")
    private String whatsapp;

    @Column(name = "rg")
    private String rg;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "data_atendimento")
    private LocalDate consultDate;

    @Column(name = "id_veterinario")
    private Integer vetId;

    @Column(name = "cor_coleira")
    private String collarColor;

    @Column(name = "numero_coleira")
    private String collarNumber;

    @Column(name = "historico_animal")
    private String animalHistory;

    @Column(name = "castrado")
    private String castrated;

    @Column(name = "data_castracao")
    private String castrationDate;

    @Column(name = "vermifugado")
    private String vermifuged;

    @Column(name = "data_vermifugacao")
    private String vermifugationDate;

    @Column(name = "vacinado")
    private String vaccinated;

    @Column(name = "data_vacinacao")
    private String vaccinationDate;

    @Column(name = "1_evolucao_coleira")
    private String firstCollarEvolution;

    @Column(name = "data_1_evolucao_coleira")
    private String firstCollarEvolutionDate;

    @Column(name = "2_evolucao_coleira")
    private String secondCollarEvolution;

    @Column(name = "data_2_evolucao_coleira")
    private String secondCollarEvolutionDate;

    @Column(name = "3_evolucao_coleira")
    private String thirdCollarEvolution;

    @Column(name = "data_3_evolucao_coleira")
    private String thirdCollarEvolutionDate;

    @Column(name = "quimioterapia")
    private String chemo;

    @Column(name = "qtd_quimioterapia")
    private String amountChemos;

    @Column(name = "1_quimio")
    private String firstChemo;

    @Column(name = "2_quimio")
    private String secondChemo;

    @Column(name = "3_quimio")
    private String thirdChemo;

    @Column(name = "4_quimio")
    private String fourthChemo;

    @Column(name = "5_quimio")
    private String fifthChemo;

    public VeterinarioCanil() {
    }

    public VeterinarioCanil(Long id, String protocol, String order, LocalDate orderDate, String complainantName, String complaintAddress, String animalName, String species, Integer age, String breed, String weight, String ownerName, String address, String number, String complement, String neighborhood, String city, String phone, String whatsapp, String rg, String cpf, LocalDate consultDate, Integer vetId, String collarColor, String collarNumber, String animalHistory, String castrated, String castrationDate, String vermifuged, String vermifugationDate, String vaccinated, String vaccinationDate, String firstCollarEvolution, String firstCollarEvolutionDate, String secondCollarEvolution, String secondCollarEvolutionDate, String thirdCollarEvolution, String thirdCollarEvolutionDate, String chemo, String amountChemos, String firstChemo, String secondChemo, String thirdChemo, String fourthChemo, String fifthChemo) {
        this.id = id;
        this.protocol = protocol;
        this.order = order;
        this.orderDate = orderDate;
        this.complainantName = complainantName;
        this.complaintAddress = complaintAddress;
        this.animalName = animalName;
        this.species = species;
        this.age = age;
        this.breed = breed;
        this.weight = weight;
        this.ownerName = ownerName;
        this.address = address;
        this.number = number;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.city = city;
        this.phone = phone;
        this.whatsapp = whatsapp;
        this.rg = rg;
        this.cpf = cpf;
        this.consultDate = consultDate;
        this.vetId = vetId;
        this.collarColor = collarColor;
        this.collarNumber = collarNumber;
        this.animalHistory = animalHistory;
        this.castrated = castrated;
        this.castrationDate = castrationDate;
        this.vermifuged = vermifuged;
        this.vermifugationDate = vermifugationDate;
        this.vaccinated = vaccinated;
        this.vaccinationDate = vaccinationDate;
        this.firstCollarEvolution = firstCollarEvolution;
        this.firstCollarEvolutionDate = firstCollarEvolutionDate;
        this.secondCollarEvolution = secondCollarEvolution;
        this.secondCollarEvolutionDate = secondCollarEvolutionDate;
        this.thirdCollarEvolution = thirdCollarEvolution;
        this.thirdCollarEvolutionDate = thirdCollarEvolutionDate;
        this.chemo = chemo;
        this.amountChemos = amountChemos;
        this.firstChemo = firstChemo;
        this.secondChemo = secondChemo;
        this.thirdChemo = thirdChemo;
        this.fourthChemo = fourthChemo;
        this.fifthChemo = fifthChemo;
    }

    public Long getId() {
        return id;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getComplainantName() {
        return complainantName;
    }

    public void setComplainantName(String complainantName) {
        this.complainantName = complainantName;
    }

    public String getComplaintAddress() {
        return complaintAddress;
    }

    public void setComplaintAddress(String complaintAddress) {
        this.complaintAddress = complaintAddress;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getConsultDate() {
        return consultDate;
    }

    public void setConsultDate(LocalDate consultDate) {
        this.consultDate = consultDate;
    }

    public Integer getVetId() {
        return vetId;
    }

    public void setVetId(Integer vetId) {
        this.vetId = vetId;
    }

    public String getCollarColor() {
        return collarColor;
    }

    public void setCollarColor(String collarColor) {
        this.collarColor = collarColor;
    }

    public String getCollarNumber() {
        return collarNumber;
    }

    public void setCollarNumber(String collarNumber) {
        this.collarNumber = collarNumber;
    }

    public String getAnimalHistory() {
        return animalHistory;
    }

    public void setAnimalHistory(String animalHistory) {
        this.animalHistory = animalHistory;
    }

    public String getCastrated() {
        return castrated;
    }

    public void setCastrated(String castrated) {
        this.castrated = castrated;
    }

    public String getCastrationDate() {
        return castrationDate;
    }

    public void setCastrationDate(String castrationDate) {
        this.castrationDate = castrationDate;
    }

    public String getVermifuged() {
        return vermifuged;
    }

    public void setVermifuged(String vermifuged) {
        this.vermifuged = vermifuged;
    }

    public String getVermifugationDate() {
        return vermifugationDate;
    }

    public void setVermifugationDate(String vermifugationDate) {
        this.vermifugationDate = vermifugationDate;
    }

    public String getVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(String vaccinated) {
        this.vaccinated = vaccinated;
    }

    public String getVaccinationDate() {
        return vaccinationDate;
    }

    public void setVaccinationDate(String vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
    }

    public String getFirstCollarEvolution() {
        return firstCollarEvolution;
    }

    public void setFirstCollarEvolution(String firstCollarEvolution) {
        this.firstCollarEvolution = firstCollarEvolution;
    }

    public String getFirstCollarEvolutionDate() {
        return firstCollarEvolutionDate;
    }

    public void setFirstCollarEvolutionDate(String firstCollarEvolutionDate) {
        this.firstCollarEvolutionDate = firstCollarEvolutionDate;
    }

    public String getSecondCollarEvolution() {
        return secondCollarEvolution;
    }

    public void setSecondCollarEvolution(String secondCollarEvolution) {
        this.secondCollarEvolution = secondCollarEvolution;
    }

    public String getSecondCollarEvolutionDate() {
        return secondCollarEvolutionDate;
    }

    public void setSecondCollarEvolutionDate(String secondCollarEvolutionDate) {
        this.secondCollarEvolutionDate = secondCollarEvolutionDate;
    }

    public String getThirdCollarEvolution() {
        return thirdCollarEvolution;
    }

    public void setThirdCollarEvolution(String thirdCollarEvolution) {
        this.thirdCollarEvolution = thirdCollarEvolution;
    }

    public String getThirdCollarEvolutionDate() {
        return thirdCollarEvolutionDate;
    }

    public void setThirdCollarEvolutionDate(String thirdCollarEvolutionDate) {
        this.thirdCollarEvolutionDate = thirdCollarEvolutionDate;
    }

    public String getChemo() {
        return chemo;
    }

    public void setChemo(String chemo) {
        this.chemo = chemo;
    }

    public String getAmountChemos() {
        return amountChemos;
    }

    public void setAmountChemos(String amountChemos) {
        this.amountChemos = amountChemos;
    }

    public String getFirstChemo() {
        return firstChemo;
    }

    public void setFirstChemo(String firstChemo) {
        this.firstChemo = firstChemo;
    }

    public String getSecondChemo() {
        return secondChemo;
    }

    public void setSecondChemo(String secondChemo) {
        this.secondChemo = secondChemo;
    }

    public String getThirdChemo() {
        return thirdChemo;
    }

    public void setThirdChemo(String thirdChemo) {
        this.thirdChemo = thirdChemo;
    }

    public String getFourthChemo() {
        return fourthChemo;
    }

    public void setFourthChemo(String fourthChemo) {
        this.fourthChemo = fourthChemo;
    }

    public String getFifthChemo() {
        return fifthChemo;
    }

    public void setFifthChemo(String fifthChemo) {
        this.fifthChemo = fifthChemo;
    }
}
