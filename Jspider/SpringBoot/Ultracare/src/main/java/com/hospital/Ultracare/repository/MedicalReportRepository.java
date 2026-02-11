package com.hospital.Ultracare.repository;

import com.hospital.Ultracare.model.DoctorModel;
import com.hospital.Ultracare.model.MedicalReportModel;
import com.hospital.Ultracare.model.PatientModel;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface MedicalReportRepository extends JpaRepository<MedicalReportModel, Long> {
    List<MedicalReportModel> findByPatient(PatientModel patient);
    List<MedicalReportModel> findByDoctor(DoctorModel doctor);
    Optional<MedicalReportModel> findByDoctorAndPatientAndVisitDate(DoctorModel doctor, PatientModel patient, LocalDate visitDate);
    List<MedicalReportModel> findByVisitDate(LocalDate visitDate);
}
