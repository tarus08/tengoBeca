package ejer_04_renting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Reserva {

    Scanner scanner = new Scanner (System.in);
    private FechaInic fechaInic;
    private FechaFin fechaFin;
    private List <Coches> cars;
    private Garaje garage;
    private List <Cliente> client;
    private Agency agency;

    public void reserve (Coches cars, Cliente cl)
    {
        //clients
        System.out.println("Enter the data of the client: ");
        System.out.println("ID: ");
        String idClient = scanner.nextLine();
        System.out.println("DNI: ");
        String dniClient = scanner.nextLine();
        System.out.println("Name: ");
        String nameClient = scanner.nextLine();
        System.out.println("Address: ");
        String addresClient = scanner.nextLine();
        System.out.println("Phone number: ");
        int phoneNumberClient = scanner.nextInt();
        cl = new Cliente(idClient, dniClient, nameClient, addresClient, phoneNumberClient);

        System.out.println("How many cars will you rent, " +nameClient+" ?");
        int numOfCars = scanner.nextInt();

        double totalPrice = 0.;
        for (int i = 0; i < numOfCars; i++)
        {
            //cars
            System.out.println("Enter the data for the cars: ");
            System.out.println("License plate number: ");
            String licensePlate = scanner.nextLine();
            System.out.println("Brand: ");
            String brand = scanner.nextLine();
            System.out.println("Model: ");
            String model = scanner.nextLine();
            System.out.println("Color: ");
            String color = scanner.nextLine();
            System.out.println("Price: ");
            double price = scanner.nextDouble();
            scanner.nextLine();

            //garage
            System.out.println("Enter the address of the garage: ");
            String address = scanner.nextLine();
            System.out.println("How many parking slots does this garage have?");
            int numParkingSlot = scanner.nextInt();
            System.out.println("Enter the parking lot id for this car: ");
            Map<String, String> mapParking = new HashMap<String, String>();
            String parkingLotId = scanner.nextLine();
            mapParking.put(parkingLotId, licensePlate);
            garage = new Garaje(address, numParkingSlot, mapParking);

            cars = new Coches(licensePlate, brand, model, color, price, garage);
            totalPrice +=price;
        }
        System.out.println("The total price of the reserva is going to be: " + totalPrice);
    }
}
