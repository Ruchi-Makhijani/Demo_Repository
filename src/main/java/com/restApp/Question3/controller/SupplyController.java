package com.restApp.Question3.controller;

import com.restApp.Question3.model.Supply;
import com.restApp.Question3.model.SupplyResponse;
import com.restApp.Question3.service.Supplyservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SupplyController {

    @Autowired
    private Supplyservice supplyservice;

    @PostMapping("/updateSupply")
    public SupplyResponse updateSupply(@RequestBody Supply supply)
    {
        supplyservice.intializeSupply();
        SupplyResponse supplyResponse=supplyservice.updateStatus(supply);
        return supplyResponse;
    }
}
