package com.onyx.controllers;

import com.onyx.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvoiceController {

    @Autowired
    private InvoiceService service;

    @PostMapping("invoice")
    public void createInvoice(Long studentId){
        service.createInvoice();
    }


}
