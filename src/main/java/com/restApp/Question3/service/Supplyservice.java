package com.restApp.Question3.service;

import com.restApp.Question3.model.Supply;
import com.restApp.Question3.model.SupplyResponse;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Supplyservice {

    private List<Supply> supplyList=new ArrayList<>();
    public void intializeSupply() {

                supplyList.add(new Supply("Product1","2021-03-16T08:53:48.616Z",10));
                supplyList.add(new Supply ("Product2","2021-03-16T08:59:48.616Z",5));
                supplyList.add(new Supply ("Product3","2021-03-16T09:10:48.616Z",30));
                supplyList.add(new Supply("Product4","2021-03-16T09:10:48.616Z",20));



    }

    public SupplyResponse updateStatus(Supply supply) {
        List<Supply> supplies=supplyList.stream().filter(i->i.getProductId().equals(supply.getProductId())).collect(Collectors.toList());
        double sum=0;
        if(supplies!=null) {
            sum = supplies.stream().filter(i -> i.getUpdateTimeStamp().compareTo(supply.getUpdateTimeStamp()) < 0).mapToDouble(i -> i.getQuantity()).sum();
            if(sum>0)
            sum = sum + supply.getQuantity();
       }
        SupplyResponse supplyResponse=null;
        if(sum>0)
            supplyResponse=new SupplyResponse(supply.getProductId(),supply.getUpdateTimeStamp(),sum,"Updated");
        else
            supplyResponse=new SupplyResponse(supply.getProductId(),supply.getUpdateTimeStamp(),supply.getQuantity(),"Out of sync update");
        return supplyResponse;

    }
}
