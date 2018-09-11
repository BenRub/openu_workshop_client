package com.services;
import com.entities.Order;
import com.entities.OrderStatus;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public boolean MarkAsDone(String orderId) {
        return ChangeOrderStatus(orderId, "Done");
    }
    
    public boolean Cancel(String orderId) {
        return ChangeOrderStatus(orderId, "Canceled");
    }
    
    private boolean ChangeOrderStatus(String orderId, String status) {
        try {
            OrderStatus orderStatus = new OrderStatus();
            orderStatus.status = status;
            requests.Put(url + "/" + orderId, orderStatus);
            return true;
        } catch (IOException ex) {
            return false;
        }        
    }
    
}
