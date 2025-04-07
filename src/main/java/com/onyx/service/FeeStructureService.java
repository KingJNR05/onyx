package com.onyx.service;

import com.onyx.model.FeeStructure;
import com.onyx.repository.FeeStructureRepository;
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
