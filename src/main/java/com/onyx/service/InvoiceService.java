package com.onyx.service;

import com.onyx.Exceptions.FeeStructureNotFoundException;
import com.onyx.Exceptions.StudentNotFoundException;
import com.onyx.model.FeeStructure;
import com.onyx.model.Invoice;
import com.onyx.model.InvoiceStatus;
import com.onyx.model.Student;
import com.onyx.repository.FeeStructureRepository;
import com.onyx.repository.InvoiceRepository;
import com.onyx.repository.StudentRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;


@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepo;

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private FeeStructureRepository feeStructureRepo;


    public void createInvoice(Long studentId){

        // Get student and fee structure
        Student student = studentRepo.findById(studentId).orElseThrow(()-> new StudentNotFoundException("Student Not Found"));
        FeeStructure feeStructure = feeStructureRepo.findByGrade(student.getGrade()).orElseThrow(()-> new FeeStructureNotFoundException("Fee Structure Not Found"));

        //Default credit amounts
        BigDecimal prevInvoiceCredit = BigDecimal.ZERO;
        BigDecimal leftOverCredit = BigDecimal.ZERO;


        // gets previous invoice
        Optional<Invoice> prevInvoice = invoiceRepo.findLatestInvoiceByStudentId(studentId);

        if(prevInvoice.isPresent()) {

             //assign prev invoice credit amount
             prevInvoiceCredit =  prevInvoice.get().getCreditAmount();

             //prev credit amount set to zero as credit amount will be used on the next invoice
             prevInvoice.get().setCreditAmount(BigDecimal.ZERO);
             invoiceRepo.save(prevInvoice.get());

             // if invoice credit >= the monthly fee assign remainder to leftover
             if(prevInvoiceCredit.compareTo(feeStructure.getTotalFee())>= 0 ){
                    // excess cash to be applied to next invoice
                 leftOverCredit = prevInvoiceCredit.subtract(feeStructure.getTotalFee());

                 prevInvoiceCredit = BigDecimal.ZERO;
             }

        }

        String month =  LocalDate.now().getMonth().toString();
        int year = LocalDate.now().getYear();
        BigDecimal feeToBePaid = feeStructure.getTotalFee();
        BigDecimal discount = BigDecimal.ZERO;
        InvoiceStatus status = InvoiceStatus.Pending;
        BigDecimal remainingFeeToBePaid = feeStructure.getTotalFee().subtract(prevInvoiceCredit);

        Invoice invoice = new Invoice(
                                    student, month, year, feeToBePaid,
                                    discount, remainingFeeToBePaid,
                                    status,  LocalDate.now().plus(Period.of(0,3,0)),
                                    leftOverCredit
        );


        invoiceRepo.save(invoice);

    }

}
