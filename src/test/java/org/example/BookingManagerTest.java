package org.example;

import junit.framework.TestCase;

public class BookingManagerTest extends TestCase {

    public void testFindById() {
        BookingManager b = new BookingManager("Booking.txt");
        int value = 111;
        int value2 = 111;
        int value3 = 111;
        String expResult = null;
        String actResult = b.FindById(value,value2,value3);
        assertEquals (expResult, actResult);
    }
}