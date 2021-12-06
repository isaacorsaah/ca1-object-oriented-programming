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
    public BookingManager(String fileName) {
        this.bookingList = new ArrayList<>();
        this.vehicleManager = null;
        this.passengerStore = null;
        loadBookingFromFile(fileName);
    }
    public BookingManager() {
        this.bookingList = new ArrayList<>();
        this.vehicleManager = null;
        this.passengerStore = null;
    }

    public void loadBookingFromFile(String fileName) {
        try {
            Scanner sc = new Scanner(new File(fileName));

            sc.useDelimiter("[,\r\n]+");

            while (sc.hasNext()) {
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

                // Adding to Booking List..
                bookingList.add(new Booking(passengerId,vehicleId,year,month,day,hour,minute,stlatitude,stlongitude,endlatitude,endlongitude));
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

    public void AddBooking(Booking b){
        boolean found = false;
        if(passengerStore.findPassengerById(b.getPassengerId()) != null){
            if(vehicleManager.findVehicleById(b.getVehicleId()) != null){
                found = true;
            }
        }

        if(found == true){
            System.out.println("Booking Added!");
            bookingList.add(b);
        }else{
            System.out.println("ERROR!! Passenger Or Vehicle Exist!");
        }

    }
    public void displayAllBookings(){
        for(Booking b : bookingList){
            System.out.println(b.toString());
        }
    }
    public String FindById(int id){
        String found = null;
        for(Booking b: bookingList){
            if(b.getBookingId() == id || b.getPassengerId() == id || b.getVehicleId() == id){
                found = b.toString();
            }
        }
        return found;
    }

        public double avgLatitude(){
            double total = 0;
            double counter = 0;
            for(Booking b: bookingList ) {
                total = b.getStartLocation().getLatitude() - b.getEndLocation().getLatitude();
                counter += total;
            }
            return counter/this.bookingList.size();
        }
    public double avgLongitude(){
        double total = 0;
        double counter = 0;
        for(Booking b: bookingList ) {
            total = b.getStartLocation().getLongitude() - b.getEndLocation().getLongitude();
            counter += total;
        }
        return counter/this.bookingList.size();
    }

    public void deleteByVicId(int vehicleID){
        for(Booking b: bookingList){
            if(b.getVehicleId() == vehicleID){
                b = null;
            }
        }
        displayAllBookings();
    }



}
