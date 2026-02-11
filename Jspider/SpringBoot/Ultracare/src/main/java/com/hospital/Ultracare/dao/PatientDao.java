package com.hospital.Ultracare.dao;

import com.hospital.Ultracare.exception.IdNotFoundException;
import com.hospital.Ultracare.exception.NoDataFoundException;
import com.hospital.Ultracare.model.AppointmentModel;
import com.hospital.Ultracare.model.MedicalReportModel;
import com.hospital.Ultracare.model.PatientModel;
import com.hospital.Ultracare.repository.AppointmentRepository;
import com.hospital.Ultracare.repository.MedicalReportRepository;
import com.hospital.Ultracare.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PatientDao {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private MedicalReportRepository reportRepository;

    public PatientModel registerPatient(PatientModel patient){
        if (patient == null)
            throw new RuntimeException("Request body cannot be null");
        if (patient.getPatientName() == null || patient.getPatientName().trim().isEmpty())
            throw new RuntimeException("Patient name cannot be null or empty");
        if (patient.getAge() == null)
            throw new RuntimeException("Age is required");
        if (patient.getGender() == null)
            throw new RuntimeException("Gender is required");
        if (patient.getPhone() == null)
            throw new RuntimeException("Phone number is required");
        if (patient.getEmail() == null || patient.getEmail().trim().isEmpty())
            throw new RuntimeException("Email is required");
        return patientRepository.save(patient);
    }

    public List<PatientModel> fetchAll(){
        List<PatientModel> patients = patientRepository.findAll();
        if(!patients.isEmpty())
            return patients;
        else
            throw new NoDataFoundException("Patients record is empty");
    }

    public PatientModel fetchPatientById(Long id){
        Optional<PatientModel> opt = patientRepository.findById(id);
        if(opt.isPresent())
            return opt.get();
        else
            throw new IdNotFoundException("No record is found with id : "+id);
    }

    public PatientModel fetchPatientByPhone(Long phone){
        PatientModel patient = patientRepository.findByPhone(phone);
        if(patient != null)
            return patient;
        else
            throw new NoDataFoundException("No Patient is found with phone : "+phone);
    }

    public List<PatientModel> fetchPatientByAgeGreaterThan(Integer age){
        List<PatientModel> patients = patientRepository.findByAgeGreaterThan(age);
        if(!patients.isEmpty())
            return patients;
        else
            throw new NoDataFoundException("No Patient is found whose age is greater than "+age);
    }

    public PatientModel updatePatient(PatientModel patient){
        if (patient == null)
            throw new RuntimeException("Request body cannot be null");
        if(patient.getId() == null)
            throw new IdNotFoundException("Id can not be null");
        if (patient.getPatientName() == null || patient.getPatientName().trim().isEmpty())
            throw new RuntimeException("Patient name cannot be null or empty");
        if (patient.getAge() == null)
            throw new RuntimeException("Age is required");
        if (patient.getGender() == null)
            throw new RuntimeException("Gender is required");
        if (patient.getPhone() == null)
            throw new RuntimeException("Phone number is required");
        if (patient.getEmail() == null || patient.getEmail().trim().isEmpty())
            throw new RuntimeException("Email is required");
        PatientModel OldPatient = fetchPatientById(patient.getId());
        return patientRepository.save(patient);
    }

    public String deletePatient(Long id){
        PatientModel patient = fetchPatientById(id);
        patientRepository.delete(patient);
        return "success";
    }

    public PatientModel fetchPatientByAppointment(Long id){
        Optional<AppointmentModel> opt = appointmentRepository.findById(id);
        if(opt.isPresent()){
            AppointmentModel appointment = opt.get();
            return appointment.getPatient();
        } else
            throw new IdNotFoundException("No Appointment is found for this id");

    }

    public PatientModel fetchPatientByReport(Long id){
        Optional<MedicalReportModel> opt = reportRepository.findById(id);
        if(opt.isPresent()){
            MedicalReportModel report = opt.get();
            return report.getPatient();
        }else
            throw new IdNotFoundException("No Report is found for this id");
    }
}
