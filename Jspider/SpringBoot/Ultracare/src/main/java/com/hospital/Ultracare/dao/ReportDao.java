package com.hospital.Ultracare.dao;

import com.hospital.Ultracare.enums.Status;
import com.hospital.Ultracare.exception.AppointmentNotCompletedException;
import com.hospital.Ultracare.exception.IdNotFoundException;
import com.hospital.Ultracare.exception.NoDataFoundException;
import com.hospital.Ultracare.model.AppointmentModel;
import com.hospital.Ultracare.model.DoctorModel;
import com.hospital.Ultracare.model.MedicalReportModel;
import com.hospital.Ultracare.model.PatientModel;
import com.hospital.Ultracare.repository.MedicalReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReportDao {

    @Autowired
    private AppointmentDao appointmentDao;

    @Autowired
    private DoctorDao doctorDao;

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private MedicalReportRepository reportRepository;

    public MedicalReportModel createRecord(MedicalReportModel report){
        if (report == null)
            throw new RuntimeException("Request body cannot be null");
        if (report.getDiagnosis() == null || report.getDiagnosis().trim().isEmpty())
            throw new RuntimeException("Diagnosis is required");
        if (report.getTreatment() == null || report.getTreatment().trim().isEmpty())
            throw new RuntimeException("Treatment is required");
        if (report.getVisitDate() == null)
            throw new RuntimeException("Visit date is required");
        if (report.getDoctor() == null || report.getDoctor().getId() == null)
            throw new RuntimeException("Doctor or doctorId  is required");
        if (report.getPatient() == null || report.getPatient().getId() == null)
            throw new RuntimeException("Patient or patientId is required");
        DoctorModel doctor = doctorDao.fetchDoctorById(report.getDoctor().getId());
        PatientModel patient = patientDao.fetchPatientById(report.getPatient().getId());

        LocalDateTime startOfDay = report.getVisitDate().atStartOfDay();
        LocalDateTime endOfDay = report.getVisitDate().atTime(23,59,59);

        AppointmentModel appointment = appointmentDao.fetchByAppointmentForMedicalReport(doctor, patient, startOfDay, endOfDay);

        if(appointment.getStatus() != Status.COMPLETED)
            throw new AppointmentNotCompletedException("Medical record can be created only after appointment completion");
        report.setDoctor(doctor);
        report.setPatient(patient);
        return reportRepository.save(report);
    }

    public List<MedicalReportModel> fetchAllReport(){
        List<MedicalReportModel> reports = reportRepository.findAll();
        if(!reports.isEmpty())
            return reports;
        else
            throw new NoDataFoundException("No report is found is DB");
    }

    public MedicalReportModel fetchReportById(Long id){
        Optional<MedicalReportModel> opt = reportRepository.findById(id);
        if(opt.isPresent())
            return opt.get();
        else
            throw new IdNotFoundException("Id not Match in DB");
    }

    public List<MedicalReportModel> fetchReportByPatient(Long id){
        PatientModel patient = patientDao.fetchPatientById(id);
        List<MedicalReportModel> reports = reportRepository.findByPatient(patient);
        if(!reports.isEmpty())
            return reports;
        else
            throw new NoDataFoundException("No report is found is DB");
    }


    public List<MedicalReportModel> fetchReportByDoctor(Long id){
        DoctorModel doctor = doctorDao.fetchDoctorById(id);
        List<MedicalReportModel> reports = reportRepository.findByDoctor(doctor);
        if(!reports.isEmpty())
            return reports;
        else
            throw new NoDataFoundException("No report is found is DB");
    }

    public MedicalReportModel fetchReportByAppointment(Long id){
        AppointmentModel appointment = appointmentDao.fetchAppointmentById(id);
        DoctorModel doctor = appointment.getDoctor();
        PatientModel patient = appointment.getPatient();
        LocalDate visitDate = appointment.getAppointmentDateTime().toLocalDate();
        Optional<MedicalReportModel> opt =  reportRepository.findByDoctorAndPatientAndVisitDate(doctor, patient, visitDate);
        if(opt.isPresent())
            return opt.get();
        else
            throw new NoDataFoundException("No Report is found for appointment");
    }

    public List<MedicalReportModel> fetchReportByVisitDate(LocalDate visitDate){
        List<MedicalReportModel> reports = reportRepository.findByVisitDate(visitDate);
        if(!reports.isEmpty())
            return reports;
        else
            throw new NoDataFoundException("No reports found for given date");
    }

}
