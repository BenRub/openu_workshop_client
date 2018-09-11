package com.services;
import com.entities.Product;
import java.io.IOException;

public class ProductsService extends BaseService {
    
    public ProductsService() {
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
    
    public Product Get(String productId) {
        Product product = new Product();
        try {
            product = requests.Get(url + "/" + productId, Product.class);
        } finally {
            return product;
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
