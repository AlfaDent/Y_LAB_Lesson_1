package org.example.Lists;

import org.example.models.User;

import java.util.ArrayList;

public class UserList {
    public ArrayList<User> getUserList() {
        return userList;
    }

    private ArrayList<User> userList = new ArrayList<>();

    @Override
    public String toString() {
        return "UserList{" +
                "userList=" + userList +
                '}';
    }
}
