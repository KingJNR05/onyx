package com.kingjnr.feesManagementSystem.B_Mpoza_Fees_Managment_System.repository;

import com.kingjnr.feesManagementSystem.B_Mpoza_Fees_Managment_System.model.FeeStructure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeeStructureRepository extends JpaRepository<FeeStructure,Long> {
    Optional<FeeStructure> findByGrade(int grade);
}
