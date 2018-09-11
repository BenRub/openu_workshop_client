package com.entities;
public class User extends EntityWithId {
    
    public String username; 
    public String getUsername() { return username; }     
    public void setUsername(String username) { this.username = username; }  
    
    public String password; 
    public String getPassword() { return password; }     
    public void setPassword(String password) { this.password = password; }  
    
    public String roleId; 
    public String getRoleId() { return roleId; }  
    
    public String firstName; 
    public String getFirstName() { return firstName; }     
    public void setFirstName(String firstName) { this.firstName = firstName; }  
    
    public String lastName; 
    public String getLastName() { return lastName; }     
    public void setLastName(String lastName) { this.lastName = lastName; }  
    
    public String email; 
    public String getEmail() { return email; }     
    public void setEmail(String email) { this.email = email; }  
    
    public String address; 
    public String getAddress() { return address; }     
    public void setAddress(String address) { this.address = address; }  
    
    public String city; 
    public String getCity() { return city; }     
    public void setCity(String city) { this.city = city; }   
    
    public String zipCode; 
    public String getZipCode() { return zipCode; }     
    public void setZipCode(String zipCode) { this.zipCode = zipCode; }    
    
    public String phoneNumber; 
    public String getPhoneNumber() { return phoneNumber; }     
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }    
    
}
