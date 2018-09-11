package com.api;
import com.entities.Product;
import java.io.IOException;

public class ProductsApi extends BaseApi {
    
    public ProductsApi() {
        super("products");
    }
    
    public Product[] GetAll(String category) {
        Product[] products = new Product[] {};
        try {
            String urlPostFix = category == null ? "" : "?category=" + category;
            products = requests.Get(url + urlPostFix, Product[].class);
        } finally {
            return products;
        }        
    }
    
    public boolean Create(Product product) {
        try {
            requests.Post(url, product);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }
    
    public boolean Update(Product product) {
        try {
            requests.Put(url + "/" + product.getId(), product);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }  
    
}
