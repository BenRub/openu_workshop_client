package com.beans;

import com.entities.User;
import com.services.UsersService;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class UsersBean extends CommonBean 
{
    private final User[] users;
    public UsersBean() 
    {
        users = new UsersService().GetAll();
    }
    
    public User[] getUsers() 
    {
        return users;
    }  
}
