package com.example.ame.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_atendimento_veterinario")
public class AtendimentoVeterinario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atendimento_veterinario")
    private Integer id;

    @Column(name = "data_atendimento")
    private String consultDate;

    @Column(name = "hora_inicial")
    private String initialTime;

    @Column(name = "id_tipo_paciente")
    private Integer kindPatient;

    @Column(name = "id_tipo_consulta")
    private Integer consultType;

    @Column(name = "anamnese")
    private String anamnesis;

    @Column(name = "tratamento")
    private String treatment;

    @Column(name = "id_tipo_procedimento")
    private Integer procedureKind;

    @Column(name = "id_codigo_solicitacao")
    private Integer solicitCode;

    @OneToOne
    @JoinColumn(name = "animal")
    private Animal animal;

    @Column(name = "id_veterinario")
    private Integer doctor;


    public AtendimentoVeterinario() {
    }

    public AtendimentoVeterinario(Integer id, String consultDate, String initialTime, Integer kindPatient, String anamnesis, String treatment, Integer procedureKind, Animal animal, Integer solicitCode, Integer consultType, Integer vetId) {
        this.id = id;
        this.consultDate = consultDate;
        this.initialTime = initialTime;
        this.kindPatient = kindPatient;
        this.anamnesis = anamnesis;
        this.treatment = treatment;
        this.procedureKind = procedureKind;
        this.animal = animal;
        this.solicitCode = solicitCode;
        this.consultType = consultType;
        this.doctor = vetId;
    }

    public Integer getId() {
        return id;
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

    public Integer getProcedureKind() {
        return procedureKind;
    }

    public void setProcedureKind(Integer procedureKind) {
        this.procedureKind = procedureKind;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Integer getSolicitCode() {
        return solicitCode;
    }

    public void setSolicitCode(Integer solicitCode) {
        this.solicitCode = solicitCode;
    }

    public Integer getConsultType() {
        return consultType;
    }

    public void setConsultType(Integer consultType) {
        this.consultType = consultType;
    }

    public Integer getDoctor() {
        return doctor;
    }

    public void setDoctor(Integer doctor) {
        this.doctor = doctor;
    }
}
