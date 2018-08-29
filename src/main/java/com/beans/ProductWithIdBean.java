package com.beans;

import com.Util.RestClient;
import com.entities.Product;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

@ManagedBean
@RequestScoped
public class ProductWithIdBean 
{
    private int id;
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }   
    
    private String title;
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }    
    
    public String update() {
        return null; // no navigation
    }
  
}
