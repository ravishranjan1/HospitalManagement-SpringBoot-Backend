package com.hospital.Ultracare.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "doctor")
public class DoctorModel extends BaseModel{

    private String doctorName;
    private String specialization;
    private List<String> availableDays;

    @ManyToOne
    private DepartmentModel department;

    @JsonIgnore
    @OneToMany
    private List<AppointmentModel> appointment;

    @JsonIgnore
    @OneToMany
    private List<MedicalReportModel> reports;

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public List<String> getAvailableDays() {
        return availableDays;
    }

    public void setAvailableDays(List<String> availableDays) {
        this.availableDays = availableDays;
    }

    public DepartmentModel getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentModel department) {
        this.department = department;
    }

    public List<AppointmentModel> getAppointment() {
        return appointment;
    }

    public void setAppointment(List<AppointmentModel> appointment) {
        this.appointment = appointment;
    }

    public List<MedicalReportModel> getReports() {
        return reports;
    }

    public void setReports(List<MedicalReportModel> reports) {
        this.reports = reports;
    }
}
