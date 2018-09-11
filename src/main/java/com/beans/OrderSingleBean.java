package com.beans;

import com.entities.Order;
import com.entities.Product;
import com.entities.ProductAndAmount;
import com.entities.User;
import com.services.OrdersService;
import com.services.ProductsService;
import com.services.UsersService;
import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class OrderSingleBean extends CommonBean
{
    private final String orderId;
    private final Order order;
    private final User user;
    private final Map<Integer, Product> productsIdsToProducts;
    private final OrdersService ordersService;
    private String changingError;
    
    public OrderSingleBean() 
    {
        Map<String, String> queryParams = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();   
        orderId = queryParams.get("id");        
        ordersService = new OrdersService();
        order = ordersService.Get(orderId);   
        user = new UsersService().Get(order.userId);
        productsIdsToProducts = new HashMap<>();
        getProducts();
    }
    
    private void getProducts() {
        for(ProductAndAmount pair : order.getProducts()) {
            if (productsIdsToProducts.containsKey(pair.productId))
                continue;
            Product product = new ProductsService().Get(String.valueOf(pair.productId));
            productsIdsToProducts.put(pair.productId, product);
        }        
    }
    
    public Order getOrder() 
    {
        return order;
    }
    
    public User getUser() {
        return user;
    }
    
    public Map<Integer, Product> getProductsIdsToProducts() {
        return productsIdsToProducts;
    }
    
    public String getChangingError() {
        return changingError;
    }
    
    public void MarkAsDone() {
        HandleResult(ordersService.MarkAsDone(orderId));
    }
    
    public void Cancel() {
        HandleResult(ordersService.Cancel(orderId));
    }
    
    private void HandleResult(boolean result) {
        if (result)
            Reload("orders.xhtml");
        else
            changingError = "Error in changing status";
    }
  
}
