package com.hospital.Ultracare.controller;

import com.hospital.Ultracare.dto.ResponseStructure;
import com.hospital.Ultracare.model.PrescriptionModel;
import com.hospital.Ultracare.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ultracare/prescription")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @PostMapping
    public ResponseEntity<ResponseStructure<PrescriptionModel>> createPrescription(@RequestBody PrescriptionModel prescription){
        return prescriptionService.createPrescription(prescription);
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseStructure<List<PrescriptionModel>>> fetchAllPrescription(){
        return prescriptionService.fetchAllPrescription();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ResponseStructure<PrescriptionModel>> fetchPrescriptionById(@PathVariable Long id){
        return prescriptionService.fetchPrescriptionById(id);
    }

    @GetMapping("/report/{id}")
    public ResponseEntity<ResponseStructure<PrescriptionModel>> fetchPrescriptionByReport(@PathVariable Long id){
        return prescriptionService.fetchPrescriptionByReport(id);
    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<ResponseStructure<List<PrescriptionModel>>> fetchPrescriptionByPatient(@PathVariable Long id){
        return prescriptionService.fetchPrescriptionByPatient(id);
    }
}
