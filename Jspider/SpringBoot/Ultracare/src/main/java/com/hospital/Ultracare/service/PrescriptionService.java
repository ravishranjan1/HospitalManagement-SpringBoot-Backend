package com.hospital.Ultracare.service;

import com.hospital.Ultracare.dao.PrescriptionDao;
import com.hospital.Ultracare.dto.ResponseStructure;
import com.hospital.Ultracare.model.PrescriptionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionService {

    @Autowired
    private PrescriptionDao prescriptionDao;

    public ResponseEntity<ResponseStructure<PrescriptionModel>> createPrescription (PrescriptionModel prescription){
        ResponseStructure<PrescriptionModel> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Prescription is created");
        response.setData(prescriptionDao.createPrescription(prescription));
        return new ResponseEntity<ResponseStructure<PrescriptionModel>>(response, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<List<PrescriptionModel>>> fetchAllPrescription (){
        ResponseStructure<List<PrescriptionModel>> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Prescription is found");
        response.setData(prescriptionDao.fetchAllPrescription());
        return new ResponseEntity<ResponseStructure<List<PrescriptionModel>>>(response, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<PrescriptionModel>> fetchPrescriptionById (Long id){
        ResponseStructure<PrescriptionModel> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Prescription is found");
        response.setData(prescriptionDao.fetchPrescriptionById(id));
        return new ResponseEntity<ResponseStructure<PrescriptionModel>>(response, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<PrescriptionModel>> fetchPrescriptionByReport (Long id){
        ResponseStructure<PrescriptionModel> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Prescription is found");
        response.setData(prescriptionDao.fetchPrescriptionByReport(id));
        return new ResponseEntity<ResponseStructure<PrescriptionModel>>(response, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<List<PrescriptionModel>>> fetchPrescriptionByPatient (Long id){
        ResponseStructure<List<PrescriptionModel>> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Prescription is found");
        response.setData(prescriptionDao.fetchByPrescriptionByPatient(id));
        return new ResponseEntity<ResponseStructure<List<PrescriptionModel>>>(response, HttpStatus.OK);
    }
}
