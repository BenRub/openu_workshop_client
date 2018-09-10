package com.beans;

import com.Util.RestClient;
import com.entities.Category;
import com.mycompany.openu_workshop_client.Config;
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
    private final String categoriesAddsress;
    private Category newCategory;
    public CategoriesBean() 
    {
        categoriesAddsress = Config.Host + "Categories/";
        RestClient client = new RestClient();
        categories = client.Get(categoriesAddsress, Category[].class);
        newCategory = new Category();
        newCategory.setName("name");
    }
    
    public Category[] getCategories() 
    {
        return categories;
    }
    
    public Category getNewCategory() {
        return newCategory;
    }
    
    public void reload() throws IOException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
    }
    
    public void add() throws IOException {
        RestClient client = new RestClient();
        client.Post(categoriesAddsress, newCategory);
        reload();        
    }
    
    public void update(Category category) throws IOException {
        RestClient client = new RestClient();
        client.Put(categoriesAddsress + category.getId(), category);
        reload();
    }
  
}
