package com.hospital.Ultracare.service;

import com.hospital.Ultracare.dao.DoctorDao;
import com.hospital.Ultracare.dto.ResponseStructure;
import com.hospital.Ultracare.model.DepartmentModel;
import com.hospital.Ultracare.model.DoctorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorDao doctorDao;

    public ResponseEntity<ResponseStructure<DoctorModel>> addDoctor(DoctorModel doctor){
        ResponseStructure<DoctorModel> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Doctor is added");
        response.setData(doctorDao.addDoctor(doctor));
        return new ResponseEntity<ResponseStructure<DoctorModel>>(response, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<List<DoctorModel>>> getAllDoctor(){
        ResponseStructure<List<DoctorModel>> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Doctor is found");
        response.setData(doctorDao.getAllDoctor());
        return new ResponseEntity<ResponseStructure<List<DoctorModel>>>(response, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<DoctorModel>> fetchDoctorById(Long id){
        ResponseStructure<DoctorModel> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Doctor is found with id : "+id);
        response.setData(doctorDao.fetchDoctorById(id));
        return new ResponseEntity<ResponseStructure<DoctorModel>>(response, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<List<DoctorModel>>> fetchDoctorBySpecialization(String specialization){
        ResponseStructure<List<DoctorModel>> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Doctor is found with specialization : "+specialization);
        response.setData(doctorDao.fetchDoctorBySpecialization(specialization));
        return new ResponseEntity<ResponseStructure<List<DoctorModel>>>(response, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<List<DoctorModel>>> fetchDoctorByDepartment(String departmentName){
        ResponseStructure<List<DoctorModel>> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Doctor is found with department : "+departmentName);
        response.setData(doctorDao.fetchDoctorByDepartment(departmentName));
        return new ResponseEntity<ResponseStructure<List<DoctorModel>>>(response, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<DoctorModel>> updateDoctor(DoctorModel doctor){
        ResponseStructure<DoctorModel> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Doctor is updated.");
        response.setData(doctorDao.updateDoctor(doctor));
        return new ResponseEntity<ResponseStructure<DoctorModel>>(response, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<String>> deleteDoctor(Long id){
        ResponseStructure<String> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Doctor is deleted.");
        response.setData(doctorDao.deleteDoctor(id));
        return new ResponseEntity<ResponseStructure<String>>(response, HttpStatus.OK);
    }
}
