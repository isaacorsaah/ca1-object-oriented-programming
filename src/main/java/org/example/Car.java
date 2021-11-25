package org.example;

import java.time.LocalDate;

public class Car extends Vehicle{
    private int NoPassengers;

    // Constructor with ID Gen
    public Car(String type, String make, String model, double milesPerKwH,
                   String registration, double costPerMile,
                   int year, int month, int day,
                   int mileage, double latitude, double longitude)
    {
      super( type,  make,  model,  milesPerKwH,
         registration,  costPerMile,
         year,  month,  day,
         mileage,  latitude,  longitude);

        this.NoPassengers = 4;
    }

    // Default Constructor
    public Car(int id, String type, String make, String model, double milesPerKwH,
               String registration, double costPerMile,
               int year, int month, int day,
               int mileage, double latitude, double longitude)
    {

        super( id,type,  make,  model,  milesPerKwH,
                registration,  costPerMile,
                year,  month,  day,
                mileage,  latitude,  longitude);

        this.NoPassengers = 4;

    }

    // Getters/Print
    public int getNoPassenger(){
        return this.NoPassengers;
    }

    // Setter/Edit
    public void setNoPassenger(int NoPassenger){
        this.NoPassengers = NoPassenger;
    }
    // Delete
    public void DelNoPassenger(){
        this.NoPassengers = 0;
    }

    @Override
    public double CostPerMile(){
        double total = 0;

        if(super.toString().equalsIgnoreCase("Car")){
            total = super.getMilesPerKm()*2;
        }else{
            total = super.getMilesPerKm()*4;
        }

        return total;
    }

    @Override
    public String toString(){
        return super.toString() + " Passengers: " + this.NoPassengers;
    }

}
