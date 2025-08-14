package com.client_management.service;

import com.client_management.app.ManagementSystem;
import com.client_management.model.User;
import com.client_management.repositories.UserRepository;


public class Authentication {
    private UserRepository finder; 

    public void login(String userName, String password){
        User user = finder.findUserByUserName(userName);
        if((user != null) && (user.getPassword().equals(password))){
            System.out.println("Succesul login!");
        }else{
            System.out.println("Your password or username is incorrect.");
        }
        
        ManagementSystem.main(null);
    }
}
