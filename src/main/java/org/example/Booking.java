package org.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

class Booking
{
    private int bookingId;
    private int passengerId;
    private int vehicleId;
    private LocalDateTime bookingDateTime;
    private LocationGPS startLocation;
    private LocationGPS endLocation;

    private double cost;  //Calculated at booking time
    private IdGenerator idGenerator = IdGenerator.getInstance("next-id-store.txt");


    //TODO - see specification

    //Constructor default
    public Booking(int bookingId, int passengerId, int vehicleId,
                   int year, int month, int day, int hour, int minute,
                   double stlatitude, double stlongitude, double endlatitude, double endlongitude)
    {
        this.bookingId = bookingId;
        this.passengerId = passengerId;
        this.vehicleId = vehicleId;
        this.bookingDateTime = LocalDateTime.of(day,month,year,hour,minute);
        this.startLocation = new LocationGPS(stlatitude,stlongitude);
        this.endLocation = new LocationGPS(endlatitude,endlongitude);
    }
    //Constructor Randon booking ID Gen
    public Booking(int passengerId,int vehicleId, LocalDateTime bookingDateTime,
                   int year, int month, int day, int hour, int minute,
                   double stlatitude, double stlongitude,double endlatitude, double endlongitude)
    {
        this.bookingId = idGenerator.getNextId();;
        this.passengerId = passengerId;
        this.vehicleId = vehicleId;
        this.bookingDateTime = LocalDateTime.of(day,month,year,hour,minute);
        this.startLocation = new LocationGPS(stlatitude,stlongitude);
        this.endLocation = new LocationGPS(endlatitude,endlongitude);
    }

    // Getters & Print
    public int getBookingId(){
        return this.bookingId;
    }
    public int getPassengerId(){
        return this.passengerId;
    }
    public int getVehicleId(){
        return this.vehicleId;
    }
    public LocalDateTime getBookingDateTime() {
        return this.bookingDateTime;
    }
    public LocationGPS getStartLocation(){
        return this.startLocation;
    }
    public LocationGPS getEndLocation() {
        return endLocation;
    }

    // Setters/Edit
    public void setBookingId(int s){
        this.bookingId = s;
    }
    public void setPassengerId(int s){
         this.passengerId = s;
    }
    public void setVehicleId(int s){
         this.vehicleId = s;
    }
    public void setBookingDateTime(LocalDateTime s) {
         this.bookingDateTime = s;
    }
    public void setStartLocation(LocationGPS s){
         this.startLocation = s;
    }
    public void setEndLocation(LocationGPS s) {
         endLocation = s;
    }

    // DELETE
    public void delBookingId(){
        this.bookingId = 0;
    }
    public void delPassengerId(){
        this.passengerId = 0;
    }
    public void delVehicleId(){
        this.vehicleId = 0;
    }
    public void delBookingDateTime() {
        this.bookingDateTime = null;
    }
    public void delStartLocation(){
        this.startLocation = null;
    }
    public void delEndLocation() {
        endLocation = null;
    }

    @Override
    public String toString(){
        return "ID: " + this.bookingId + " Passenger ID: " + this.passengerId + " Vehicle ID: " + this.vehicleId
                + " DATE: " + this.bookingDateTime + " Start At: " +this.startLocation + " END At:" +this.endLocation;
    }
}
