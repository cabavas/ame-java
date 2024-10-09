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
    private Integer id;

   @Column(name = "endereco")
    private String address;

   @Column(name = "idade")
    private Integer age;

   @Column(name = "historico_animal")
    private String animalHistory;

   @Column(name = "nome_animal")
    private String animalName;

   @Column(name = "raca")
    private String breed;

   @Column(name = "castrado")
    private String castrated;

   @Column(name = "data_castracao")
    private LocalDate castrationDate;

   @Column(name = "quimioterapia")
    private Boolean chemo;

   @Column(name = "qtd_quimio")
    private Integer chemoAmount;

   @Column(name = "cidade")
    private String city;

   @Column(name = "cor_coleira")
    private String collarColor;

   @Column(name = "numero_coleira")
   private String collarNumber;

   @Column(name = "endereco_denuncia")
    private String complaintAddress;

   @Column(name = "complemento")
    private String complement;

   @Column(name = "cpf")
    private String cpf;

   @Column(name = "data")
    private LocalDate date;

   @Column(name = "doutor")
    private String doctor;

   @Column(name = "5_quimio")
    private LocalDate fifthChemo;

    @Column(name = "1_quimio")
    private LocalDate firstChemo;

    @Column(name = "1_evo_coleira")
    private String firstCollarEvolution;

    @Column(name = "data_1_evo_coleira")
    private LocalDate firstEvolutionDate;

    @Column(name = "4_quimio")
    private LocalDate fourthChemo;

    @Column(name = "bairro")
    private String neighborhood;

    @Column(name = "numero")
    private String number;

    @Column(name = "ordem")
    private String order;

    @Column(name = "data_ordem")
    private LocalDate orderDate;

    @Column(name = "nome_proprietario")
    private String ownerName;

    @Column(name = "telefone")
    private String phone;

    @Column(name = "protocolo")
    private String protocol;

    @Column(name = "rg")
    private String rg;

    @Column(name = "2_quimio")
    private LocalDate secondChemo;

    @Column(name = "2_evo_coleira")
    private String secondCollarEvolution;

    @Column(name = "data_2_evo_coleira")
    private LocalDate secondEvolutionDate;

    @Column(name = "especie")
    private String species;

    @Column(name = "3_quimio")
    private LocalDate thirdChemo;

    @Column(name = "3_evo_coleira")
    private String thirdCollarEvolution;

    @Column(name = "data_3_evo_coleira")
    private LocalDate thirdEvolutionDate;

    @Column(name = "vacinado")
    private Boolean vaccinated;

    @Column(name = "data_vacinacao")
    private LocalDate vaccinationDate;

    @Column(name = "vermifugado")
    private Boolean vermifuged;

    @Column(name = "data_vermifugacao")
    private LocalDate vermifugationDate;

    @Column(name = "peso")
    private String weight;

    @Column(name = "whatsapp")
    private Boolean whatsapp;

    @Column(name = "denunciante")
    private String whistleblower;

    @Column(name = "link")
    private String link;

    public VeterinarioCanil() {
    }

    public Integer getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAnimalHistory() {
        return animalHistory;
    }

    public void setAnimalHistory(String animalHistory) {
        this.animalHistory = animalHistory;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getCastrated() {
        return castrated;
    }

    public void setCastrated(String castrated) {
        this.castrated = castrated;
    }

    public LocalDate getCastrationDate() {
        return castrationDate;
    }

    public void setCastrationDate(LocalDate castrationDate) {
        this.castrationDate = castrationDate;
    }

    public Boolean getChemo() {
        return chemo;
    }

    public void setChemo(Boolean chemo) {
        this.chemo = chemo;
    }

    public Integer getChemoAmount() {
        return chemoAmount;
    }

    public void setChemoAmount(Integer chemoAmount) {
        this.chemoAmount = chemoAmount;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCollarColor() {
        return collarColor;
    }

    public void setCollarColor(String collarColor) {
        this.collarColor = collarColor;
    }

    public String getComplaintAddress() {
        return complaintAddress;
    }

    public void setComplaintAddress(String complaintAddress) {
        this.complaintAddress = complaintAddress;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public LocalDate getFifthChemo() {
        return fifthChemo;
    }

    public void setFifthChemo(LocalDate fifthChemo) {
        this.fifthChemo = fifthChemo;
    }

    public LocalDate getFirstChemo() {
        return firstChemo;
    }

    public void setFirstChemo(LocalDate firstChemo) {
        this.firstChemo = firstChemo;
    }

    public String getFirstCollarEvolution() {
        return firstCollarEvolution;
    }

    public void setFirstCollarEvolution(String firstCollarEvolution) {
        this.firstCollarEvolution = firstCollarEvolution;
    }

    public LocalDate getFirstEvolutionDate() {
        return firstEvolutionDate;
    }

    public void setFirstEvolutionDate(LocalDate firstEvolutionDate) {
        this.firstEvolutionDate = firstEvolutionDate;
    }

    public LocalDate getFourthChemo() {
        return fourthChemo;
    }

    public void setFourthChemo(LocalDate fourthChemo) {
        this.fourthChemo = fourthChemo;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public LocalDate getSecondChemo() {
        return secondChemo;
    }

    public void setSecondChemo(LocalDate secondChemo) {
        this.secondChemo = secondChemo;
    }

    public String getSecondCollarEvolution() {
        return secondCollarEvolution;
    }

    public void setSecondCollarEvolution(String secondCollarEvolution) {
        this.secondCollarEvolution = secondCollarEvolution;
    }

    public LocalDate getSecondEvolutionDate() {
        return secondEvolutionDate;
    }

    public void setSecondEvolutionDate(LocalDate secondEvolutionDate) {
        this.secondEvolutionDate = secondEvolutionDate;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public LocalDate getThirdChemo() {
        return thirdChemo;
    }

    public void setThirdChemo(LocalDate thirdChemo) {
        this.thirdChemo = thirdChemo;
    }

    public String getThirdCollarEvolution() {
        return thirdCollarEvolution;
    }

    public void setThirdCollarEvolution(String thirdCollarEvolution) {
        this.thirdCollarEvolution = thirdCollarEvolution;
    }

    public LocalDate getThirdEvolutionDate() {
        return thirdEvolutionDate;
    }

    public void setThirdEvolutionDate(LocalDate thirdEvolutionDate) {
        this.thirdEvolutionDate = thirdEvolutionDate;
    }

    public Boolean getVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(Boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

    public LocalDate getVaccinationDate() {
        return vaccinationDate;
    }

    public void setVaccinationDate(LocalDate vaccionationDate) {
        this.vaccinationDate = vaccionationDate;
    }

    public Boolean getVermifuged() {
        return vermifuged;
    }

    public void setVermifuged(Boolean vermifuged) {
        this.vermifuged = vermifuged;
    }

    public LocalDate getVermifugationDate() {
        return vermifugationDate;
    }

    public void setVermifugationDate(LocalDate vermifugationDate) {
        this.vermifugationDate = vermifugationDate;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Boolean getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(Boolean whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getWhistleblower() {
        return whistleblower;
    }

    public void setWhistleblower(String whistleblower) {
        this.whistleblower = whistleblower;
    }

    public String getCollarNumber() {
        return collarNumber;
    }

    public void setCollarNumber(String collarNumber) {
        this.collarNumber = collarNumber;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
