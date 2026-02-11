package com.hospital.Ultracare.controller;

import com.hospital.Ultracare.dto.ResponseStructure;
import com.hospital.Ultracare.model.PatientModel;
import com.hospital.Ultracare.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ultracare/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<ResponseStructure<PatientModel>> registerPatient(@RequestBody PatientModel patient){
        return patientService.registerPatient(patient);
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseStructure<List<PatientModel>>> fetchAll(){
        return patientService.fetchAllPatient();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ResponseStructure<PatientModel>> fetchPatientById(@PathVariable Long id){
        return patientService.fetchPatientById(id);
    }

    @GetMapping("/phone/{phone}")
    public ResponseEntity<ResponseStructure<PatientModel>> fetchPatientByPhone(@PathVariable Long phone){
        return patientService.fetchPatientByPhone(phone);
    }

    @GetMapping("/age/{age}")
    public ResponseEntity<ResponseStructure<List<PatientModel>>> fetchPatientByAgeGreaterThan(@PathVariable Integer age){
        return patientService.fetchPatientByAgeGreaterThan(age);
    }

    @PutMapping
    public ResponseEntity<ResponseStructure<PatientModel>> updatePatient(@RequestBody PatientModel patient){
        return patientService.updatePatient(patient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseStructure<String>> deletePatient(@PathVariable Long id){
        return patientService.deletePatient(id);
    }

    @GetMapping("/appointment/{id}")
    public ResponseEntity<ResponseStructure<PatientModel>> fetchPatientByAppointment(@PathVariable Long id){
        return patientService.fetchPatientByAppointment(id);
    }

    @GetMapping("/report/{id}")
    public ResponseEntity<ResponseStructure<PatientModel>> fetchPatientByReport(@PathVariable Long id){
        return patientService.fetchPatientByReport(id);
    }
}
