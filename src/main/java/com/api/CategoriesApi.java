package com.api;
import com.entities.Category;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoriesApi {
    private String url;
    
    public CategoriesApi() {
        url = "categories";
    }
    
    public Category[] GetAll() {
        List<Category> categories = new LinkedList<>();
        try {
            String[] names = new RestRequests().Get(url, String[].class);
            for(String name : names) {
                Category category = new Category();
                category.setName(name);
                categories.add(category);
            }
        } finally {
            return categories.toArray(new Category[categories.size()]);
        }        
    }
    
    public boolean Create(Category category) {
        try {
            new RestRequests().Post(url, new String[] { category.getName() });
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
}
