package com.example.ame.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tb_tutor")
public class Tutor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tutor", nullable = false)
    private Integer idTutor;

    @Column(name = "nome_tutor")
    private String name;

    @Column(name = "endereco")
    private String address;

    @Column(name = "numero")
    private Integer number;

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

    @Column(name = "nis")
    private String nis;

    @Column(name = "rg")
    private String rg;

    @Column(name = "cpf")
    private String cpf;

    @OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Animal> animals;

    public Tutor() {
    }

    public Tutor(Integer idTutor, String name, String address, Integer number, String complement, String neighborhood, String city, String phone, String whatsapp, String nis, String rg, String cpf, List<Animal> animals) {
        this.idTutor = idTutor;
        this.name = name;
        this.address = address;
        this.number = number;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.city = city;
        this.phone = phone;
        this.whatsapp = whatsapp;
        this.nis = nis;
        this.rg = rg;
        this.cpf = cpf;
        this.animals = animals;
    }

    public Integer getIdTutor() {
        return idTutor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
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

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
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

    public List<Animal> getAnimals() {
        return animals;
    }
}
