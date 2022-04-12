package com.blz.cabinvoicegenerator;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceServiceTest {
    InvoiceService invoiceService = new InvoiceService();

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double totalFare = invoiceService.calculateFare(2.0, 5);
        Assert.assertEquals(25, totalFare, 0);
    }

    @Test
    public void givenDistanceAndTime_ShouldReturnMinimumTotalFare() {
        double totalFare = invoiceService.calculateFare(0.1, 1);
        Assert.assertEquals(5, totalFare, 0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnTotalFare() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(5.0, 10),
                new Ride(0.1, 1),
                new Ride(20, 60)};
        double totalFare = invoiceService.calculateFare(rides);
        Assert.assertEquals(350, totalFare, 0);
    }
    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummery() {
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(5.0, 10)};
        InvoiceSummery invoiceSummery = invoiceService.calculateTotalFare(rides);
        InvoiceSummery expectedInvoice=new InvoiceSummery(2,85);
        Assert.assertEquals(expectedInvoice,invoiceSummery);
    }
}

