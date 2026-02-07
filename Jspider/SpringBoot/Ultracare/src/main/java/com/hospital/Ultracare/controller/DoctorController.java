package com.hospital.Ultracare.controller;

import com.hospital.Ultracare.dao.DepartmentDao;
import com.hospital.Ultracare.dto.ResponseStructure;
import com.hospital.Ultracare.model.DepartmentModel;
import com.hospital.Ultracare.model.DoctorModel;
import com.hospital.Ultracare.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ultracare/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public ResponseEntity<ResponseStructure<DoctorModel>> addDoctor(@RequestBody DoctorModel doctor){
        return doctorService.addDoctor(doctor);
    }

    @GetMapping("/all")
    public ResponseEntity<ResponseStructure<List<DoctorModel>>> getAllDoctor(){
        return doctorService.getAllDoctor();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ResponseStructure<DoctorModel>> fetchDoctorById(@PathVariable Long id){
        return doctorService.fetchDoctorById(id);
    }

    @GetMapping("/specialization/{specialization}")
    public ResponseEntity<ResponseStructure<List<DoctorModel>>> fetchDoctorBySpecialization(@PathVariable String specialization){
        return doctorService.fetchDoctorBySpecialization(specialization);
    }

    @GetMapping("/department/{departmentName}")
    public ResponseEntity<ResponseStructure<List<DoctorModel>>> fetchDoctorByDepartment(@PathVariable String departmentName){
        return doctorService.fetchDoctorByDepartment(departmentName);
    }

    @PutMapping
    public ResponseEntity<ResponseStructure<DoctorModel>> updateDoctor(@RequestBody DoctorModel doctor){
        return doctorService.updateDoctor(doctor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseStructure<String>> deleteDoctor(@PathVariable Long id){
        return doctorService.deleteDoctor(id);
    }
}
