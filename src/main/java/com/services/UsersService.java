package com.services;
import com.entities.LoginInfo;
import com.entities.LoginResult;
import com.entities.User;
import java.io.IOException;
import java.io.Serializable;

public class UsersService extends BaseService implements Serializable {
    
    public UsersService() {
        super("users");
    }
    
    public User[] GetAll() {
        try {
            return requests.Get(url, User[].class);
        } catch (IOException ex) {
            return new User[] {};
        }       
    }
    
    public User Get(int userId) {
        try {       
            return requests.Get(url + "/" + userId, User.class);
        } catch (IOException ex) {
            return null;
        }
    }
    
    public LoginResult AdminSignIn(LoginInfo loginInfo) {
        try {
            return requests.PostWithAnswer(url + "/signin/admin", loginInfo, LoginResult.class);
        } catch (IOException ex) {
            return null;
        }
    }
    
    public boolean CreateAdmin(User user) {
        try {
            user.roleId = "Admin";
            requests.Post(url + "/signup/admin", user);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }  
    
}
