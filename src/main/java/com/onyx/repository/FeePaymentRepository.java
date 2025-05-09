package com.onyx.repository;

import com.onyx.model.FeePayment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeePaymentRepository extends JpaRepository<FeePayment,Long> {
    List<FeePayment> findByStudentId(Long studentId);
}
