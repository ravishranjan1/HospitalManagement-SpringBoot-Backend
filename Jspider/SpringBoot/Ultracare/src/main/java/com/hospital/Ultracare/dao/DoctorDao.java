package com.hospital.Ultracare.dao;

import com.hospital.Ultracare.exception.IdNotFoundException;
import com.hospital.Ultracare.exception.NoDataFoundException;
import com.hospital.Ultracare.model.DepartmentModel;
import com.hospital.Ultracare.model.DoctorModel;
import com.hospital.Ultracare.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DoctorDao {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DepartmentDao departmentDao;

    public DoctorModel addDoctor(DoctorModel doctor){
        DepartmentModel department = departmentDao.fetchDepartmentByDepartmentName(doctor.getDepartment().getDepartmentName());
        doctor.setDepartment(department);
        return doctorRepository.save(doctor);
    }

    public List<DoctorModel> getAllDoctor(){
        List<DoctorModel> doctors = doctorRepository.findAll();
        if(!doctors.isEmpty())
            return doctors;
        else
            throw new NoDataFoundException("No Doctor is added yet");
    }

    public DoctorModel fetchDoctorById(Long id){
        Optional<DoctorModel> opt = doctorRepository.findById(id);
        if(opt.isPresent())
            return opt.get();
        else
            throw new IdNotFoundException("No Doctor is found with id : "+id);
    }

    public List<DoctorModel> fetchDoctorBySpecialization(String specialization){
        List<DoctorModel> doctors = doctorRepository.findBySpecialization(specialization);
        if(!doctors.isEmpty())
            return doctors;
        else
            throw new NoDataFoundException("No Doctor is found with this specialization : "+specialization);
    }

    public List<DoctorModel> fetchDoctorByDepartment(String departmentName){
        DepartmentModel department = departmentDao.fetchDepartmentByDepartmentName(departmentName);
        List<DoctorModel> doctors = doctorRepository.findByDepartment(department);
        if(!doctors.isEmpty())
            return doctors;
        else
            throw new NoDataFoundException("No Doctor is found with this department : "+department);
    }

    public DoctorModel updateDoctor(DoctorModel doctor){
        if(doctor.getId() == null)
            throw new IdNotFoundException("Id cannot be null");
        DoctorModel oldDoctor = fetchDoctorById(doctor.getId());
        DepartmentModel department = departmentDao.fetchDepartmentByDepartmentName(doctor.getDepartment().getDepartmentName());
        doctor.setDepartment(department);
        return doctorRepository.save(doctor);
    }

    public String deleteDoctor(Long id){
        DoctorModel doctor = fetchDoctorById(id);
        doctorRepository.delete(doctor);
        return "success";
    }
}
