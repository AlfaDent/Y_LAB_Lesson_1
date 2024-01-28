package org.example.models;

public class Meter {
    private User user;
    private String month;
    private int heating;
    private int coldWater;
    private int hotWater;

    public Meter(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getHeating() {
        return heating;
    }

    public void setHeating(int heating) {
        this.heating = heating;
    }

    public int getColdWater() {
        return coldWater;
    }

    public void setColdWater(int coldWater) {
        this.coldWater = coldWater;
    }

    public int getHotWater() {
        return hotWater;
    }

    public void setHotWater(int hotWater) {
        this.hotWater = hotWater;
    }

    @Override
    public String toString() {
        return "Meter{" +
                "month=" + month +
                ", heating='" + heating + '\'' +
                ", coldWater='" + coldWater + '\'' +
                ", hotWater='" + hotWater + '\'' +
                '}';
    }
}
