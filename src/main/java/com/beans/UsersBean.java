package com.beans;

import com.Util.RestClient;
import com.entities.User;
import com.mycompany.openu_workshop_client.Config;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean
@RequestScoped
public class UsersBean 
{
    private final User[] users;
    private final String usersAddsress;
    private User newAdmin;
    public UsersBean() 
    {
        usersAddsress = Config.Host + "Users/";
        RestClient client = new RestClient();
        users = client.Get(usersAddsress, User[].class);
        newAdmin = new User();
        newAdmin.setUsername("Admin");
        newAdmin.setAddress("Address");
        newAdmin.setPhone("Phone");
    }
    
    public User[] getUsers() 
    {
        return users;
    }
    
    public User getNewAdmin() {
        return newAdmin;
    }
    
    public void reload() throws IOException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
    }
    
    public void add() throws IOException {
        RestClient client = new RestClient();
        client.Post(usersAddsress, newAdmin);
        reload();        
    }
    
    public void update(User user) throws IOException {
        RestClient client = new RestClient();
        client.Put(usersAddsress + user.getId(), user);
        reload();
    }
  
}
