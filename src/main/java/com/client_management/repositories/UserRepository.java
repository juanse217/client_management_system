package com.client_management.repositories;

import com.client_management.model.User;


/**
 * Esta clase contiene el arreglo de user y es a la que se llama para las
 * operaciones. Usamos singleton porque se comparte solo una instancia para toda la app. 
 */
public class UserRepository {
    private static UserRepository repo;
    private User[] users = new User[50]; // max 50 users, relacion de agregacion.
    private int userCount = 0;

    private UserRepository(){

    }

    public static UserRepository getInstance(){
        if(repo == null){
            return new UserRepository(); 
        }

        return repo;
    }


    // CRUD operations

    /**
     * Este metodo agrega un usuario al arreglo donde se guardan
     * 
     * @param user el usuario que se desea agregar.
     * @return a boolean wether the User could be added.
     */
    public boolean addUser(User user) {
        if (userCount < users.length) {
            users[userCount++] = user;
            return true;
        }

        return false;

    }

    /**
     * Este metodo permite encontrar un user usando su ID
     * 
     * @param id el id del usuario que se quiere buscar
     * @return el usuario si se encuentra, null de lo contrario.
     */
    public User findUserById(String id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }

        return null;
    }

    /**
     * Este metodo permite encontrar un user usando su userName
     * 
     * @param userName el userName del usuario que se quiere buscar
     * @return el usuario si se encuentra, null de lo contrario.
     */

    public User findUserByUserName(String userName) {
        for (int i = 0; i < userCount; i++) {
            try {
                if (users[i].getUserName().equals(userName)) {
                    //System.out.println(users[i].getName());
                    return users[i];
                }
            } catch (NullPointerException e) {
                return null;
            }

        }

        return null;
    }

    /**
     * Este metodo chequea si existe el user pasado y cambia su name en caso que
     * exista
     * 
     * @param user    el usuario al que se le quiere cambiar el name
     * @param newName el name al que se quiere cambiar
     * @return true si se pudo cambiar el name, false en caso contrario
     */
    public boolean updateUserName(User user, String newName) {

        for (User user2 : users) {
            if (user.equals(user2)) {
                user.setName(newName);
                return true;
            }
        }

        return false;
    }

    /**
     * Este metodo chequea si existe el user pasado y cambia su passward en caso que
     * exista
     * 
     * @param user        el usuario al que se le quiere cambiar el password
     * @param newPassword el password al que se quiere cambiar
     * @return true si se pudo cambiar la password, false en caso contrario
     */
    public boolean updateUserPassword(User user, String newPassword) {

        for (User user2 : users) {
            if (user.equals(user2)) {
                user.setPassword(newPassword);
                return true;
            }
        }

        return false;
    }

    /**
     * Este metodo permite eliminar un usuario del sistema
     * 
     * @param user el usuario a eliminar
     * @return true si el usuario fue eliminado, false en caso contrario
     */
    public boolean deleteUser(User user) {

        for (int i = 0; i < users.length; i++) {
            if (users[i].equals(user)) {
                users[i] = null;
                return true;
            }
        }

        return false;
    }

}
