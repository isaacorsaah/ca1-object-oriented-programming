package org.example;

import java.time.LocalDate;

public class Car extends Vehicle{
    private final int NoOfSits;

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
      this.NoOfSits = 4;
    }

    // Default Constructor
    public Car(int id, String type, String make, String model, double milesPerKwH,
               String registration, double costPerMile,
               int year, int month, int day,
               int mileage, double latitude, double longitude,int NoOfSits)
    {

        super( id,type,  make,  model,  milesPerKwH,
                registration,  costPerMile,
                year,  month,  day,
                mileage,  latitude,  longitude);

        this.NoOfSits = NoOfSits;

    }
    @Override
    public double CostPerMile(){
        return super.getMilesPerKm()*2;
    }


}
