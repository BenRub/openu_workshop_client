package com.beans;

import com.Util.RestClient;
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
    private final Product[] products;
    private final String categoryProductsAddsress;
    private final String productsAddsress;  
    private final String categoryId; 
    
    public ProductsBean() 
    {
        Map<String, String> queryParams = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();   
        categoryId = queryParams.get("category");
        categoryProductsAddsress = Config.Host + "categories/" + categoryId + "/products/";
        productsAddsress = Config.Host + "products/";
        RestClient client = new RestClient();
        products = client.Get(categoryProductsAddsress, Product[].class);
    }
    
    public Product[] getProducts() 
    {
        return products;
    }
    
    public void reload() throws IOException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI() + "?category=" + categoryId);
}
    
    public void test(Product product) throws IOException {
        RestClient client = new RestClient();
        client.Put(productsAddsress + product.getId(), product);
        reload();
    }
  
}
