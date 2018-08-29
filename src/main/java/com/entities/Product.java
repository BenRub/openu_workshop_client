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
public class Product {
    public int Id; 
    public String Title;  
    
    public int getId() {
        return Id;
    }
    
    public String getTitle() {
        return Title;
    }  
    
    public void setTitle(String title) {
        Title = title;
    }    
}
