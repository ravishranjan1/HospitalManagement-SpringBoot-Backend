package com.hospital.Ultracare.service;

import com.hospital.Ultracare.dao.DepartmentDao;
import com.hospital.Ultracare.dto.ResponseStructure;
import com.hospital.Ultracare.model.DepartmentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    public ResponseEntity<ResponseStructure<DepartmentModel>> createDepartment(DepartmentModel department){
        ResponseStructure<DepartmentModel> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Department is created");
        response.setData(departmentDao.createDepartment(department));
        return new ResponseEntity<ResponseStructure<DepartmentModel>>(response, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<List<DepartmentModel>>> fetchAllDepartment(){
        ResponseStructure<List<DepartmentModel>> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Department is found");
        response.setData(departmentDao.fetchAllDepartment());
        return new ResponseEntity<ResponseStructure<List<DepartmentModel>>>(response, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<DepartmentModel>> fetchDepartmentById(Long id){
        ResponseStructure<DepartmentModel> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Department is found");
        response.setData(departmentDao.fetchDepartmentById(id));
        return new ResponseEntity<ResponseStructure<DepartmentModel>>(response, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<DepartmentModel>> updateDepartment(DepartmentModel department){
        ResponseStructure<DepartmentModel> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Department is updated");
        response.setData(departmentDao.updateDepartment(department));
        return new ResponseEntity<ResponseStructure<DepartmentModel>>(response, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<String>> deleteDepartment(Long id){
        ResponseStructure<String> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Department is updated");
        response.setData(departmentDao.deleteDepartment(id));
        return new ResponseEntity<ResponseStructure<String>>(response, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<DepartmentModel>> fetchDepartmentByDepartmentName(String name){
        ResponseStructure<DepartmentModel> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Department is found");
        response.setData(departmentDao.fetchDepartmentByDepartmentName(name));
        return new ResponseEntity<ResponseStructure<DepartmentModel>>(response, HttpStatus.OK);
    }

}
