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
    private Integer patientKind;

    @Column(name = "nome_protetor")
    private String protectorName;

    @OneToOne
    @JoinColumn(name = "id_tutor")
    private Tutor tutorId;

    @OneToOne
    @JoinColumn(name = "id_animal")
    private Animal animalId;

    @Column(name = "exam1")
    private String exam1;

    @Column(name = "exam2")
    private String exam2;

    @Column(name = "exam3")
    private String exam3;

    @Column(name = "id_clinica")
    private Integer clinic;

    public Encaminhamento() {
    }

    public Encaminhamento(Integer id, LocalDate consultDate, Integer solicitCode, Integer patientKind, String protectorName, Tutor tutorId, Animal animalId, String exam1, String exam2, String exam3, Integer clinic) {
        this.id = id;
        this.consultDate = consultDate;
        this.solicitCode = solicitCode;
        this.patientKind = patientKind;
        this.protectorName = protectorName;
        this.tutorId = tutorId;
        this.animalId = animalId;
        this.exam1 = exam1;
        this.exam2 = exam2;
        this.exam3 = exam3;
        this.clinic = clinic;
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

    public Integer getPatientKind() {
        return patientKind;
    }

    public void setPatientKind(Integer patientKind) {
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

    public Animal getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Animal animalId) {
        this.animalId = animalId;
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

    public Integer getClinic() {
        return clinic;
    }

    public void setClinic(Integer clinic) {
        this.clinic = clinic;
    }
}
