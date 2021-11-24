package org.example;

import java.io.File;
import java.io.IOException;
import java.time.Month;
import java.util.ArrayList;
import java.util.Scanner;

public class BookingManager
{
    private final ArrayList<Booking> bookingList;
    private PassengerStore passengerStore;
    private VehicleManager vehicleManager;

    // Constructor
    public BookingManager() {
        this.bookingList = new ArrayList<>();
        this.vehicleManager = null;
        this.passengerStore = null;
    }

    public void loadPassengerFromFile(String fileName) {
        try {
            Scanner sc = new Scanner(new File(fileName));

            sc.useDelimiter("[,\r\n]+");

            while (sc.hasNext()) {
                int bookingId = sc.nextInt();
                int passengerId = sc.nextInt();
                int vehicleId = sc.nextInt();
                int year = sc.nextInt(); // date
                int month = sc.nextInt();
                int day = sc.nextInt();
                int hour = sc.nextInt();
                int minute = sc.nextInt();
                double stlatitude = sc.nextDouble();  // Depot GPS location
                double stlongitude = sc.nextDouble();
                double endlatitude = sc.nextDouble();  // Depot GPS location
                double endlongitude = sc.nextDouble();


            }
            sc.close();

        } catch (IOException e) {
            System.out.println("Exception thrown. " + e);
        }
    }

    //TODO implement functionality as per specification

    // Getters
    public ArrayList getBookingList(){
        return this.bookingList;
    }
    public PassengerStore getPassengerStore(){
        return this.passengerStore;
    }
    public VehicleManager getVehicleManager(){
        return this.vehicleManager;
    }
}
