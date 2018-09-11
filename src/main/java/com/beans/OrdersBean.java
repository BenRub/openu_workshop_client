package com.beans;

import com.Util.RestClient;
import com.entities.Order;
import com.entities.Product;
import com.entities.User;
import com.mycompany.openu_workshop_client.Config;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@RequestScoped
public class OrdersBean 
{
    private final Order[] orders;
    private final String ordersAddsress;
    private final String usersAddsress;
    private final String productsAddsress;
    private final Map<Integer, User> usersIdsToUsers;
    private Map<String, Integer> productsToAmount;
    private Order viewedOrder;
    
    public OrdersBean() 
    {     
        ordersAddsress = Config.Host + "Orders/";
        usersAddsress = Config.Host + "Users/";
        productsAddsress = Config.Host + "Products/";
        RestClient client = new RestClient();
        orders = client.Get(ordersAddsress, Order[].class);
        
        usersIdsToUsers = new HashMap<>();
        
        Map<String, String> queryParams = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();           
        getUsersAndOrder(client, queryParams.get("order"));
        getViewOrderProducts(client);
    }
    
    private void getUsersAndOrder(RestClient client, String viewedOrderId) {
        for(Order order : orders) {
            if (viewedOrderId != null && String.valueOf(order.getId()).equals(viewedOrderId)) {
                viewedOrder = order;
            }
            int userId = order.getUserId();
            User user = client.Get(usersAddsress + "/" + userId, User.class);
            usersIdsToUsers.put(userId, user);
        }        
    }
    
    private void getViewOrderProducts(RestClient client) {
        if (viewedOrder == null)
            return;
        productsToAmount = new HashMap<>();
        /*
        for (Map.Entry<Integer, Integer> entry : viewedOrder.ProductsToAmount.entrySet())
        {
            Product product = client.Get(productsAddsress + "/" + entry.getKey(), Product.class);
            productsToAmount.put(product.Title, entry.getValue());
        }
        */
    }
    
    public Order[] getOrders() 
    {
        return orders;
    }
    
    public Map<Integer, User> getUsersIdsToUsers() {
        return usersIdsToUsers;
    }
    
    public Order getViewedOrder() {
        return viewedOrder;
    }
    
    public Map<String, Integer> getViewedOrderProducts() {
        return productsToAmount;
    }
    
    public void reload() throws IOException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
    }
    
    public void update(Order order) throws IOException {
        RestClient client = new RestClient();
        client.Put(ordersAddsress + order.getId(), order);
        reload();
    }
  
}
