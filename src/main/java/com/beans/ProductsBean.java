package com.beans;

import com.api.ProductsService;
import com.entities.Product;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class ProductsBean 
{  
    private final String category;
    private final Product[] products;
    
    public ProductsBean() 
    {
        Map<String, String> queryParams = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();   
        category = queryParams.get("category");
        products = new ProductsService().GetAll(category);
    }
    
    public Product[] getProducts() 
    {
        return products;
    } 
}
