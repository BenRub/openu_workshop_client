package com.services;
import com.entities.Order;
import java.io.IOException;

public class OrdersService extends BaseService {
    
    public OrdersService() {
        super("orders");
    }
    
    public Order[] GetAll() {
        try {
            return requests.Get(url, Order[].class);
        } catch (IOException e) {
            return new Order[] {};
        }        
    }
    
    public Order Get(String orderId) {
        try {
            return requests.Get(url + "/" + orderId, Order.class);
        } catch (IOException e) {
            return null;
        }         
    } 
    
}
