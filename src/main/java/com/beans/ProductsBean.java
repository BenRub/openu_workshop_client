package com.beans;

import com.Util.RestClient;
import com.entities.Product;
import com.mycompany.openu_workshop_client.Config;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@RequestScoped
public class ProductsBean 
{
    private Product[] products;
    private String productsAddsress;
    public ProductsBean() 
    {
        productsAddsress = Config.Host + "Products/";
        RestClient client = new RestClient();
        products = client.Get(productsAddsress, Product[].class);
    }
    
    public Product[] getProducts() 
    {
        return products;
    }
    
    public void reload() throws IOException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
}
    
    public void test(Product product) throws IOException {
        RestClient client = new RestClient();
        client.Put(productsAddsress + product.getId(), product);
        reload();
    }
  
}
