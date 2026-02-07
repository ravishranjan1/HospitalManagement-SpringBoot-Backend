package com.hospital.Ultracare.repository;

import com.hospital.Ultracare.model.PatientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<PatientModel, Long> {
    PatientModel findByPhone(Long phone);
    List<PatientModel> findByAgeGreaterThan(Integer age);
}
