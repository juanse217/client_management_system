package com.client_management.model;

public enum Role {
    ADMIN, STANDARD;

    public static Role assignRole(String roleString){
        if(roleString.equalsIgnoreCase("Admin")){
            return Role.ADMIN;
        }
        return Role.STANDARD; 
    }
}
