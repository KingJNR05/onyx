package com.onyx.service;

import com.onyx.Exceptions.FeeStructureNotFoundException;
import com.onyx.Exceptions.InvoiceNotFoundException;
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
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;


@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepo;

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private FeeStructureRepository feeStructureRepo;

    @Scheduled(cron = "0 0 0 1 * ?") // 1st of every month at midnight
    public void createInvoice() {

        LocalDate today = LocalDate.now();
        String currentMonth = today.getMonth().toString();
        int currentYear = today.getYear();

        // Get students and fee structure
        FeeStructure feeStructure;
        List<Student> allStudents = studentRepo.findAll();
        for (Student student : allStudents) {
            Optional<Invoice> latestInvoice = invoiceRepo.findLatestInvoiceByStudentId(student.getId());


            boolean invoiceForThisMonthAlreadyExists = latestInvoice.isPresent()
                    && latestInvoice.get().getMonth().equals(currentMonth)
                    && latestInvoice.get().getYear() == currentYear;

            //create invoice only if it hasn't been created before
            if(!invoiceForThisMonthAlreadyExists) {
                feeStructure = feeStructureRepo.findByGrade(student.getGrade()).orElseThrow(() -> new FeeStructureNotFoundException("Fee Structure Not Found"));

                //Default credit amounts
                BigDecimal prevInvoiceCredit = BigDecimal.ZERO;
                BigDecimal leftOverCredit = BigDecimal.ZERO;

                if(latestInvoice.isPresent()){
                // gets previous invoice
                Invoice prevInvoice = latestInvoice.get();

                //assign prev invoice credit amount
                prevInvoiceCredit = prevInvoice.getCreditAmount();

                //prev credit amount set to zero as credit amount will be used on the next invoice
                prevInvoice.setCreditAmount(BigDecimal.ZERO);
                invoiceRepo.save(prevInvoice);

                    // if invoice credit >= the monthly fee assign remainder to leftover
                    if (prevInvoiceCredit.compareTo(feeStructure.getTotalFee()) >= 0) {
                        // excess cash to be applied to next invoice
                        leftOverCredit = prevInvoiceCredit.subtract(feeStructure.getTotalFee());

                        prevInvoiceCredit = BigDecimal.ZERO;
                    }
                }

                BigDecimal feeToBePaid = feeStructure.getTotalFee();
                BigDecimal discount = BigDecimal.ZERO;
                InvoiceStatus status = InvoiceStatus.Pending;
                BigDecimal remainingFeeToBePaid = feeStructure.getTotalFee().subtract(prevInvoiceCredit);

                Invoice invoice = new Invoice(
                        student, currentMonth, currentYear, feeToBePaid,
                        discount, remainingFeeToBePaid,
                        status, LocalDate.now().plus(Period.of(0, 3, 0)),
                        leftOverCredit
                );


                invoiceRepo.save(invoice);

            }
        }
    }


    public Long getInvoiceId(Long studentId){
        return invoiceRepo.getInvoiceId(studentId).orElseThrow(()-> new InvoiceNotFoundException("Invoice not Found"));
    }



}
