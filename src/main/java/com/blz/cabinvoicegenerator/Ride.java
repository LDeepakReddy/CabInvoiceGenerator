package com.blz.cabinvoicegenerator;

public class Ride {
    private double distance;
    private int time;
    private String choice;

    public Ride(double distance, int time,String choice) {
        this.distance = distance;
        this.time = time;
        this.choice=choice;

    }

    public double getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }
}
