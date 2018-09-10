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
public class Category {
    public int Id; 
    public String Name;  
    
    public int getId() { return Id; }
    
    public String getName() { return Name; }  
    
    public void setName(String name) { Name = name; }    
}
