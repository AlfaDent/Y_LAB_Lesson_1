package org.example.controllers;

import org.example.models.User;

import java.util.ArrayList;

public class AuthenticationController {
    /**
     *
     * @param userList
     * @param login
     * @param password
     * @return
     */
    public User authUser(ArrayList<User> userList, String login, String password){
        User user = new User(login, password);
        if(userList.isEmpty()){
            System.out.println("UserList is empty. You can be the first! Register!");
            return null;
        }
        if(userList.stream().noneMatch(user1 -> user1.equals(user))){
            System.out.println("Unknown user. Register please");
            return null;
        }
        else {
            System.out.println("Successfully authenticated");
            return user;
        }
    }

    /**
     *
     * @param userList
     * @param login
     * @param password
     * @return
     */
    public User registerUser(ArrayList<User> userList, String login, String password){
        User user = new User(login, password);

        if(userList.stream().anyMatch(user1 -> user1.equals(user))){
            System.out.println("This login has already registered");
            return null;
        }
        else {
            userList.add(user);
            System.out.println("Successfully registered");
            return user;
        }
    }
}
