package com.hospital.Ultracare.repository;

import com.hospital.Ultracare.model.DepartmentModel;
import com.hospital.Ultracare.model.DoctorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorModel, Long> {

    List<DoctorModel> findBySpecialization(String specialization);
    List<DoctorModel> findByDepartment(DepartmentModel department);
}
