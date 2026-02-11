package com.hospital.Ultracare.repository;

import com.hospital.Ultracare.model.DepartmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentModel, Long> {
    DepartmentModel findByDepartmentName(String name);
}
