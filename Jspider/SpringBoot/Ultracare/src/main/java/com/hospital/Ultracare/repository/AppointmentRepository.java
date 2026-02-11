package com.hospital.Ultracare.repository;

import com.hospital.Ultracare.enums.Status;
import com.hospital.Ultracare.model.AppointmentModel;
import com.hospital.Ultracare.model.DoctorModel;
import com.hospital.Ultracare.model.PatientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentModel, Long> {

    List<AppointmentModel> findByAppointmentDateTimeBetween(LocalDateTime start, LocalDateTime end);
    List<AppointmentModel> findByDoctor(DoctorModel doctor);
    List<AppointmentModel> findByPatient(PatientModel patient);

    boolean existsByDoctorAndAppointmentDateTime(DoctorModel doctor, LocalDateTime appointmentDateTime);

    boolean existsByPatientAndAppointmentDateTimeBetween(PatientModel patient, LocalDateTime start, LocalDateTime end);

    List<AppointmentModel> findByStatus(Status status);

    Optional<AppointmentModel> findByDoctorAndPatientAndAppointmentDateTimeBetween( DoctorModel doctor, PatientModel patient, LocalDateTime start, LocalDateTime end);

    @Query("SELECT DISTINCT a.doctor FROM AppointmentModel a WHERE a.patient = :patient")
    List<DoctorModel> findDoctorByPatient(@Param("patient") PatientModel patient);
}
