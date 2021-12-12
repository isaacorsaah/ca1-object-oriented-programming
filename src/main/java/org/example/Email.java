package org.example;

import java.util.ArrayList;

public class Email {
    private PassengerStore passengerStore;
    private BookingManager bookingmanager;
    private ArrayList<Booking> bookings;

    public Email(Booking b){
        this.bookingmanager = new BookingManager();
        this.bookings = new ArrayList<>();
        this.bookings.add(b);
    }

    public void sendEmail(){
        for(Booking b: bookings){
            System.out.println(b.toString());
        }
    }

}
