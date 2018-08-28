package com.beans;

import com.Util.RestClient;
import com.entities.Product;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

@ManagedBean
@RequestScoped
public class ProductsBean 
{
    private Product[] products;
    public ProductsBean() 
    {
        RestClient client = new RestClient();
        products = client.Get("http://localhost:61070/api/Products", Product[].class);
    }
    
    public Product[] getProducts() 
    {
        return products;
    }    
  
}
