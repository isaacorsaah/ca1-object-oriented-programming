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

    public void AddBooking(int passengerId,int vehicleId,
                           int year, int month, int day, int hour, int minute,
                           double stlatitude, double stlongitude,double endlatitude, double endlongitude){

        bookingList.add(new Booking(passengerId,vehicleId,year,month,day,hour,minute,stlatitude,stlongitude,endlatitude,endlongitude));

    }
    public void showAllBooking(){
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
}
