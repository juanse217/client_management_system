package com.client_management.app;

import java.util.Scanner;

import com.client_management.model.Role;
import com.client_management.repositories.UserRepository;
import com.client_management.service.Authentication;
import com.client_management.service.UserService;

public class ManagementSystem {
    public static void main(String[] args) {
        UserRepository repo = UserRepository.getInstance();
        int decision = 0; 
        Scanner sc = new Scanner(System.in);
        UserService userService = new UserService(repo);
        Authentication login = new Authentication(repo); 

        do {

            System.out.printf("What would you like to do?\nLogin: 1\nCreate new user: 2\nUpdate User Name: 3\nUpdate User Password: 4\nDelete User: 5,\nExit: 6\n");
            decision = Integer.parseInt(sc.nextLine());
            

            switch (decision) {
                case 1:
                    System.out.println("Enter your UserName: ");
                    String userName = sc.nextLine();
                    System.out.println("Enter your password: ");
                    String pw = sc.nextLine();
                    login.login(userName, pw);
                    break;
                case 2:
                    System.out.println("Enter your full name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter your id: ");
                    String id = sc.nextLine(); 
                    System.out.println("Enter your username: ");
                    String userNameCreation = sc.nextLine();
                    System.out.println("Enter your password: ");
                    String password = sc.nextLine();
                    System.out.println("Enter your role: ");
                    String roleString = sc.nextLine();
                    Role role = Role.assignRole(roleString);
                    userService.createUser(name, id, userNameCreation, password, role);
                    break;

                case 3:
                    
                    break;

                case 4:
                    
                    break;

                default:
                    break;
            }
        } while (decision != 6);

        sc.close();
    }
}
