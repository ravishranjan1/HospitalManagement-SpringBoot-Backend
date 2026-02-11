package com.hospital.Ultracare.dao;

import com.hospital.Ultracare.exception.IdNotFoundException;
import com.hospital.Ultracare.exception.NoDataFoundException;
import com.hospital.Ultracare.model.MedicalReportModel;
import com.hospital.Ultracare.model.PatientModel;
import com.hospital.Ultracare.model.PrescriptionModel;
import com.hospital.Ultracare.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PrescriptionDao {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Autowired
    private ReportDao reportDao;

    @Autowired
    private PatientDao patientDao;

    public PrescriptionModel createPrescription(PrescriptionModel prescription){
        if (prescription.getReport() == null ||
                prescription.getReport().getId() == null) {
            throw new RuntimeException("Medical report is required");
        }
        MedicalReportModel report = reportDao.fetchReportById(prescription.getReport().getId());
        if (prescriptionRepository.existsByReport(report)) {
            throw new RuntimeException(
                    "Prescription already exists for this medical report");
        }
        if (prescription.getMedicine() == null ||
                prescription.getMedicine().isBlank()) {
            throw new RuntimeException("Medicine is required");
        }
        if (prescription.getDosage() == null ||
                prescription.getDosage().isBlank()) {
            throw new RuntimeException("Dosage is required");
        }
        if (prescription.getInstruction() == null ||
                prescription.getInstruction().isBlank()) {
            throw new RuntimeException("Instruction is required");
        }
        prescription.setReport(report);
        return prescriptionRepository.save(prescription);
    }

    public List<PrescriptionModel> fetchAllPrescription(){
        List<PrescriptionModel> prescriptions = prescriptionRepository.findAll();
        if(!prescriptions.isEmpty())
            return prescriptions;
        else
            throw new NoDataFoundException("No Prescription found in db");
    }

    public PrescriptionModel fetchPrescriptionById(Long id){
        Optional<PrescriptionModel> opt = prescriptionRepository.findById(id);
        if(opt.isPresent())
            return opt.get();
        else
            throw new IdNotFoundException("Id Not found in DB");
    }

    public PrescriptionModel fetchPrescriptionByReport(Long id){
        MedicalReportModel report = reportDao.fetchReportById(id);
        Optional<PrescriptionModel> opt = prescriptionRepository.findByReport(report);
        if(opt.isPresent())
            return opt.get();
        else
            throw new NoDataFoundException("No Prescription is found for this report");
    }

    public List<PrescriptionModel> fetchByPrescriptionByPatient(Long id){
        PatientModel patient = patientDao.fetchPatientById(id);
        List<PrescriptionModel> prescriptions = prescriptionRepository.findByReport_Patient(patient);
        if(!prescriptions.isEmpty())
            return prescriptions;
        else
            throw new NoDataFoundException("No Prescription is found for this patient");
    }
}
