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

}
