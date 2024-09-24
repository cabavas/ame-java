package com.example.ame.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "tb_encaminhamento")
public class Encaminhamento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_encaminhamento")
    private Integer id;

    @Column(name = "data_atendimento")
    private LocalDate consultDate;

    @Column(name = "id_codigo_solicitacao")
    private Integer solicitCode;

    @Column(name = "id_tipo_paciente")
    private Integer kindPatient;

    @Column(name = "nome_protetor")
    private String protectorName;

    @OneToOne
    @JoinColumn(name = "id_animal")
    private Animal animal;

    @Column(name = "exam1")
    private String exam1;

    @Column(name = "exam2")
    private String exam2;

    @Column(name = "exam3")
    private String exam3;

    @ManyToOne
    @JoinColumn(name = "id_clinica")
    private Clinica clinic;

    @Column(name = "status_agendamento")
    private String appointmentStatus;

    @Column(name = "data_agendamento")
    private LocalDate appointmentDate;

    public Encaminhamento() {
    }

    public Encaminhamento(LocalDate consultDate, Integer solicitCode, Integer kindPatient, String protectorName, Animal animal, String exam1, String exam2, String exam3, Clinica clinic, String appointmentStatus, LocalDate appointmentDate) {
        this.consultDate = consultDate;
        this.solicitCode = solicitCode;
        this.kindPatient = kindPatient;
        this.protectorName = protectorName;
        this.animal = animal;
        this.exam1 = exam1;
        this.exam2 = exam2;
        this.exam3 = exam3;
        this.clinic = clinic;
        this.appointmentStatus = appointmentStatus;
        this.appointmentDate = appointmentDate;
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

    public Integer getSolicitCode() {
        return solicitCode;
    }

    public void setSolicitCode(Integer solicitCode) {
        this.solicitCode = solicitCode;
    }

    public Integer getKindPatient() {
        return kindPatient;
    }

    public void setKindPatient(Integer kindPatient) {
        this.kindPatient = kindPatient;
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

    public String getExam1() {
        return exam1;
    }

    public void setExam1(String exam1) {
        this.exam1 = exam1;
    }

    public String getExam2() {
        return exam2;
    }

    public void setExam2(String exam2) {
        this.exam2 = exam2;
    }

    public String getExam3() {
        return exam3;
    }

    public void setExam3(String exam3) {
        this.exam3 = exam3;
    }

    public Clinica getClinic() {
        return clinic;
    }

    public void setClinic(Clinica clinic) {
        this.clinic = clinic;
    }

    public String getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(String appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    @Override
    public String toString() {
        return "Encaminhamento{" +
                "id=" + id +
                ", consultDate=" + consultDate +
                ", solicitCode=" + solicitCode +
                ", kindPatient=" + kindPatient +
                ", protectorName='" + protectorName + '\'' +
                ", animal=" + animal +
                ", exam1='" + exam1 + '\'' +
                ", exam2='" + exam2 + '\'' +
                ", exam3='" + exam3 + '\'' +
                ", clinic=" + clinic +
                ", appointmentStatus='" + appointmentStatus + '\'' +
                ", appointmentDate=" + appointmentDate +
                '}';
    }
}
