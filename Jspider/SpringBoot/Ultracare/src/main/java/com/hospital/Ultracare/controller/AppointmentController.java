package com.hospital.Ultracare.controller;

import com.hospital.Ultracare.dto.ResponseStructure;
import com.hospital.Ultracare.model.AppointmentModel;
import com.hospital.Ultracare.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.hospital.Ultracare.enums.Status;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/ultracare/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<ResponseStructure<AppointmentModel>> bookAppointment(@RequestBody AppointmentModel appointment){
        return appointmentService.bookAppointment(appointment);
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseStructure<List<AppointmentModel>>> fetchAllAppointment(){
        return appointmentService.fetchAllAppointment();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ResponseStructure<AppointmentModel>> fetchAppointmentById(@PathVariable Long id){
        return appointmentService.fetchAppointmentById(id);
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<ResponseStructure<List<AppointmentModel>>> fetchAppointmentByDate(@PathVariable LocalDate date){
        return appointmentService.fetchAppointmentByDate(date);
    }

    @GetMapping("/doctor/{id}")
    public ResponseEntity<ResponseStructure<List<AppointmentModel>>> fetchAppointmentByDoctor(@PathVariable Long id){
        return appointmentService.fetchAppointmentByDoctor(id);
    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<ResponseStructure<List<AppointmentModel>>> fetchAppointmentByPatient(@PathVariable Long id){
        return appointmentService.fetchAppointmentByPatient(id);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<ResponseStructure<List<AppointmentModel>>> fetchAppointmentByStatus(@PathVariable Status status){
        return appointmentService.fetchAppointmentByStatus(status);
    }

    @DeleteMapping("/cancel/{id}")
    public ResponseEntity<ResponseStructure<String>> cancelAppointment(@PathVariable Long id){
        return appointmentService.cancelAppointment(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseStructure<AppointmentModel>> updateAppointment(@PathVariable Long id){
        return appointmentService.updateAppointment(id);
    }



}
