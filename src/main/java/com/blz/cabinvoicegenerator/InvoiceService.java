package com.blz.cabinvoicegenerator;

import java.util.Scanner;

public class InvoiceService {
    RideRepository rideRepository=new RideRepository();
    public double calculateFare(double distance, int time, String choice) {
        int costPerMinute = 0;
        double costPerKM = 0;
        double minimumFare = 0;

        if (choice == "Normal" ) {

            costPerMinute = 1;
            costPerKM = 10;
            minimumFare = 5;

        } else if (choice == "Premium") {

            costPerMinute = 2;
            costPerKM = 15;
            minimumFare = 20;

        }

        double totalFare = distance * costPerKM + time * costPerMinute;
        return Math.max(totalFare, minimumFare);

    }

    public double calculateFare(Ride[] rides) {
        double totalFare = 0.0;
        for (Ride ride : rides) {
            totalFare += calculateFare(ride.getDistance(), ride.getTime(),"Normal");
        }
        return totalFare;
    }

    public InvoiceSummery calculateTotalFare(Ride[] rides) {
        double totalFare = calculateFare(rides);
        return new InvoiceSummery(rides.length, totalFare);
    }
    public void addRide(String userID, Ride[] rides) {
        rideRepository.addRide(userID,rides);
    }

    public InvoiceSummery getInvoiceSummery(String userID) {
        Ride[] rides=rideRepository.getRides(userID);
        return calculateTotalFare(rides);

    }
}
