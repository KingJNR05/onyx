package com.onyx.repository;

import com.onyx.model.FeeStructure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeeStructureRepository extends JpaRepository<FeeStructure,Long> {
    Optional<FeeStructure> findByGrade(int grade);
}
