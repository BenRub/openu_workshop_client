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
public class User {
    public int Id; 
    public String Username; 
    public String Password; 
    public String Phone; 
    public String Address;   
    
    public int getId() { return Id; }
    
    public String getUsername() { return Username; } 
    public void setUsername(String username) { Username = username; }
    
    public String getPhone() { return Phone; } 
    public void setPhone(String phone) { Phone = phone; }
    
    public String getAddress() { return Address; }
    public void setAddress(String address) { Address = address; }   
}
