/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ben
 */
public class Order {
    public int Id; 
    public int UserId;
    public Map<Integer, Integer> ProductsToAmount;
    public boolean Delivered;
    
    public int getId() { return Id; }
    
    public int getUserId() { return UserId; }
    
    public boolean getDelivered() { return Delivered; } 
}
