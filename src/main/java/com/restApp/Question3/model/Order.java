package com.restApp.Question3.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    private String orderNo;
    private String productId;
    private String createDate;
    private double quantity;
}
