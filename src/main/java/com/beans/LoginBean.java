package com.beans;
import com.services.UsersService;
import com.entities.LoginInfo;
import com.entities.LoginResult;
import com.entities.User;
import com.mycompany.openu_workshop_client.Config;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class LoginBean extends CommonBean implements Serializable
{
    private final LoginInfo loginInfo;
    private final UsersService usersService;
    private User loggedUser;
    private LoginResult loginResult;
    private boolean isLogged;
    private String loginError;
    
    public LoginBean() 
    {
        loginInfo = new LoginInfo();
        usersService = new UsersService();
        loginError = "";
        isLogged = false;
    }

    public LoginInfo getLoginInfo() 
    {
        return loginInfo;
    }
    
    public boolean isLogged() {
        return isLogged;
    }
    
    public String getToken() {
        return loginResult.value;
    }
  
    public User getLoggedUser() {
        return loggedUser;
    }

    public String getLoginError() 
    {
        return loginError;
    }
    
    public void Login() {
        LoginResult result = usersService.AdminSignIn(loginInfo);
        if (result != null) {
            loginResult = result;
            Config.Token = result.value;
            loggedUser = usersService.Get(result.userId);
            isLogged = true;
            GoHome();
        }
        else {
            loginError = "Couldn't sign in";
        }
    }
    
    public void Logout() {
        isLogged = false;
        loginResult = null;
        loggedUser = null;
        Config.Token = "";
        GoHome();
    }
  
}
