package com.beans;

import com.Util.RestClient;
import com.api.ProductsApi;
import com.entities.Product;
import com.mycompany.openu_workshop_client.Config;
import java.io.IOException;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

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
        products = new ProductsApi().GetAll(category);
    }
    
    public Product[] getProducts() 
    {
        return products;
    } 
}
