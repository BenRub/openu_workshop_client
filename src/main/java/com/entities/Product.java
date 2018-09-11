/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

/**
 *
 * @author ben
 */
public class Product extends EntityWithId {
 
    public String name; 
    public String getName() { return name; }     
    public void setName(String name) { this.name = name; } 
 
    public String imageUrl; 
    public String getImageUrl() { return imageUrl; }     
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; } 

    public String category; 
    public String getCategory() { return category; } 
    
    public String vendor; 
    public String getVendor() { return vendor; }     
    public void setVendor(String vendor) { this.vendor = vendor; }  
    
    public String description; 
    public String getDescription() { return description; }     
    public void setDescription(String description) { this.description = description; }

    public double price; 
    public double getPrice() { return price; }     
    public void setPrice(double price) { this.price = price; }  
    
    public int unitsInStock; 
    public int getUnitsInStock() { return unitsInStock; }     
    public void setUnitsInStock(int unitsInStock) { this.unitsInStock = unitsInStock; }  
    
    public int discount; 
    public int getDiscount() { return discount; }     
    public void setDiscount(int discount) { this.discount = discount; }      
}
