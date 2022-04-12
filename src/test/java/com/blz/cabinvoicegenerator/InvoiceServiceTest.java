package com.blz.cabinvoicegenerator;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceServiceTest {
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        InvoiceService invoiceService=new InvoiceService();
        double totalFare= invoiceService.calculateFare(2.0,5);
        Assert.assertEquals(25,totalFare,0);

    }
}
