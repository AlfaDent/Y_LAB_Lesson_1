package org.example.controllers;

import org.example.Lists.UserList;
import org.example.models.User;

import java.io.*;
import java.util.ArrayList;

public class MainController {
    private static final MeterDataController meterDataController = new MeterDataController();
    private static final AuthenticationController authenticationController = new AuthenticationController();
    private static final ArrayList<User> userList = new UserList().getUserList();
    private static User user;
    private static boolean isAuthenticated = false;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(!isAuthenticated){
            System.out.println("Chose action: ");
            System.out.println("-------------------------------------------------------");
            System.out.println("1. Auth");
            System.out.println("2. Register");
            System.out.println("3. Exit");

            try  {
                switch (reader.readLine()) {
                    case "1" -> {
                        System.out.println("Write your login: ");
                        String login = reader.readLine();
                        System.out.println("Write your password: ");
                        String password = reader.readLine();
                        user = authenticationController.authUser(userList, login, password);
                        if(user != null) isAuthenticated=true;
                    }
                    case "2" -> {
                        System.out.println("Write your login: ");
                        String login = reader.readLine();
                        System.out.println("Write your password: ");
                        String password = reader.readLine();
                        user = authenticationController.registerUser(userList, login, password);
                        if(user != null) isAuthenticated=true;
                    }
                    case "3" -> {
                        return;
                    }
                    default -> {
                        System.out.println("Incorrect action. Chose another.");
                    }
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
        while(true){
            System.out.println("Chose action: ");

            System.out.println("1. Get actual meters");
            System.out.println("2. Get all meter data");
            System.out.println("3. Get meters by month");
            System.out.println("4. Set meters");
            System.out.println("-------------------------------------------------------");
            System.out.println("Admin panel");
            System.out.println("5. Get all users");
            System.out.println("6. Get meter data by user login");
            System.out.println("0. Exit");

            try{
                switch (reader.readLine()){
                    case "1" -> {
                        System.out.println(meterDataController.getActualMeterData(user));
                    }
                    case "2" -> {
                        System.out.println(meterDataController.getMeterDataByUser(user));
                    }
                    case "3" -> {
                        System.out.println("Write month: ");
                        String month = reader.readLine();
                        System.out.println(meterDataController.getUserMeterDataByMonth(user, month));
                    }
                    case "4" -> {
                        meterDataController.setUserMeterData(user);
                    }
                    case "5" -> {
                        if(user.isAdmin()) System.out.println(userList);
                        else System.out.println("You are not admin");
                    }
                    default -> {
                        return;
                    }
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
