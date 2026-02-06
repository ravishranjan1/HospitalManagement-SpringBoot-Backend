package com.hospital.Ultracare.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "report")
public class MedicalReportModel extends BaseModel{

    private String diagnosis;
    private String treatment;
    private LocalDate visitDate;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private DoctorModel doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private PatientModel patient;

    @OneToOne(mappedBy = "report", cascade = CascadeType.ALL)
    @JsonIgnore
    private PrescriptionModel prescription;

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(LocalDate visitDate) {
        this.visitDate = visitDate;
    }

    public DoctorModel getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorModel doctor) {
        this.doctor = doctor;
    }

    public PatientModel getPatient() {
        return patient;
    }

    public void setPatient(PatientModel patient) {
        this.patient = patient;
    }

    public PrescriptionModel getPrescription() {
        return prescription;
    }

    public void setPrescription(PrescriptionModel prescription) {
        this.prescription = prescription;
    }
}
