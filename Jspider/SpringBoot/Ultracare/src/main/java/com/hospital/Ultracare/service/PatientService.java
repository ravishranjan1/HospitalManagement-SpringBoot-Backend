package com.hospital.Ultracare.service;

import com.hospital.Ultracare.dao.PatientDao;
import com.hospital.Ultracare.dto.ResponseStructure;
import com.hospital.Ultracare.model.PatientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientDao patientDao;

    public ResponseEntity<ResponseStructure<PatientModel>> registerPatient(PatientModel patient){
        ResponseStructure<PatientModel> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Patient registered");
        response.setData(patientDao.registerPatient(patient));
        return new ResponseEntity<ResponseStructure<PatientModel>>(response, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<List<PatientModel>>> fetchAllPatient(){
        ResponseStructure<List<PatientModel>> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Patient found");
        response.setData(patientDao.fetchAll());
        return new ResponseEntity<ResponseStructure<List<PatientModel>>>(response, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<PatientModel>> fetchPatientById(Long id){
        ResponseStructure<PatientModel> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Patient found");
        response.setData(patientDao.fetchPatientById(id));
        return new ResponseEntity<ResponseStructure<PatientModel>>(response, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<PatientModel>> fetchPatientByPhone(Long phone){
        ResponseStructure<PatientModel> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Patient found");
        response.setData(patientDao.fetchPatientByPhone(phone));
        return new ResponseEntity<ResponseStructure<PatientModel>>(response, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<List<PatientModel>>> fetchPatientByAgeGreaterThan(Integer age){
        ResponseStructure<List<PatientModel>> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Patient found");
        response.setData(patientDao.fetchPatientByAgeGreaterThan(age));
        return new ResponseEntity<ResponseStructure<List<PatientModel>>>(response, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<PatientModel>> updatePatient(PatientModel patient){
        ResponseStructure<PatientModel> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Patient is updated");
        response.setData(patientDao.updatePatient(patient));
        return new ResponseEntity<ResponseStructure<PatientModel>>(response, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<String>> deletePatient (Long id){
        ResponseStructure<String> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Patient is deleted");
        response.setData(patientDao.deletePatient(id));
        return new ResponseEntity<ResponseStructure<String>>(response, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<PatientModel>> fetchPatientByAppointment(Long id){
        ResponseStructure<PatientModel> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Patient is found");
        response.setData(patientDao.fetchPatientByAppointment(id));
        return new ResponseEntity<ResponseStructure<PatientModel>>(response, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<PatientModel>> fetchPatientByReport(Long id){
        ResponseStructure<PatientModel> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Patient is found");
        response.setData(patientDao.fetchPatientByReport(id));
        return new ResponseEntity<ResponseStructure<PatientModel>>(response, HttpStatus.OK);
    }
}
