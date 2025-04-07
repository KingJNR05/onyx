package com.kingjnr.feesManagementSystem.B_Mpoza_Fees_Managment_System.service;

import com.kingjnr.feesManagementSystem.B_Mpoza_Fees_Managment_System.model.FeeStructure;
import com.kingjnr.feesManagementSystem.B_Mpoza_Fees_Managment_System.repository.FeeStructureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeeStructureService {

    @Autowired
    private FeeStructureRepository repo;

    public void setFeeStructure(FeeStructure feeStructure) {
        repo.save(feeStructure);
    }
}
