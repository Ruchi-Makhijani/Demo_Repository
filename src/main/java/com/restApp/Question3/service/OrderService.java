package com.restApp.Question3.service;

import com.restApp.Question3.model.Order;
import com.restApp.Question3.model.OrderListResponse;
import com.restApp.Question3.model.OrderResponse;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private static List<Order> orderList=new ArrayList<>();
    public void initializeOrder(){
        orderList.add(new Order("Order1","Product1","2021-03-16",10));
        orderList.add(new Order("Order2","Product2","2021-03-19",65));
        orderList.add(new Order("Order3","Product1","2021-03-16",100));
        orderList.add(new Order("Order4","Product4","2021-03-20",20));
        orderList.add(new Order("Order5","Product2","2021-03-16",20));
    }

    public OrderResponse getMaxOrderStatus() {
        double sum=0,max=0;
        String product,maxProduct=null;
        for(int i=0;i<orderList.size();i++)
        {
            max=0;
            product=orderList.get(i).getProductId();
            String finalTempProduct = product;
            max=orderList.stream().filter(j->j.getProductId().equals(finalTempProduct)).mapToDouble(j-> j.getQuantity()).sum();
            if(max>sum) {
                sum = max;
                maxProduct = product;
            }
        }
        String finalMaxProduct = maxProduct;
        List<OrderListResponse> orderListResponses=orderList.stream().filter(i->i.getProductId().equals(finalMaxProduct)).map(i-> new OrderListResponse(i.getOrderNo(),i.getCreateDate(),i.getQuantity())).collect(Collectors.toList());
        OrderResponse orderResponse=new OrderResponse(finalMaxProduct,orderListResponses);
        return orderResponse;
}


    public OrderResponse getMinOrderStatus() {
        double sum=999,min=0;
        String product,minProduct=null;
        for(int i=0;i<orderList.size();i++)
        {
            min=0;
            product=orderList.get(i).getProductId();
            String finalTempProduct = product;
            min=orderList.stream().filter(j->j.getProductId().equals(finalTempProduct)).mapToDouble(j-> j.getQuantity()).sum();
            if(min<sum) {
                sum = min;
                minProduct = product;
            }
        }
        String finalMinProduct = minProduct;
        List<OrderListResponse> orderListResponses=orderList.stream().filter(i->i.getProductId().equals(finalMinProduct)).map(i-> new OrderListResponse(i.getOrderNo(),i.getCreateDate(),i.getQuantity())).collect(Collectors.toList());
        OrderResponse orderResponse=new OrderResponse(finalMinProduct,orderListResponses);
        return orderResponse;


    }
}
