package com.hospital.Ultracare.repository;

import com.hospital.Ultracare.model.MedicalReportModel;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalReportRepository extends JpaRepository<MedicalReportModel, Long> {
}
