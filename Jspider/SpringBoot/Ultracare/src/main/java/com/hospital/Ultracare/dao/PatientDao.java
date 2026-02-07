package com.hospital.Ultracare.dao;

import com.hospital.Ultracare.exception.IdNotFoundException;
import com.hospital.Ultracare.exception.NoDataFoundException;
import com.hospital.Ultracare.model.PatientModel;
import com.hospital.Ultracare.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PatientDao {

    @Autowired
    private PatientRepository patientRepository;

    public PatientModel registerPatient(PatientModel patient){
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
        if(patient.getId() == null)
            throw new IdNotFoundException("Id can not be null");
        PatientModel OldPatient = fetchPatientById(patient.getId());
        return patientRepository.save(patient);
    }

    public String deletePatient(Long id){
        PatientModel patient = fetchPatientById(id);
        patientRepository.delete(patient);
        return "success";
    }
}
