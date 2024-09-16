package com.example.ame.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_atendimento")
public class Atendimento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atendimento", nullable = false)
    private Integer id;

    @Column(name = "id_tipo_consulta")
    private Integer consultType;

    @Column(name = "data_atendimento")
    private String consultDate;

    @Column(name = "hora_inicial")
    private String initialTime;

    @Column(name = "id_tipo_paciente")
    private Integer kindPatient;

    @Column(name = "id_codigo_solicitacao")
    private Integer solicitCode;

    @ManyToOne
    @JoinColumn(name = "id_animal")
    private Animal animal;

    @Column(name = "hora_final")
    private String endTime;

    @Column(name = "protocolo")
    private String protocol;

    @Column(name = "id_veterinario")
    private Integer vetId;

    public Atendimento() {
    }

    public Atendimento(Integer consultType, String consultDate, String initialTime, Integer kindPatient, Integer solicitCode, Animal animal, String endTime, String protocol, Integer vetId) {
        this.consultType = consultType;
        this.consultDate = consultDate;
        this.initialTime = initialTime;
        this.kindPatient = kindPatient;
        this.solicitCode = solicitCode;
        this.animal = animal;
        this.endTime = endTime;
        this.protocol = protocol;
        this.vetId = vetId;
    }

    public Integer getId() {
        return id;
    }

    public Integer getConsultType() {
        return consultType;
    }

    public void setConsultType(Integer consultType) {
        this.consultType = consultType;
    }

    public String getConsultDate() {
        return consultDate;
    }

    public void setConsultDate(String consultDate) {
        this.consultDate = consultDate;
    }

    public String getInitialTime() {
        return initialTime;
    }

    public void setInitialTime(String initialTime) {
        this.initialTime = initialTime;
    }

    public Integer getKindPatient() {
        return kindPatient;
    }

    public void setKindPatient(Integer kindPatient) {
        this.kindPatient = kindPatient;
    }

    public Integer getSolicitCode() {
        return solicitCode;
    }

    public void setSolicitCode(Integer solicitCode) {
        this.solicitCode = solicitCode;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animalId) {
        this.animal = animalId;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public Integer getVetId() {
        return vetId;
    }

    public void setVetId(Integer vetId) {
        this.vetId = vetId;
    }
}
