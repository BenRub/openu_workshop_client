package com.beans;

import com.entities.Order;
import com.entities.User;
import com.services.OrdersService;
import com.services.UsersService;
import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class OrdersBean extends CommonBean
{
    private final Order[] orders;
    private final Map<Integer, User> usersIdsToUsers;
    private final OrdersService ordersService;
    
    public OrdersBean() 
    {
        ordersService = new OrdersService();
        orders = ordersService.GetAll();      
        usersIdsToUsers = new HashMap<>();
        getUsers();
    }
    
    private void getUsers() {
        for(Order order : orders) {
            int userId = order.getUserId();
            if (usersIdsToUsers.containsKey(userId))
                continue;
            User user = new UsersService().Get(userId);
            usersIdsToUsers.put(userId, user);
        }        
    }
    
    public Order[] getOrders() 
    {
        return orders;
    }
    
    public Map<Integer, User> getUsersIdsToUsers() {
        return usersIdsToUsers;
    }
  
}
