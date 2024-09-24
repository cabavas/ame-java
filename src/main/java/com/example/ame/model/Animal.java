package com.example.ame.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "tb_animal")
public class Animal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_animal")
    private Integer id;

    @Column(name = "nome_animal")
    private String animalName;

    @Column(name = "idade")
    private Integer age;

    @Column(name = "especie")
    private String species;

    @Column(name = "raca")
    private String breed;

    @Column(name = "sexo")
    private String sex;

    @Column(name = "cor_pelagem")
    private String fur;

    @Column(name = "peso")
    private Float weight;

    @Column(name = "porte")
    private String size;

    @ManyToOne
    @JoinColumn(name = "id_tutor")
    private Tutor tutor;

    @Column(name = "castrado")
    private Boolean castrated;

    @Column(name = "data_castracao")
    private LocalDate castrationDate;

    @Column(name = "vermifugado")
    private Boolean vermifuged;

    @Column(name = "data_vermifugacao")
    private LocalDate vermifugationDate;

    @Column(name = "vacinado")
    private Boolean vaccinated;

    @Column(name = "data_vacinacao")
    private LocalDate vaccinationDate;

    @Column(name = "historico")
    private String history;

    @Column(name = "anamnese")
    private String anamnesis;

    @Column(name = "tratamento")
    private String treatment;

    public Animal() {
    }

    public Animal(String animalName, Integer age, String species, String breed, String sex, String fur, Float weight, String size, Tutor tutor, Boolean castrated, LocalDate castrationDate, Boolean vermifuged, LocalDate vermifugationDate, Boolean vaccinated, LocalDate vaccinationDate, String history, String anamnesis, String treatment) {
        this.animalName = animalName;
        this.age = age;
        this.species = species;
        this.breed = breed;
        this.sex = sex;
        this.fur = fur;
        this.weight = weight;
        this.size = size;
        this.tutor = tutor;
        this.castrated = castrated;
        this.castrationDate = castrationDate;
        this.vermifuged = vermifuged;
        this.vermifugationDate = vermifugationDate;
        this.vaccinated = vaccinated;
        this.vaccinationDate = vaccinationDate;
        this.history = history;
        this.anamnesis = anamnesis;
        this.treatment = this.treatment;
    }

    public Integer getId() {
        return id;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getFur() {
        return fur;
    }

    public void setFur(String fur) {
        this.fur = fur;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public Boolean getCastrated() {
        return castrated;
    }

    public void setCastrated(Boolean castrated) {
        this.castrated = castrated;
    }

    public LocalDate getCastrationDate() {
        return castrationDate;
    }

    public void setCastrationDate(LocalDate castrationDate) {
        this.castrationDate = castrationDate;
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

    public Boolean getVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(Boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

    public LocalDate getVaccinationDate() {
        return vaccinationDate;
    }

    public void setVaccinationDate(LocalDate vaccinationDate) {
        this.vaccinationDate = vaccinationDate;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getAnamnesis() {
        return anamnesis;
    }

    public void setAnamnesis(String anamnesis) {
        this.anamnesis = anamnesis;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", animalName='" + animalName + '\'' +
                ", age=" + age +
                ", species='" + species + '\'' +
                ", breed='" + breed + '\'' +
                ", sex='" + sex + '\'' +
                ", fur='" + fur + '\'' +
                ", weight=" + weight +
                ", size='" + size + '\'' +
                ", tutor=" + tutor +
                ", castrated=" + castrated +
                ", castrationDate=" + castrationDate +
                ", vermifuged=" + vermifuged +
                ", vermifugationDate=" + vermifugationDate +
                ", vaccinated=" + vaccinated +
                ", vaccinationDate=" + vaccinationDate +
                ", history='" + history + '\'' +
                ", anamnesis='" + anamnesis + '\'' +
                ", treatment='" + treatment + '\'' +
                '}';
    }
}
