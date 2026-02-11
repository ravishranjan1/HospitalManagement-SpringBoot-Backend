package com.hospital.Ultracare.repository;

import com.hospital.Ultracare.model.MedicalReportModel;
import com.hospital.Ultracare.model.PatientModel;
import com.hospital.Ultracare.model.PrescriptionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PrescriptionRepository extends JpaRepository<PrescriptionModel, Long> {

    boolean existsByReport(MedicalReportModel report);
    Optional<PrescriptionModel> findByReport(MedicalReportModel report);
    List<PrescriptionModel> findByReport_Patient(PatientModel patient);
}
