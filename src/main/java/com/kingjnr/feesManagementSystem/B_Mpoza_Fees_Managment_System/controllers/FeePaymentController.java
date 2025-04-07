package com.kingjnr.feesManagementSystem.B_Mpoza_Fees_Managment_System.controllers;

import com.kingjnr.feesManagementSystem.B_Mpoza_Fees_Managment_System.model.FeePaymentDetails;
import com.kingjnr.feesManagementSystem.B_Mpoza_Fees_Managment_System.service.FeePaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("bmpoza")
public class FeePaymentController {

    @Autowired
    private FeePaymentService service;

    @PostMapping("payment")
    public void payment(@RequestBody FeePaymentDetails details){

        service.payment(details);
    }

//    @GetMapping("payment")
//    public FeePayment payment()


}
