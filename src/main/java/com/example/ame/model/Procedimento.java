package com.example.ame.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_procedimentos")
public class Procedimento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_procedimento")
    private Integer id;

    @Column(name = "nome_protetor")
    private String protectorName;

    @OneToOne
    @JoinColumn(name = "id_procedimento")
    private Animal animal;

    @Column(name = "id_procedimento1")
    private String procedure1;

    @Column(name = "id_procedimento2")
    private String procedure2;

    @Column(name = "observacoes")
    private String observations;

    @Column(name = "data_agendamento")
    private String appointmentDate;

    @Column(name = "status_atendimento")
    private String appointmentStatus;

    @Column(name = "data_atendimento")
    private String consultDate;

    @Column(name = "id_codigo_solicitacao")
    private String solicitCode;

    @Column(name = "id_tipo_paciente")
    private String kindPatient;

    public Procedimento() {
    }

    public Procedimento(Integer id, String protectorName, Animal animal, String procedure1, String procedure2, String observations, String appointmentDate, String consultStatus, String consultDate, String solicitCode, String kindPatient) {
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.appointmentStatus = consultStatus;
        this.consultDate = consultDate;
        this.kindPatient = kindPatient;
        this.observations = observations;
        this.procedure1 = procedure1;
        this.procedure2 = procedure2;
        this.protectorName = protectorName;
        this.solicitCode = solicitCode;
        this.animal = animal;
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

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
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

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(String appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
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

    public String getKindPatient() {
        return kindPatient;
    }

    public void setKindPatient(String kindPatient) {
        this.kindPatient = kindPatient;
    }
}
