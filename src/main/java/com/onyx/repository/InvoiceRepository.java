package com.onyx.repository;

import com.onyx.model.Invoice;
import com.onyx.model.InvoiceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,Long> {

    @Query("SELECT i FROM Invoice i WHERE i.student.id = :studentId AND i.status IN :statuses")
    List<Invoice> findAllByStudentIdAndInvoiceStatusIn(@Param("studentId") Long studentId, @Param("statuses") List<InvoiceStatus> statuses);


    @Query(value = "SELECT * FROM invoice WHERE student_id = :studentId ORDER BY id DESC LIMIT(1)", nativeQuery = true)
    Optional<Invoice> findLatestInvoiceByStudentId(Long studentId);
}
