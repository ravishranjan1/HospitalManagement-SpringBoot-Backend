package com.hospital.Ultracare.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hospital.Ultracare.enums.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "patient")
public class PatientModel extends BaseModel{

    private String patientName;
    private Integer age;
    private Gender gender;

    @Column(unique = true)
    private Long phone;

    @Column(unique = true)
    private String email;

    @JsonIgnore
    @OneToMany
    List<AppointmentModel> appointments;

    @JsonIgnore
    @OneToMany
    List<MedicalReportModel> reports;

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<AppointmentModel> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<AppointmentModel> appointments) {
        this.appointments = appointments;
    }

    public List<MedicalReportModel> getReports() {
        return reports;
    }

    public void setReports(List<MedicalReportModel> reports) {
        this.reports = reports;
    }
}
