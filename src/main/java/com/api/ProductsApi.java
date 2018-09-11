package com.api;
import com.entities.Product;
import java.io.IOException;

public class ProductsApi extends BaseApi {
    
    public ProductsApi() {
        super("products");
    }
    
    public Product[] GetAll(String category) {
        try {
            return requests.Get(url + "?category=" + category, Product[].class);
        } finally {
            return new Product[] {};
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
