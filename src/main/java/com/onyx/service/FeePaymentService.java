package com.onyx.service;

import com.onyx.Exceptions.InvoiceNotFoundException;
import com.onyx.Exceptions.StudentNotFoundException;
import com.onyx.model.*;
import com.onyx.repository.FeePaymentRepository;
import com.onyx.repository.InvoiceRepository;
import com.onyx.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FeePaymentService {

    @Autowired
    private InvoiceRepository invoiceRepo;

    @Autowired
    private FeePaymentRepository feePaymentRepo;

    @Autowired
    private StudentRepository studentRepo;

    public void payment(FeePaymentDetails details){

        Invoice invoice = invoiceRepo.findById(details.getInvoice_id()).orElseThrow(() -> new InvoiceNotFoundException("Invoice Not Found"));
        Student student = studentRepo.findById(details.getStudent_id()).orElseThrow(() -> new StudentNotFoundException("Student Not Found"));

        FeePayment payment = new FeePayment(
                invoice,student,
                details.getAmount_paid(),
                LocalDateTime.now(),
                details.getPayment_method()
        );

        feePaymentRepo.save(payment);
        processPayment(payment.getStudent().getId(), payment.getAmountPaid());
    }


    public void processPayment(Long studentId, BigDecimal amountPaid){

        List<InvoiceStatus> statuses = List.of(InvoiceStatus.Overdue,InvoiceStatus.Pending);
        List<Invoice> allPendingAndOverdueInvoices = invoiceRepo.findAllByStudentIdAndInvoiceStatusIn(studentId,statuses);

        BigDecimal remainingAmount = amountPaid;

        for(Invoice invoice : allPendingAndOverdueInvoices) {

            // all cash paid is depleted
            if (remainingAmount.compareTo(BigDecimal.ZERO) == 0) {
                break;
            }

            if (remainingAmount.compareTo(invoice.getFinalAmountDue()) >= 0) {

                remainingAmount = remainingAmount.subtract(invoice.getFinalAmountDue());
                invoice.setFinalAmountDue(BigDecimal.ZERO);
                invoice.setStatus(InvoiceStatus.Paid);

            } else {
                invoice.setFinalAmountDue(invoice.getFinalAmountDue().subtract(remainingAmount));
                remainingAmount = BigDecimal.ZERO;

            }
            invoiceRepo.save(invoice);
        }

        if(remainingAmount.compareTo(BigDecimal.ZERO) > 0){
                Invoice invoice = invoiceRepo.findLatestInvoiceByStudentId(studentId).
                                  orElseThrow(() -> new InvoiceNotFoundException("Invoice Not Found"));

                invoice.setCreditAmount(invoice.getCreditAmount().add(remainingAmount));
                invoiceRepo.save(invoice);

        }
    }


    public List<FeePayment> getPayments(Long studentId) {
       return feePaymentRepo.findByStudentId(studentId);
    }
}
