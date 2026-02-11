package com.hospital.Ultracare.dao;

import com.hospital.Ultracare.enums.Status;
import com.hospital.Ultracare.exception.DoctorNotAvailableException;
import com.hospital.Ultracare.exception.IdNotFoundException;
import com.hospital.Ultracare.exception.NoDataFoundException;
import com.hospital.Ultracare.exception.PatientAlreadyHasAppointmentException;
import com.hospital.Ultracare.model.AppointmentModel;
import com.hospital.Ultracare.model.DoctorModel;
import com.hospital.Ultracare.model.PatientModel;
import com.hospital.Ultracare.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class AppointmentDao {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorDao doctorDao;

    @Autowired
    private PatientDao patientDao;

    public AppointmentModel bookAppointment(AppointmentModel appointment){
        DoctorModel doctor = doctorDao.fetchDoctorById(appointment.getDoctor().getId());
        PatientModel patient = patientDao.fetchPatientById(appointment.getPatient().getId());

        boolean isDoctorBusy = appointmentRepository.existsByDoctorAndAppointmentDateTime(doctor, appointment.getAppointmentDateTime());
        if(isDoctorBusy)
            throw new DoctorNotAvailableException("Doctor already has an appointment at this time");
        LocalDate date = appointment.getAppointmentDateTime().toLocalDate();
        LocalDateTime startOfDay = date.atStartOfDay();
        LocalDateTime endOfDay = date.atTime(23,59,59);
        boolean patientHasAppointment = appointmentRepository.existsByPatientAndAppointmentDateTimeBetween(patient, startOfDay, endOfDay);
        if(patientHasAppointment)
            throw new PatientAlreadyHasAppointmentException("Patient already has an appointment on this day");

        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setStatus(Status.BOOKED);
        return appointmentRepository.save(appointment);
    }

    public List<AppointmentModel> fetchAllAppointment(){
        List<AppointmentModel> appointments = appointmentRepository.findAll();
        if(!appointments.isEmpty())
            return appointments;
        else
            throw new NoDataFoundException("No Appointment is Booked yet");
    }

    public AppointmentModel fetchAppointmentById(Long id){
        Optional<AppointmentModel> opt = appointmentRepository.findById(id);
        if(opt.isPresent())
            return opt.get();
        else
            throw new IdNotFoundException("No Appointment is found with id : "+id);
    }

    public List<AppointmentModel> fetchAppointmentByDate(LocalDate date){
        LocalDateTime startOfDay = date.atStartOfDay();
        LocalDateTime endOfDay = date.atTime(23, 59, 59);

        List<AppointmentModel> appointments = appointmentRepository.findByAppointmentDateTimeBetween(startOfDay, endOfDay);
        if(!appointments.isEmpty())
            return appointments;
        else
            throw new NoDataFoundException("No Appointment date : "+date);
    }

    public List<AppointmentModel> fetchAppointmentByDoctor(Long id){
        DoctorModel doctor = doctorDao.fetchDoctorById(id);
        List<AppointmentModel> appointments = appointmentRepository.findByDoctor(doctor);
        if(!appointments.isEmpty())
            return appointments;
        else
            throw new NoDataFoundException("No Appointment for Doctor");
    }

    public List<AppointmentModel> fetchAppointmentByPatient(Long id){
        PatientModel patient = patientDao.fetchPatientById(id);
        List<AppointmentModel> appointments = appointmentRepository.findByPatient(patient);
        if(!appointments.isEmpty())
            return appointments;
        else
            throw new NoDataFoundException("No Appointment for Patient");
    }

    public List<AppointmentModel> fetchAppointmentByStatus(Status status){
        List<AppointmentModel> appointments = appointmentRepository.findByStatus(status);
        if(!appointments.isEmpty())
            return appointments;
        else
            throw new NoDataFoundException("No Appointment for Status");
    }


    public String cancelAppointment(Long id){
        AppointmentModel appointment = fetchAppointmentById(id);
        if (appointment.getStatus() != Status.BOOKED)
            throw new RuntimeException("Appointment on cancel for booked status");
        appointmentRepository.delete(appointment);
        return "success";
    }

    public AppointmentModel updateAppointment(Long id){
        AppointmentModel appointment = fetchAppointmentById(id);
        appointment.setStatus(Status.COMPLETED);
        return appointmentRepository.save(appointment);
    }

    public AppointmentModel fetchByAppointmentForMedicalReport(DoctorModel doctor, PatientModel patient, LocalDateTime start, LocalDateTime end){
        Optional<AppointmentModel> opt = appointmentRepository.findByDoctorAndPatientAndAppointmentDateTimeBetween(doctor, patient, start, end);
        if(opt.isPresent())
            return opt.get();
        else
            throw new NoDataFoundException("No Appointment is found with this doctor and patient on this day ");
    }

    public List<DoctorModel> fetchDoctorByPatient (PatientModel patient){
        List<DoctorModel> doctors = appointmentRepository.findDoctorByPatient(patient);
        if(!doctors.isEmpty())
            return doctors;
        else
            throw new NoDataFoundException("No Doctor is found for this doctor");
    }



}
