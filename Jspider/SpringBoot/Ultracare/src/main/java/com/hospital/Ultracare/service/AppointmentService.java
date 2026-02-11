package com.hospital.Ultracare.service;

import com.hospital.Ultracare.dao.AppointmentDao;
import com.hospital.Ultracare.dto.ResponseStructure;
import com.hospital.Ultracare.enums.Status;
import com.hospital.Ultracare.model.AppointmentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentDao appointmentDao;

    public ResponseEntity<ResponseStructure<AppointmentModel>> bookAppointment(AppointmentModel appointment){
        ResponseStructure<AppointmentModel> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Appointment is booked");
        response.setData(appointmentDao.bookAppointment(appointment));
        return new ResponseEntity<ResponseStructure<AppointmentModel>>(response, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<List<AppointmentModel>>> fetchAllAppointment(){
        ResponseStructure<List<AppointmentModel>> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Appointment is found");
        response.setData(appointmentDao.fetchAllAppointment());
        return new ResponseEntity<ResponseStructure<List<AppointmentModel>>>(response, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<AppointmentModel>> fetchAppointmentById(Long id){
        ResponseStructure<AppointmentModel> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Appointment is found");
        response.setData(appointmentDao.fetchAppointmentById(id));
        return new ResponseEntity<ResponseStructure<AppointmentModel>>(response, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<List<AppointmentModel>>> fetchAppointmentByDate(LocalDate date){
        ResponseStructure<List<AppointmentModel>> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Appointment is found");
        response.setData(appointmentDao.fetchAppointmentByDate(date));
        return new ResponseEntity<ResponseStructure<List<AppointmentModel>>>(response, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<List<AppointmentModel>>> fetchAppointmentByDoctor(Long id){
        ResponseStructure<List<AppointmentModel>> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Appointment is found");
        response.setData(appointmentDao.fetchAppointmentByDoctor(id));
        return new ResponseEntity<ResponseStructure<List<AppointmentModel>>>(response, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<List<AppointmentModel>>> fetchAppointmentByPatient(Long id){
        ResponseStructure<List<AppointmentModel>> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Appointment is found");
        response.setData(appointmentDao.fetchAppointmentByPatient(id));
        return new ResponseEntity<ResponseStructure<List<AppointmentModel>>>(response, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<List<AppointmentModel>>> fetchAppointmentByStatus(Status status){
        ResponseStructure<List<AppointmentModel>> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Appointment is found");
        response.setData(appointmentDao.fetchAppointmentByStatus(status));
        return new ResponseEntity<ResponseStructure<List<AppointmentModel>>>(response, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<String>> cancelAppointment(Long id){
        ResponseStructure<String> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Appointment is Cancelled");
        response.setData(appointmentDao.cancelAppointment(id));
        return new ResponseEntity<ResponseStructure<String>>(response, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<AppointmentModel>> updateAppointment(Long id){
        ResponseStructure<AppointmentModel> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Appointment is updated");
        response.setData(appointmentDao.updateAppointment(id));
        return new ResponseEntity<ResponseStructure<AppointmentModel>>(response, HttpStatus.OK);
    }
}
