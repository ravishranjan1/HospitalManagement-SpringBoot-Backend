package com.hospital.Ultracare.controller;

import com.hospital.Ultracare.dto.ResponseStructure;
import com.hospital.Ultracare.model.DepartmentModel;
import com.hospital.Ultracare.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ultracare/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<ResponseStructure<DepartmentModel>> createDepartment(@RequestBody DepartmentModel department){
        return departmentService.createDepartment(department);
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseStructure<List<DepartmentModel>>> fetchAllDepartment(){
        return departmentService.fetchAllDepartment();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ResponseStructure<DepartmentModel>> fetchDepartmentById(@PathVariable Long id){
        return departmentService.fetchDepartmentById(id);
    }

    @PutMapping
    public ResponseEntity<ResponseStructure<DepartmentModel>> updateDepartment(@RequestBody DepartmentModel department){
        return departmentService.updateDepartment(department);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseStructure<String>> deleteDepartment(@PathVariable Long id){
        return departmentService.deleteDepartment(id);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<ResponseStructure<DepartmentModel>> fetchDepartmentByDepartmentName(@PathVariable String name){
        return departmentService.fetchDepartmentByDepartmentName(name);
    }
}
