package com.onyx.controllers;

import com.onyx.model.FeePaymentDetails;
import com.onyx.service.FeePaymentService;
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
