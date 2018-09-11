package com.entities;
public class Order extends EntityWithId {
    
    public int userId; 
    public int getUserId() { return userId; } 
    
    public long timestamp; 
    public long getTimestamp() { return timestamp; }   
    
    public String status; 
    public String getStatus() { return status; }     
    public void setStatus(String status) { this.status = status; }  
    
    public ProductAndAmount[] products; 
    public ProductAndAmount[] getProducts() { return products; }   
    
}
