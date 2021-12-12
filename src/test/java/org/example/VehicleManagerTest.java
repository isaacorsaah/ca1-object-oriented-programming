package org.example;

import junit.framework.TestCase;

import java.util.ArrayList;

public class VehicleManagerTest extends TestCase {

    public void testFindVehicleById() {
        System.out.println(" Test 1..");
        VehicleManager v = new VehicleManager("vehicles.txt");
        int value = 112;
        Vehicle expResult = null;
        Vehicle actResult = v.findVehicleById(value);
        assertEquals (expResult, actResult);
    }

    public void testFindVehicleByMake() {
        System.out.println(" Test 2..");
        VehicleManager v = new VehicleManager("vehicles.txt");
        String value = "Fiat";
        Vehicle expResult = null;
        Vehicle actResult = v.findVehicleByMake(value);
        assertEquals (expResult, actResult);
    }

    public void testSameMake() {
        System.out.println(" Test 3..");
        VehicleManager v = new VehicleManager("vehicles.txt");
        String value = "Fiat";
        ArrayList<Vehicle>  expResult = null;
        ArrayList<Vehicle> actResult = v.sameMake(value);
        assertEquals (expResult, actResult);
    }
}