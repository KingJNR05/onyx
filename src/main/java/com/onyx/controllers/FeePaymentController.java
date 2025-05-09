package com.onyx.controllers;

import com.onyx.model.FeePayment;
import com.onyx.model.FeePaymentDetails;
import com.onyx.service.FeePaymentService;
import com.onyx.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bmpoza")
public class FeePaymentController {

    @Autowired
    private FeePaymentService feePaymentService;

    @Autowired
    private InvoiceService invoiceService;

    @PostMapping("payment")
    public void payment(@RequestBody FeePaymentDetails details){
       Long invoiceId =  invoiceService.getInvoiceId(details.getStudent_id());
       details.setInvoice_id(invoiceId);
       feePaymentService.payment(details);
    }

    @GetMapping("payment")
    public List<FeePayment> feePaymentList(Long student_id){
       return feePaymentService.getPayments(student_id);
    }

}
