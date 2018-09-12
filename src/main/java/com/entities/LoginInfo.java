package com.entities;

import java.io.Serializable;

public class LoginInfo implements Serializable {
    public String username; 
    public String getUsername() { return username; }     
    public void setUsername(String username) { this.username = username; }  
    
    public String password; 
    public String getPassword() { return password; }     
    public void setPassword(String password) { this.password = password; }      
    
    
}
