package com.restApp.Question3.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SupplyResponse {
    private String productId;
    private String updateTimeStamp;
    private double quantity;
    private String status;
}
