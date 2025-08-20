package com.client_management.service;

import com.client_management.model.User;
import com.client_management.repositories.UserRepository;


public class Authentication {
    private UserRepository finder;
    
    public Authentication(UserRepository repo){
        finder = repo;
    }

    public void login(String userName, String password){
        User user = finder.findUserByUserName(userName);
        
        if(user != null){
            if(user.getPassword().equals(password)){
                System.out.println("Successful login! Welcome");
            }else{
                System.out.println("The password is wrong");
            }
        }else{
            System.out.println("The user doesn't exist");
        }
    }

    
}
