package com.example.ame.model.dto;

import com.example.ame.model.Animal;

import java.time.LocalDate;

public class ProcedimentoDTO {
    private LocalDate consultDate;
    private String appointmentStatus;
    private String observations;
    private String kindPatient;
    private Integer procedure1;
    private Integer procedure2;
    private String protectorName;
    private String protocol;
    private LocalDate appointmentDate;
    private Integer solicitCode;
    private Animal animal;

    public ProcedimentoDTO() {
    }

    public LocalDate getConsultDate() {
        return consultDate;
    }

    public void setConsultDate(LocalDate consultDate) {
        this.consultDate = consultDate;
    }

    public String getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(String appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public String getKindPatient() {
        return kindPatient;
    }

    public void setKindPatient(String kindPatient) {
        this.kindPatient = kindPatient;
    }

    public Integer getProcedure1() {
        return procedure1;
    }

    public void setProcedure1(Integer procedure1) {
        this.procedure1 = procedure1;
    }

    public Integer getProcedure2() {
        return procedure2;
    }

    public void setProcedure2(Integer procedure2) {
        this.procedure2 = procedure2;
    }

    public String getProtectorName() {
        return protectorName;
    }

    public void setProtectorName(String protectorName) {
        this.protectorName = protectorName;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
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

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
