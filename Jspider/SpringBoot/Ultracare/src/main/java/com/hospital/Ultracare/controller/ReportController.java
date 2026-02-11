package com.hospital.Ultracare.controller;

import com.hospital.Ultracare.dto.ResponseStructure;
import com.hospital.Ultracare.model.MedicalReportModel;
import com.hospital.Ultracare.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/ultracare/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @PostMapping
    public ResponseEntity<ResponseStructure<MedicalReportModel>> createReport(@RequestBody MedicalReportModel report){
        return reportService.createReport(report);
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseStructure<List<MedicalReportModel>>> fetchAllReport(){
        return reportService.fetchAllReport();
    }


    @GetMapping("/id/{id}")
    public ResponseEntity<ResponseStructure<MedicalReportModel>> fetchReportById(@PathVariable Long id){
        return reportService.fetchReportById(id);
    }


    @GetMapping("/patient/{id}")
    public ResponseEntity<ResponseStructure<List<MedicalReportModel>>> fetchReportByPatient(@PathVariable Long id){
        return reportService.fetchReportByPatient(id);
    }


    @GetMapping("/doctor/{id}")
    public ResponseEntity<ResponseStructure<List<MedicalReportModel>>> fetchReportByDoctor(@PathVariable Long id){
        return reportService.fetchReportByDoctor(id);
    }

    @GetMapping("/appointment/{id}")
    public ResponseEntity<ResponseStructure<MedicalReportModel>> fetchReportByAppointment(@PathVariable Long id){
        return reportService.fetchReportByAppointment(id);
    }

    @GetMapping("/visitDate/{date}")
    public ResponseEntity<ResponseStructure<List<MedicalReportModel>>> fetchReportByVisitDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        return reportService.fetchReportByVisitDate(date);
    }
}
