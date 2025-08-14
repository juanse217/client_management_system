package com.client_management.model;

public class User {
    private final int MAX_ACTIONS = 100;
    private String name;
    private String id; 
    private String userName;
    private String password;
    private Role role; 
    private ActionHistory[] history;

    

    public User(String name, String id, String userName, String password, Role role) {
        this.name = name;
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.role = role;
        history = new ActionHistory[MAX_ACTIONS];
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
  
    public String getUserName() {
        return userName;
    }
  
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    } 

    public Role getRole() {
        return role;
    }

    public void addAction(ActionHistory action){
        for (int i = 0; i < history.length; i++) {
            if(history[i] == null){
                history[i] = action; 
            }
        }

        System.out.println("The actions list is full and no more actions can be added");
    }

    
}
