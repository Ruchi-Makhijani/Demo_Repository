package com.restApp.Question3.controller;
import com.restApp.Question3.model.InputOrder;
import com.restApp.Question3.model.OrderResponse;
import com.restApp.Question3.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/getOrderStats")
    public OrderResponse getOrderStatus(@RequestBody InputOrder inputOrder) {
            orderService.initializeOrder();
            OrderResponse orderResponse=null;
            if(inputOrder.getStatName().equals("MAX_SALE")) {
                 orderResponse = orderService.getMaxOrderStatus();
            }
        else {
            orderResponse = orderService.getMinOrderStatus();
        }
            return orderResponse;
    }
}
