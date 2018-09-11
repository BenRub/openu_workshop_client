package com.beans;

import com.api.CategoriesApi;
import com.entities.Category;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@RequestScoped
public class CategoriesBean 
{
    private final Category[] categories;
    private final CategoriesApi categoriesApi;
    private Category newCategory;
    private String addingError;
    
    public CategoriesBean() 
    {
        categoriesApi = new CategoriesApi();
        categories = categoriesApi.GetAll();
        newCategory = new Category();
        newCategory.setName("name");
        addingError = "";
    }
    
    public Category[] getCategories() 
    {
        return categories;
    }
    
    public Category getNewCategory() {
        return newCategory;
    }
    
    public String getAddingError() {
        return addingError;
    }
    
    public void reload() throws IOException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
    }
    
    public void add() throws IOException {
        if (categoriesApi.Create(newCategory))
            reload();     
        else
            addingError = "adding failed";
    }
  
}
