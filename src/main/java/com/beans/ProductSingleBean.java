package com.beans;

import com.api.ProductsApi;
import com.entities.Product;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class ProductSingleBean extends CommonBean
{  
    private final String productId;
    private final String category;
    private final Product product;
    private final ProductsApi productsApi;
    private String savingError;
    
    public ProductSingleBean() 
    {
        Map<String, String> queryParams = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();   
        productId = queryParams.get("id");
        category = queryParams.get("category");
        productsApi = new ProductsApi();
        if (productId == null) {
            product = new Product();
            product.setCategory(category);
        }
        else 
            product = productsApi.Get(productId);
        savingError = "";
    }
    
    public Product getProduct() 
    {
        return product;
    } 
    
    public String getSavingError() 
    {
        return savingError;
    } 
    
    public void Save() {
        boolean result;
        if (productId == null)
            result = productsApi.Create(product);
        else
            result = productsApi.Update(product);
        
        if (result)
            Reload("products");
        else
            savingError = "Error in saving";
    }
}
