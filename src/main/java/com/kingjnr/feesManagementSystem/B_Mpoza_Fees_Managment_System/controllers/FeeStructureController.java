package com.kingjnr.feesManagementSystem.B_Mpoza_Fees_Managment_System.controllers;

import com.kingjnr.feesManagementSystem.B_Mpoza_Fees_Managment_System.model.FeeStructure;
import com.kingjnr.feesManagementSystem.B_Mpoza_Fees_Managment_System.service.FeeStructureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeeStructureController {

    @Autowired
    private FeeStructureService service;

    @PostMapping("feeStructure")
    public void setFeeStructure(@RequestBody FeeStructure feeStructure){
        service.setFeeStructure(feeStructure);
    }
}
