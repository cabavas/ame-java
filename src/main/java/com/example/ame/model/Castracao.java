package com.example.ame.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "tb_castracao")
public class Castracao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_castracao")
    private Integer id;

    @Column(name = "data_atendimento")
    private LocalDate consultDate;

    @Column(name = "id_codigo_solicitacao")
    private String solicitCode;

    @Column(name = "id_tipo_paciente")
    private String kindPatient;

    @Column(name = "nome_protetor")
    private String protectorName;

    @ManyToOne
    @JoinColumn(name = "id_clinica")
    private Clinica clinica;

    @Column(name = "data_cirurgia")
    private LocalDate surgeryDate;

    @Column(name = "status_cirurgia")
    private String surgeryStatus;

    @ManyToOne
    @JoinColumn(name = "id_animal")
    private Animal animal;

    @Column(name = "protocolo")
    private String protocol;

    @Column(name = "id_veterinario")
    private String vetId;

    public Castracao() {
    }

    public Castracao(Integer id, LocalDate consultDate, String solicitCode, String kindPatient, String protectorName, Clinica clinica, LocalDate surgeryDate, String surgeryStatus, Animal animal, String protocol, String vetId) {
        this.id = id;
        this.consultDate = consultDate;
        this.solicitCode = solicitCode;
        this.kindPatient = kindPatient;
        this.protectorName = protectorName;
        this.clinica = clinica;
        this.surgeryDate = surgeryDate;
        this.surgeryStatus = surgeryStatus;
        this.animal = animal;
        this.protocol = protocol;
        this.vetId = vetId;
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getConsultDate() {
        return consultDate;
    }

    public void setConsultDate(LocalDate consultDate) {
        this.consultDate = consultDate;
    }

    public String getSolicitCode() {
        return solicitCode;
    }

    public void setSolicitCode(String solicitCode) {
        this.solicitCode = solicitCode;
    }

    public String getKindPatient() {
        return kindPatient;
    }

    public void setKindPatient(String kindPatient) {
        this.kindPatient = kindPatient;
    }

    public String getProtectorName() {
        return protectorName;
    }

    public void setProtectorName(String protectorName) {
        this.protectorName = protectorName;
    }

    public Clinica getClinica() {
        return clinica;
    }

    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }

    public LocalDate getSurgeryDate() {
        return surgeryDate;
    }

    public void setSurgeryDate(LocalDate surgeryDate) {
        this.surgeryDate = surgeryDate;
    }

    public String getSurgeryStatus() {
        return surgeryStatus;
    }

    public void setSurgeryStatus(String surgeryStatus) {
        this.surgeryStatus = surgeryStatus;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getVetId() {
        return vetId;
    }

    public void setVetId(String vetId) {
        this.vetId = vetId;
    }
}
