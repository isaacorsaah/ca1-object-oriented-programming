package org.example;

import junit.framework.TestCase;

public class PassengerStoreTest extends TestCase {

    public void testFindPassengerByName() {
        System.out.println("Test 1");
        PassengerStore p = new PassengerStore("passengers.txt");
        String value = "name";
        Passenger expResult = null;
        Passenger actResult = p.findPassengerByName(value);
        assertEquals (expResult, actResult);
    }

    public void testFindPassengerById() {
        System.out.println("Test 2");
        PassengerStore p = new PassengerStore("passengers.txt");
        int value = 111;
        Passenger expResult = null;
        Passenger actResult = p.findPassengerById(value);
        assertEquals (expResult, actResult);
    }
}