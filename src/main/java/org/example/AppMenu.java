package org.example;

import java.io.IOException;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AppMenu
{
    // Components (objects) used in this App
    PassengerStore passengerStore;  // encapsulates access to list of Passengers
    VehicleManager vehicleManager;  // encapsulates access to list of Vehicles
    BookingManager bookingManager;  // deals with all bookings

    public static void main(String[] args)
    {
        AppMenu app = new AppMenu();
        app.start();
    }

    public void start()
    {
        // create PassengerStore and load all passenger records from text file
        passengerStore = new PassengerStore("passengers.txt");

        // create VehicleManager, and load all vehicles from text file
        vehicleManager = new VehicleManager("vehicles.txt");

        // create bookingManager, and load all vehicles from text file
        bookingManager = new BookingManager("Booking.txt");

        try
        {
            displayMainMenu();        // User Interface - Menu
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        System.out.println("Program ending, Goodbye");
    }

    private void displayMainMenu() throws IOException
    {

        final String MENU_ITEMS = "\n*** MAIN MENU OF OPTIONS ***\n"
                + "1. Passengers\n"
                + "2. Vehicles\n"
                + "3. Bookings\n"
                + "4. Exit\n"
                + "Enter Option [1,4]";

        final int PASSENGERS = 1;
        final int VEHICLES = 2;
        final int BOOKINGS = 3;
        final int EXIT = 4;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        do
        {
            System.out.println("\n" + MENU_ITEMS);
            try
            {
                String usersInput = keyboard.nextLine();
                option = Integer.parseInt(usersInput);
                switch (option)
                {
                    case PASSENGERS:
                        System.out.println("Passengers option chosen");
                        displayPassengerMenu();
                        break;
                    case VEHICLES:
                        System.out.println("Vehicles option chosen");
                        break;
                    case BOOKINGS:
                        System.out.println("Bookings option chosen");
                        displayBookingsMenu();
                        break;
                    case EXIT:
                        System.out.println("Exit Menu option chosen");
                        break;
                    default:
                        System.out.print("Invalid option - please enter number in range");
                        break;
                }

            } catch (InputMismatchException | NumberFormatException e)
            {
                System.out.print("Invalid option - please enter number in range");
            }
        } while (option != EXIT);

        System.out.println("\nExiting Main Menu, goodbye.");

    }

    // Sub-Menu for Passenger operations
    //
    private void displayPassengerMenu()
    {
        final String MENU_ITEMS = "\n*** PASSENGER MENU ***\n"
                + "1. Show all Passengers\n"
                + "2. Add new Passenger\n"
                + "3. Find Passenger by Name\n"
                + "4. Exit\n"
                + "Enter Option [1,4]";

        final int SHOW_ALL = 1;
        final int NEW_PASSENGER = 2;
        final int FIND_BY_NAME = 3;
        final int EXIT = 4;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        Passenger p;
        do
        {
            System.out.println("\n" + MENU_ITEMS);
            try
            {
                String usersInput = keyboard.nextLine();
                option = Integer.parseInt(usersInput);
                switch (option)
                {
                    case SHOW_ALL:
                        System.out.println("Display ALL Passengers");
                        passengerStore.displayAllPassengers();
                        break;
                    case NEW_PASSENGER:
                        System.out.println("Add a passenger");
//                        System.out.println("Enter new passenger details:");
//                      hardcoded data to show system working
                        System.out.println("Name : ");
                        String name = keyboard.nextLine();
                        System.out.println("Email : ");
                        String email = keyboard.nextLine();
                        System.out.println("Phone Number : ");
                        String Phone = keyboard.nextLine();
                        System.out.println("Latitude : ");
                        double lat = keyboard.nextDouble();
                        System.out.println("Longitude : ");
                        double lon =keyboard.nextDouble();
                        p = new Passenger(name, email,
                                Phone, lat, lon);
                        passengerStore.addPassenger(p);
                        break;
                    case FIND_BY_NAME:
                        System.out.println("Find Passenger by Name");
                        System.out.println("Enter passenger name: ");
                        String name2 = keyboard.nextLine();
                        p = passengerStore.findPassengerByName(name2);
                        if (p == null)
                            System.out.println("No passenger matching the name \"" + name2 + "\"");
                        else
                            System.out.println("Found passenger: \n" + p.toString());
                        break;
                    case EXIT:
                        System.out.println("Exit Menu option chosen");
                        break;
                    default:
                        System.out.print("Invalid option - please enter number in range");
                        break;
                }
            } catch (InputMismatchException | NumberFormatException e)
            {
                System.out.print("Invalid option - please enter number in range");
            }
        } while (option != EXIT);

    }

    // Sub-Menu for Bookings operations
    //
    private void displayBookingsMenu()
    {
        final String MENU_ITEMS = "\n*** BOOKINGS MENU ***\n"
                + "1. Show all Bookings\n"
                + "2. Make a NEW Booking\n"
                + "3. Exit\n"
                + "Enter Option [1,3]";

        final int SHOW_ALL = 1;
        final int NEW_BOOKING = 2;
        final int EXIT = 3;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        Booking b;
        do
        {
            System.out.println("\n" + MENU_ITEMS);
            try
            {
                String usersInput = keyboard.nextLine();
                option = Integer.parseInt(usersInput);
                switch (option)
                {
                    case SHOW_ALL:
                        System.out.println("Display ALL Bookings");
                        bookingManager.displayAllBookings();
                        break;
                    case NEW_BOOKING:

                        System.out.println("Registering New Booking ");

                        System.out.println("Enter Your ID: ");
                        int passengerId = keyboard.nextInt();
                        System.out.println("Enter A Car ID:");
                        int vehicleId = keyboard.nextInt();
                        System.out.println("Enter Date (YEAR): ");
                        int year = keyboard.nextInt();
                        System.out.println("Enter Date (MONTH): ");
                        int month = keyboard.nextInt();
                        System.out.println("Enter Date (DAY): ");
                        int day = keyboard.nextInt();
                        System.out.println("Time (HOUR): ");
                        int hour = keyboard.nextInt();
                        System.out.println("Time (MINUTES): ");
                        int minute = keyboard.nextInt();
                        System.out.println("Starting Latitude: ");
                        double stlatitude = keyboard.nextDouble();
                        System.out.println("Starting Longitude: ");
                        double stlongitude = keyboard.nextDouble();
                        System.out.println("Ending Latitude: ");
                        double endlatitude = keyboard.nextDouble();
                        System.out.println("Ending Longitide: ");
                        double endlongitude = keyboard.nextDouble();

                        b = new Booking( passengerId, vehicleId,
                         year,  month,  day,  hour,  minute,
                         stlatitude,  stlongitude, endlatitude, endlongitude);
                        bookingManager.AddBooking(b);
                        break;
                    case EXIT:
                        System.out.println("Exit Menu option chosen");
                        break;
                    default:
                        System.out.print("Invalid option - please enter number in range");
                        break;
                }

            } catch (InputMismatchException | NumberFormatException e)
            {
                System.out.print("Invalid option - please enter number in range");
            }
        } while (option != EXIT);
        }

        // Vehicle
    private void displayViheclesMenu() {
        final String MENU_ITEMS = "\n*** VEHICLE MENU ***\n"
                + "1. Show all Vehicle\n"
                + "2. Make a NEW Vehicle\n"
                + "3. Exit\n"
                + "Enter Option [1,3]";

        final int VEHICLE = 1;
        final int NEW_VAN = 2;
        final int NEW_CAR = 3;
        final int EXIT = 4;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        Vehicle v;
        do {
            System.out.println("\n" + MENU_ITEMS);
            try {
                String usersInput = keyboard.nextLine();
                option = Integer.parseInt(usersInput);
                switch (option) {
                    case VEHICLE:
                        System.out.println("Display ALL Vehicle");
                        bookingManager.displayAllBookings();
                        break;
                    case NEW_VAN:
                        System.out.println("Registering New VAN");
                        System.out.println("The Type Of VAN: ");
                        String type = keyboard.next();
                        System.out.println("The Make Of VAN: ");
                        String make = keyboard.next();
                        System.out.println("The Model Of VAN: ");
                        String model = keyboard.next();
                        System.out.println("The milesPerKwH Of VAN: ");
                        double milesPerKwH = keyboard.nextDouble();
                        System.out.println("The registration Of VAN: ");
                        String registration = keyboard.next();
                        System.out.println("The costPerMile Of VAN: ");
                        double costPerMile = keyboard.nextDouble();
                        System.out.println("DATE (YEAR): ");
                        int year = keyboard.nextInt();
                        System.out.println("DATE (MONTH): ");
                        int month = keyboard.nextInt();
                        System.out.println("DATE (DAY): ");
                        int day = keyboard.nextInt();
                        System.out.println("The mileage Of VAN: ");
                        int mileage = keyboard.nextInt();
                        System.out.println("The latitude Of VAN: ");
                        double latitude = keyboard.nextDouble();
                        System.out.println("The longitude Of VAN: ");
                        double longitude = keyboard.nextDouble();
                        System.out.println("The loadSpace Of VAN: ");
                        int loadSpace = keyboard.nextInt();

                        v = new Van(type, make, model, milesPerKwH,
                                registration, costPerMile,
                                year, month, day,
                                mileage, latitude, longitude,
                                loadSpace);

                        vehicleManager.addVehicle(v);

                        break;
                    case NEW_CAR:

                        System.out.println("Registering New CAR");


                        System.out.println("The Type Of CAR: ");
                        String type1 = keyboard.next();
                        System.out.println("The Make Of CAR: ");
                        String make1 = keyboard.next();
                        System.out.println("The Model Of CAR: ");
                        String model1 = keyboard.next();
                        System.out.println("The milesPerKwH Of CAR: ");
                        double milesPerKwH1 = keyboard.nextDouble();
                        System.out.println("The registration Of CAR: ");
                        String registration1 = keyboard.next();
                        System.out.println("The costPerMile Of CAR: ");
                        double costPerMile1 = keyboard.nextDouble();
                        System.out.println("DATE (YEAR): ");
                        int year1 = keyboard.nextInt();
                        System.out.println("DATE (MONTH): ");
                        int month1 = keyboard.nextInt();
                        System.out.println("DATE (DAY): ");
                        int day1 = keyboard.nextInt();
                        System.out.println("The mileage Of CAR: ");
                        int mileage1 = keyboard.nextInt();
                        System.out.println("The latitude Of CAR: ");
                        double latitude1 = keyboard.nextDouble();
                        System.out.println("The longitude Of CAR: ");
                        double longitude1 = keyboard.nextDouble();
                        System.out.println("The loadSpace Of CAR: ");
                        int NoPassengers = keyboard.nextInt();

                        v = new Car( type1, make1, model1, milesPerKwH1,
                                registration1, costPerMile1,
                                year1, month1, day1,
                                mileage1, latitude1, longitude1,
                                NoPassengers);

                        vehicleManager.addVehicle(v);

                        break;
                    case EXIT:
                        System.out.println("Exit Menu option chosen");
                        break;
                    default:
                        System.out.print("Invalid option - please enter number in range");
                        break;
                }

            } catch (InputMismatchException | NumberFormatException e) {
                System.out.print("Invalid option - please enter number in range");
            }
        } while (option != EXIT);
    }
    }