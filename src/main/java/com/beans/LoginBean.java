package com.beans;
import com.api.UsersApi;
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
    private final UsersApi usersApi;
    private User loggedUser;
    private LoginResult loginResult;
    private String loginError;
    
    public LoginBean() 
    {
        loginInfo = new LoginInfo();
        usersApi = new UsersApi();
        loginError = "";
    }

    public LoginInfo getLoginInfo() 
    {
        return loginInfo;
    }
    
    public String getToken() {
        return loginResult.value;
    }

    public String getLoginError() 
    {
        return loginError;
    }
    
    public void Login() {
        LoginResult result = usersApi.AdminSignIn(loginInfo);
        if (result != null) {
            loginResult = result;
            Config.Token = result.value;
            loggedUser = usersApi.Get(result.userId);
            GoHome();
        }
        else {
            loginError = "Couldn't sign in";
        }
    }
  
}
