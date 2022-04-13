package com.blz.cabinvoicegenerator;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceServiceTest {
    InvoiceService invoiceService = new InvoiceService();


    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double totalFare = invoiceService.calculateFare(2.0, 5, "Normal");
        Assert.assertEquals(25, totalFare, 0);
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnMinimumTotalFare() {
        double totalFare = invoiceService.calculateFare(0.1, 1, "Normal");
        Assert.assertEquals(5, totalFare, 0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnTotalFare() {
        Ride[] rides = {new Ride(2.0, 5, "Normal"),
                new Ride(5.0, 10, "Normal"),
                new Ride(0.1, 1, "Normal"),
                new Ride(20, 60, "Normal")};
        double totalFare = invoiceService.calculateFare(rides);
        Assert.assertEquals(350, totalFare, 0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummery() {
        Ride[] rides = {new Ride(2.0, 5, "Normal"),
                new Ride(5.0, 10, "Normal")};
        InvoiceSummery invoiceSummery = invoiceService.calculateTotalFare(rides);
        InvoiceSummery expectedInvoice = new InvoiceSummery(2, 85);
        Assert.assertEquals(expectedInvoice, invoiceSummery);
    }

    @Test
    public void givenUserID_ShouldReturnInvoiceSummeryForParticularUser() {
        String userID = "Deepak";
        Ride[] rides = {new Ride(2.0, 5, "Normal"),
                new Ride(5.0, 10, "Normal")};
        invoiceService.addRide(userID, rides);
        InvoiceSummery invoiceSummery = invoiceService.getInvoiceSummery(userID);
        InvoiceSummery expectedInvoice = new InvoiceSummery(2, 85);
        Assert.assertEquals(expectedInvoice, invoiceSummery);
    }

    @Test
    public void givenUserID_ShouldReturnInvoiceSummeryForParticularUsers() {
        String userID1 = "tejaswini";
        Ride[] rides = {new Ride(5.0, 15, "Normal"),
                new Ride(7.0, 50, "Normal")};
        invoiceService.addRide(userID1, rides);
        InvoiceSummery invoiceSummery = invoiceService.getInvoiceSummery(userID1);
        InvoiceSummery expectedInvoice = new InvoiceSummery(2, 185);
        Assert.assertEquals(expectedInvoice, invoiceSummery);
    }

    @Test
    public void ifSelectedPremiumRides_ShouldReturnPremiumPrices() {
        double distance = 5.0;
        int time = 10;
        double totalFare = invoiceService.calculateFare(distance, time, "Premium");

        Assert.assertEquals(95, totalFare, 0.0);

    }
    @Test
    public void givenDistanceAndTime_ShouldReturnMinimumTotalFareforPremium() {
        double totalFare = invoiceService.calculateFare(0.1, 1, "Premium");
        Assert.assertEquals(20, totalFare, 0);
    }

}

