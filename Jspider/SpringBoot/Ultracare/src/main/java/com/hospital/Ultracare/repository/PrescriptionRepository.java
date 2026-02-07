package com.hospital.Ultracare.repository;

import com.hospital.Ultracare.model.PrescriptionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepository extends JpaRepository<PrescriptionModel, Long> {
}
