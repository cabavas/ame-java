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
    private Long id;

    @Column(name = "data_atendimento")
    private LocalDate consultDate;

    @Column(name = "id_codigo_solicitacao")
    private String solicitCode;

    @Column(name = "id_tipo_paciente")
    private String patientKind;

    @Column(name = "nome_protetor")
    private String protectorName;

    @OneToOne
    @JoinColumn(name = "id_tutor")
    private Tutor tutorId;

    @Column(name = "id_clinica")
    private String clinica;

    @Column(name = "data_cirurgia")
    private LocalDate surgeryDate;

    @Column(name = "status_cirurgia")
    private String surgeryStatus;

    @OneToOne
    @JoinColumn(name = "id_animal")
    private Animal animalId;

    @Column(name = "protocolo")
    private String protocol;

    @Column(name = "id_veterinario")
    private String vetId;

    public Castracao() {
    }

    public Castracao(Long id, LocalDate consultDate, String solicitCode, String patientKind, String protectorName, Tutor tutorId, String clinica, LocalDate surgeryDate, String surgeryStatus, Animal animalId, String protocol, String vetId) {
        this.id = id;
        this.consultDate = consultDate;
        this.solicitCode = solicitCode;
        this.patientKind = patientKind;
        this.protectorName = protectorName;
        this.tutorId = tutorId;
        this.clinica = clinica;
        this.surgeryDate = surgeryDate;
        this.surgeryStatus = surgeryStatus;
        this.animalId = animalId;
        this.protocol = protocol;
        this.vetId = vetId;
    }

    public Long getId() {
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

    public String getPatientKind() {
        return patientKind;
    }

    public void setPatientKind(String patientKind) {
        this.patientKind = patientKind;
    }

    public String getProtectorName() {
        return protectorName;
    }

    public void setProtectorName(String protectorName) {
        this.protectorName = protectorName;
    }

    public Tutor getTutorId() {
        return tutorId;
    }

    public void setTutorId(Tutor tutorId) {
        this.tutorId = tutorId;
    }

    public String getClinica() {
        return clinica;
    }

    public void setClinica(String clinica) {
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

    public Animal getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Animal animalId) {
        this.animalId = animalId;
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
