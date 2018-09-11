package com.beans;

import com.api.CategoriesApi;
import com.api.ProductsApi;
import com.entities.Category;
import com.entities.Product;
import java.util.LinkedList;
import java.util.List;
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
    private List<String> categoriesNames;
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
        fillCategoriesNames();
    }
    
    private void fillCategoriesNames() {
        categoriesNames = new LinkedList<>();
        for(Category category : new CategoriesApi().GetAll()) {
            categoriesNames.add(category.getName());
        }
    }
    
    public Product getProduct() 
    {
        return product;
    } 
    
    public String getSavingError() 
    {
        return savingError;
    } 
    
    public List<String> getCategoriesNames() {
        return categoriesNames;
    }
    
    public void Save() {
        boolean result;
        if (productId == null || productId.isEmpty())
            result = productsApi.Create(product);
        else
            result = productsApi.Update(product);
        
        if (result) {
            String postFix = category != null && !category.isEmpty() ? "?category=" + category : "";
            Reload("products.xhtml" + postFix);
        }
        else
            savingError = "Error in saving";
    }
}
