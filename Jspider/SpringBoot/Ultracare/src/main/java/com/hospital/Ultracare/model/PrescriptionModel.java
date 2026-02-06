package com.hospital.Ultracare.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "prescription")
public class PrescriptionModel extends BaseModel{

    private String medicine;
    private String dosage;
    private String instruction;

    @OneToOne
    private MedicalReportModel report;

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public MedicalReportModel getReport() {
        return report;
    }

    public void setReport(MedicalReportModel report) {
        this.report = report;
    }
}
