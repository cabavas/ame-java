package com.example.ame.model.dto;

import com.example.ame.model.Animal;

import java.io.Serializable;

public class AtendimentoDTO implements Serializable {

    private Integer consultType;
    private String consultDate;
    private String initialTime;
    private Integer kindPatient;
    private Integer solicitCode;
    private Animal animal;
    private String endTime;
    private String protocol;
    private Integer vetId;

    public AtendimentoDTO() {
    }

    public AtendimentoDTO(Integer consultType, String consultDate, String initialTime, Integer kindPatient, Integer solicitCode, Animal animal, String endTime, String protocol, Integer vetId) {
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

    public void setAnimal(Animal animal) {
        this.animal = animal;
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
