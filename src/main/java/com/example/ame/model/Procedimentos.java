package com.example.ame.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_procedimentos")
public class Procedimentos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_procedimento")
    private Integer id;

    @Column(name = "nome_protetor")
    private String protectorName;

    @OneToOne
    @JoinColumn(name = "id_tutor")
    private Tutor tutorId;

    @OneToOne
    @JoinColumn(name = "id_procedimento")
    private Animal animalId;

    @Column(name = "id_procedimento1")
    private String procedure1;

    @Column(name = "id_procedimento2")
    private String procedure2;

    @Column(name = "observacoes")
    private String observations;

    @Column(name = "data_agendamento")
    private String scheduleDate;

    @Column(name = "status_atendimento")
    private String consultStatus;

    @Column(name = "protocolo")
    private String protocol;

    @Column(name = "data_atendimento")
    private String consultDate;

    @Column(name = "id_codigo_solicitacao")
    private String solicitCode;

    @Column(name = "id_tipo_paciente")
    private String patientKind;

    public Procedimentos() {
    }

    public Procedimentos(Integer id, String protectorName, Tutor tutorId, Animal animalId, String procedure1, String procedure2, String observations, String scheduleDate, String consultStatus, String protocol, String consultDate, String solicitCode, String patientKind) {
        this.id = id;
        this.protectorName = protectorName;
        this.tutorId = tutorId;
        this.animalId = animalId;
        this.procedure1 = procedure1;
        this.procedure2 = procedure2;
        this.observations = observations;
        this.scheduleDate = scheduleDate;
        this.consultStatus = consultStatus;
        this.protocol = protocol;
        this.consultDate = consultDate;
        this.solicitCode = solicitCode;
        this.patientKind = patientKind;
    }

    public Integer getId() {
        return id;
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

    public Animal getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Animal animalId) {
        this.animalId = animalId;
    }

    public String getProcedure1() {
        return procedure1;
    }

    public void setProcedure1(String procedure1) {
        this.procedure1 = procedure1;
    }

    public String getProcedure2() {
        return procedure2;
    }

    public void setProcedure2(String procedure2) {
        this.procedure2 = procedure2;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public String getConsultStatus() {
        return consultStatus;
    }

    public void setConsultStatus(String consultStatus) {
        this.consultStatus = consultStatus;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getConsultDate() {
        return consultDate;
    }

    public void setConsultDate(String consultDate) {
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
}
