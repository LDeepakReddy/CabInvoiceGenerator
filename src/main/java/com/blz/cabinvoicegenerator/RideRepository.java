package com.blz.cabinvoicegenerator;

import java.util.HashMap;
import java.util.Map;

public class RideRepository {
    Map<String, Ride[]> userRide = new HashMap<>();

    public void addRide(String userId, Ride[] rides) {
        userRide.put(userId, rides);
    }

    public Ride[] getRides(String userID) {
        return userRide.get(userID);
    }
}


