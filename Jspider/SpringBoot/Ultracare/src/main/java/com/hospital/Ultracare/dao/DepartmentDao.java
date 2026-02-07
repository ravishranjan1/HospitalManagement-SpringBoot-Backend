package com.hospital.Ultracare.dao;

import com.hospital.Ultracare.exception.IdNotFoundException;
import com.hospital.Ultracare.exception.NoDataFoundException;
import com.hospital.Ultracare.model.DepartmentModel;
import com.hospital.Ultracare.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DepartmentDao {

    @Autowired
    private DepartmentRepository departmentRepository;

    public DepartmentModel createDepartment(DepartmentModel department){
        return departmentRepository.save(department);
    }

    public List<DepartmentModel> fetchAllDepartment(){
        List<DepartmentModel> departments = departmentRepository.findAll();
        if(!departments.isEmpty())
            return departments;
        else
            throw new NoDataFoundException("Department is empty");
    }

    public DepartmentModel fetchDepartmentById(Long id){
        Optional<DepartmentModel> opt = departmentRepository.findById(id);
        if(opt.isPresent())
            return opt.get();
        else
            throw new IdNotFoundException("No Department is found with id : "+id);
    }

    public DepartmentModel updateDepartment(DepartmentModel department){
        if(department.getId() == null)
            throw new IdNotFoundException("Id cannot be null");
        DepartmentModel OldDepartment = fetchDepartmentById(department.getId());
        return departmentRepository.save(department);
    }

    public String deleteDepartment(Long id){
        DepartmentModel department = fetchDepartmentById(id);
        departmentRepository.delete(department);
        return "success";
    }

    public DepartmentModel fetchDepartmentByDepartmentName(String name){
        DepartmentModel department = departmentRepository.findByDepartmentName(name);
        if(department != null)
            return department;
        else
            throw new NoDataFoundException("No Department found with name : "+name);
    }

}
