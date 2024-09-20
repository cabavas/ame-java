package com.example.ame.model.dto;

import com.example.ame.model.Animal;
import com.example.ame.model.Clinica;

import java.time.LocalDate;

public class CastracaoDTO {
    private Integer id;
    private Clinica clinica;
    private LocalDate consultDate;
    private Integer kindPatient;
    private String protectorName;
    private String protocol;
    private Integer solicitCode;
    private LocalDate surgeryDate;
    private String surgeryStatus;
    private Integer vetId;
    private Animal animal;

    public CastracaoDTO() {
    }

    public CastracaoDTO(Clinica clinica, LocalDate consultDate, Integer kindPatient, String protectorName, String protocol, Integer solicitCode, LocalDate surgeryDate, String surgeryStatus, Integer vetId, Animal animalId) {
        this.clinica = clinica;
        this.consultDate = consultDate;
        this.kindPatient = kindPatient;
        this.protectorName = protectorName;
        this.protocol = protocol;
        this.solicitCode = solicitCode;
        this.surgeryDate = surgeryDate;
        this.surgeryStatus = surgeryStatus;
        this.vetId = vetId;
        this.animal = animalId;
    }

    public Integer getId() {
        return id;
    }

    public Clinica getClinica() {
        return clinica;
    }

    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }

    public LocalDate getConsultDate() {
        return consultDate;
    }

    public void setConsultDate(LocalDate consultDate) {
        this.consultDate = consultDate;
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

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public Integer getSolicitCode() {
        return solicitCode;
    }

    public void setSolicitCode(Integer solicitCode) {
        this.solicitCode = solicitCode;
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

    public Integer getVetId() {
        return vetId;
    }

    public void setVetId(Integer vetId) {
        this.vetId = vetId;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
