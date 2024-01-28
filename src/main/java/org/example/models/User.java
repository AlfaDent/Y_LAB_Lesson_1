package org.example.models;

import java.util.ArrayList;
import java.util.Objects;

public class User {
    private String login;
    private String password;
    private boolean isAdmin;
    private ArrayList<Meter> userMeterData = new ArrayList<>();

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public ArrayList<Meter> getUserMeterData() {
        return userMeterData;
    }

    public boolean isAdmin() {
        if(this.login.equals("admin") && this.password.equals("admin")){
            this.isAdmin = true;
            return true;
        }
        else return false;
//        return this.login.equals("admin") && this.password.equals("admin");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return login.equals(user.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                ", userMeterData=" + userMeterData +
                '}';
    }
}
