package com.beans;

import com.services.UsersService;
import com.entities.User;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class UserSingleBean extends CommonBean
{
    private final User user;
    private final UsersService usersService;
    private String addingError;
    
    public UserSingleBean() 
    {
        usersService = new UsersService();
        user = new User();
        addingError = "";
    }
    
    public User getUser() 
    {
        return user;
    } 
    
    public String getAddingError() 
    {
        return addingError;
    } 
    
    public void Add() {
        boolean result = usersService.CreateAdmin(user);
        
        if (result)
            Reload("users.xhtml");
        else
            addingError = "Error in adding";
    }
}
