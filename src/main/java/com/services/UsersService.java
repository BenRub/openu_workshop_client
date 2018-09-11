package com.services;
import com.entities.LoginInfo;
import com.entities.LoginResult;
import com.entities.Product;
import com.entities.User;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsersService extends BaseService {
    
    public UsersService() {
        super("users");
    }
    
    public LoginResult AdminSignIn(LoginInfo loginInfo) {
        try {
            return requests.PostWithAnswer(url + "/signin/admin", loginInfo, LoginResult.class);
        } catch (IOException ex) {
            return null;
        }
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
    
    public User Get(int userId) {
        try {       
            return requests.Get(url + "/" + userId, User.class);
        } catch (IOException ex) {
            return null;
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
    
}
