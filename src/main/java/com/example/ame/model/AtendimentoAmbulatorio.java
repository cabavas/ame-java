package com.example.ame.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "tb_atendimento_ambulatorio")
public class AtendimentoAmbulatorio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atendimento_ambulatorio", nullable = false)
    private Long id;

    @Column(name = "id_tipo_consulta")
    private Integer consultType;

    @Column(name = "hora_inicial")
    private LocalTime initialTime;

    @Column(name = "id_tipo_paciente")
    private Integer patientKind;

    @Column(name = "id_codigo_solicitacao")
    private Integer solicitCode;

    @OneToOne
    @JoinColumn(name = "id_animal")
    private Animal animalId;

    @OneToOne
    @JoinColumn(name = "nome_tutor")
    private Tutor tutorId;

    @Column(name = "anamnese")
    private String anamnesis;

    @Column(name = "procedimentos")
    private String procedures;

    @Column(name = "cirurgiao")
    private String surgeon;

    @Column(name = "observacoes")
    private String observations;

    @Column(name = "tratamento")
    private String treatment;

    @Column(name = "status_animal")
    private String animalStatus;

    @Column(name = "data_atendimento")
    private String atendimentoDate;

    @Column(name = "hora_atendimento")
    private LocalTime atendimentoTime;

    @Column(name = "data_consulta")
    private LocalDate consultDate;

    public AtendimentoAmbulatorio() {
    }

    public AtendimentoAmbulatorio(Long id, Integer consultType, LocalTime initialTime, Integer patientKind, Integer solicitCode, Animal animalId, Tutor tutorId, String anamnesis, String procedures, String surgeon, String observations, String treatment, String animalStatus, String atendimentoDate, LocalTime atendimentoTime, LocalDate consultDate) {
        this.id = id;
        this.consultType = consultType;
        this.initialTime = initialTime;
        this.patientKind = patientKind;
        this.solicitCode = solicitCode;
        this.animalId = animalId;
        this.tutorId = tutorId;
        this.anamnesis = anamnesis;
        this.procedures = procedures;
        this.surgeon = surgeon;
        this.observations = observations;
        this.treatment = treatment;
        this.animalStatus = animalStatus;
        this.atendimentoDate = atendimentoDate;
        this.atendimentoTime = atendimentoTime;
        this.consultDate = consultDate;
    }

    public Long getId() {
        return id;
    }

    public Integer getConsultType() {
        return consultType;
    }

    public void setConsultType(Integer consultType) {
        this.consultType = consultType;
    }

    public LocalTime getInitialTime() {
        return initialTime;
    }

    public void setInitialTime(LocalTime initialTime) {
        this.initialTime = initialTime;
    }

    public Integer getPatientKind() {
        return patientKind;
    }

    public void setPatientKind(Integer patientKind) {
        this.patientKind = patientKind;
    }

    public Integer getSolicitCode() {
        return solicitCode;
    }

    public void setSolicitCode(Integer solicitCode) {
        this.solicitCode = solicitCode;
    }

    public Animal getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Animal animalId) {
        this.animalId = animalId;
    }

    public Tutor getTutorId() {
        return tutorId;
    }

    public void setTutorId(Tutor tutorId) {
        this.tutorId = tutorId;
    }

    public String getAnamnesis() {
        return anamnesis;
    }

    public void setAnamnesis(String anamnesis) {
        this.anamnesis = anamnesis;
    }

    public String getProcedures() {
        return procedures;
    }

    public void setProcedures(String procedures) {
        this.procedures = procedures;
    }

    public String getSurgeon() {
        return surgeon;
    }

    public void setSurgeon(String surgeon) {
        this.surgeon = surgeon;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getAnimalStatus() {
        return animalStatus;
    }

    public void setAnimalStatus(String animalStatus) {
        this.animalStatus = animalStatus;
    }

    public String getAtendimentoDate() {
        return atendimentoDate;
    }

    public void setAtendimentoDate(String atendimentoDate) {
        this.atendimentoDate = atendimentoDate;
    }

    public LocalTime getAtendimentoTime() {
        return atendimentoTime;
    }

    public void setAtendimentoTime(LocalTime atendimentoTime) {
        this.atendimentoTime = atendimentoTime;
    }

    public LocalDate getConsultDate() {
        return consultDate;
    }

    public void setConsultDate(LocalDate consultDate) {
        this.consultDate = consultDate;
    }
}
