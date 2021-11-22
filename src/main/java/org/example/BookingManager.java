package org.example;

import java.util.ArrayList;

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
