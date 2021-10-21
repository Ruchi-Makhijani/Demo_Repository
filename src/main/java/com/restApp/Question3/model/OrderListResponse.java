package com.restApp.Question3.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class OrderListResponse {
    private String orderNo;
    private String createDate;
    private double quantity;
}
