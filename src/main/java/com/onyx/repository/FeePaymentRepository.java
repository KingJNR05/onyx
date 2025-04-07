package com.onyx.repository;

import com.onyx.model.FeePayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeePaymentRepository extends JpaRepository<FeePayment,Long> {
}
