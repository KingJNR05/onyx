package com.kingjnr.feesManagementSystem.B_Mpoza_Fees_Managment_System.controllers;

import com.kingjnr.feesManagementSystem.B_Mpoza_Fees_Managment_System.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvoiceController {

    @Autowired
    private InvoiceService service;

    @PostMapping("invoice/{studentId}")
    public void createInvoice(@PathVariable Long studentId){
        service.createInvoice(studentId);
    }


}
