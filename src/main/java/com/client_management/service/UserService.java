package com.client_management.service;

import com.client_management.model.ActionHistory;
import com.client_management.model.Role;
import com.client_management.model.User;
import com.client_management.repositories.UserRepository;

/**
 * this class contains the logic for working with the users
 */
// TODO: Implementar metodo addAction.
// TODO: Agregar feature para rol administrador.
public class UserService {
    private UserRepository repo; // necesitamos la referencia del repositorio para acceder a los datos

    public UserService(UserRepository repo) {
        if (repo == null) {
            System.out.println("The repository can't be null");
        } else {
            this.repo = repo;
        }

    }

    /**
     * Este metodo crea el usuario y hace el registro en actionhistory
     * 
     * 
     * @param user el usuario que se quiere creare en el sistema
     */
    public void createUser(String name, String id, String userName, String password, Role role) {

        User userCreator = new User(name, id, userName, password, role);

        repo.addUser(userCreator);

        String desc = "Creation of " + userCreator.getUserName();
        userCreator.addAction(new ActionHistory(desc, System.currentTimeMillis()));
        // TODO: Use LocalTime to have the current date.
        userCreator.addAction(new ActionHistory(desc, System.currentTimeMillis()));
        // TODO: Use LocalTime to have the current date.
    }

    /**
     * Este metodo imprime la informacion de el usuario si este existe
     * 
     * 
     * @param id el id del usuario que se quiere acceder
     */

    public void searchUserById(String id) {

        User user = repo.findUserById(id);
        if (user == null) {
            if (user == null) {
                System.err.println("ERROR: the user doesn't exist");
                return;
            }

            System.out.printf("Name: %s, ID: %s, UserName: %s", user.getName(), user.getId(), user.getUserName());
        }

    }

    /**
     * /**
     * Este metodo imprime la informacion de el usuario si este existe
     * 
     * 
     * @param userName el username del usuario que se quiere acceder
     */
    public void SearchUserByUserName(String userName) {
        User user = repo.findUserByUserName(userName);
        if (user == null) {
            if (user == null) {
                System.err.println("ERROR: the user doesn't exsist");
                return;
            }

            System.out.printf("Name: %s, ID: %s, UserName: %s", user.getName(), user.getId(), user.getUserName());
        }
    }

    /**
     * Este metodo actualiza el nombre de usuario si este es encontrado
     * 
     * 
     * @param currentUser el usuario al que se le quiere cambiar el nombre
     * @param newName     el nombre al que se quiere cambiar
     * @param newName     el nombre al que se quiere cambiar
     */

    public void updateUserName(User currentUser, String newName) {
        if (currentUser != null) {
            System.out.println("You're updating the name for " + currentUser.getName());
            boolean updated = repo.updateUserName(currentUser, newName);
            if (updated) {
                System.out.println("Update succesful, new name " + newName);
            } else {
                System.out.println("The name couldn't be updated");
            }
        } else {
            System.err.println("ERROR: the user doesn't exist or you haven't logeed in");
        }

    }

    /**
     * Este metodo actualiza el password de usuario si este es encontrado
     * 
     * 
     * @param currentUser el usuario al que se le quiere cambiar el nombre
     * @param newPassword el password al que se quiere cambiar
     */
    public void updateUserPassword(User currentUser, String newPasword) {

        if (currentUser != null) {
            System.out.println("You're updating the password for " + currentUser.getName());
            boolean updated = repo.updateUserPassword(currentUser, newPasword);

            if (updated) {
                System.out.println("Update succesful!");
            } else {
                System.out.println("The password couldn't be updated");
            }
        } else {
            System.err.println("ERROR: the user doesn't exist or you haven't logged in");
            if (currentUser != null) {
                System.out.println("You're updating the password for " + currentUser.getName());
                boolean updated = repo.updateUserPassword(currentUser, newPasword);

                if (updated) {
                    System.out.println("Update succesful!");
                } else {
                    System.out.println("The password couldn't be updated");
                }
            } else {
                System.err.println("ERROR: the user doesn't exist or you haven't logged in");
            }
        }

    }

    public void deleteUser(User user) {
        if (user != null) {
            System.out.println("You're deleting the user " + user.getName());
            repo.deleteUser(user);
            System.out.println("Deletion succesful");
        } else {
            System.out.println("The user couldn't be deleted, it doesn't exist or you haven't logged in");
        }

    }

}
