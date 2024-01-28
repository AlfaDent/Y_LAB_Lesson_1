package org.example.controllers;

import org.example.models.Meter;
import org.example.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MeterDataController {
    /**
     *
     * @param user
     * @return
     */
    public Meter getActualMeterData(User user){
        ArrayList<Meter> meterData = user.getUserMeterData();

        if(meterData.isEmpty()){
            System.out.println("There is no data yet");
            return null;
        }
        return user.getUserMeterData().get(meterData.size()-1);
    }

    /**
     *
     * @param user
     * @return
     */
    public List<Meter> getMeterDataByUser(User user){
        return user.getUserMeterData();
    }

    /**
     *
     * @param user
     * @param month
     * @return
     */
    public Meter getUserMeterDataByMonth(User user, String month){
        return user.getUserMeterData().stream().filter(meter -> meter.getMonth().equals(month)).findFirst().get();
    }

    /**
     *
     * @param user
     */
    public void setUserMeterData(User user){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Meter> meterData = user.getUserMeterData();
        Meter meter = new Meter(user);
        meter.setUser(user);

        System.out.println("Write month: ");
        String month = scanner.nextLine();
        if(user.getUserMeterData().stream().anyMatch(meter1 -> meter1.getMonth().equals(month))) {
            System.out.println("You can't rewrite meter data!");
            return;
        }
        else meter.setMonth(month);

        System.out.println("Write heating meters: ");
        meter.setHeating(scanner.nextInt());

        System.out.println("Write cold water meters: ");
        meter.setColdWater(scanner.nextInt());

        System.out.println("Write hot water meters: ");
        meter.setHotWater(scanner.nextInt());

        meterData.add(meter);
    }
}
