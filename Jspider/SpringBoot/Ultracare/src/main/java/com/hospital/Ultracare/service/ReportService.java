package com.hospital.Ultracare.service;

import com.hospital.Ultracare.dao.ReportDao;
import com.hospital.Ultracare.dto.ResponseStructure;
import com.hospital.Ultracare.model.MedicalReportModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    private ReportDao reportDao;

    public ResponseEntity<ResponseStructure<MedicalReportModel>> createReport(MedicalReportModel report){
        ResponseStructure<MedicalReportModel> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Record is created");
        response.setData(reportDao.createRecord(report));
        return new ResponseEntity<ResponseStructure<MedicalReportModel>>(response, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<List<MedicalReportModel>>> fetchAllReport(){
        ResponseStructure<List<MedicalReportModel>> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Record is found");
        response.setData(reportDao.fetchAllReport());
        return new ResponseEntity<ResponseStructure<List<MedicalReportModel>>>(response, HttpStatus.OK);
    }


    public ResponseEntity<ResponseStructure<MedicalReportModel>> fetchReportById(Long id){
        ResponseStructure<MedicalReportModel> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Record is found");
        response.setData(reportDao.fetchReportById(id));
        return new ResponseEntity<ResponseStructure<MedicalReportModel>>(response, HttpStatus.OK);
    }


        public ResponseEntity<ResponseStructure<List<MedicalReportModel>>> fetchReportByPatient(Long id){
        ResponseStructure<List<MedicalReportModel>> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Record is found");
        response.setData(reportDao.fetchReportByPatient(id));
        return new ResponseEntity<ResponseStructure<List<MedicalReportModel>>>(response, HttpStatus.OK);
      }


    public ResponseEntity<ResponseStructure<List<MedicalReportModel>>> fetchReportByDoctor(Long id){
        ResponseStructure<List<MedicalReportModel>> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Record is found");
        response.setData(reportDao.fetchReportByDoctor(id));
        return new ResponseEntity<ResponseStructure<List<MedicalReportModel>>>(response, HttpStatus.OK);
    }
}
