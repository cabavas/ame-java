package com.example.ame.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "tb_animal")
public class Animal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_animal")
    private Long id;

    @Column(name = "nome_animal")
    private String animalName;

    @Column(name = "nascimento")
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
    @JsonBackReference
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

    public Animal() {
    }

    public Animal(Long id, String animalName, Integer age, String species, String breed, String sex, String fur, Float weight, String size, Tutor tutor, Boolean castrated, LocalDate castrationDate, Boolean vermifuged, LocalDate vermifugationDate, Boolean vaccinated, LocalDate vaccinationDate, String history) {
        this.id = id;
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
    }

    public Long getId() {
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

    public Tutor getTutorId() {
        return tutor;
    }

    public void setTutorId(Tutor tutor) {
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
}
