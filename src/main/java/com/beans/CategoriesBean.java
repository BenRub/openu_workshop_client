package com.beans;

import com.services.CategoriesService;
import com.entities.Category;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class CategoriesBean extends CommonBean {
    private final Category[] categories;
    private final CategoriesService categoriesService;
    private final Category newCategory;
    private String addingError;
    
    public CategoriesBean() 
    {
        categoriesService = new CategoriesService();
        categories = categoriesService.GetAll();
        newCategory = new Category();
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
    
    public void add() throws IOException {
        if (categoriesService.Create(newCategory))
            Refresh();     
        else
            addingError = "adding failed";
    }
  
}
