package ejer_04_renting;
import java.util.Scanner;

public class Coches {
    Scanner scanner = new Scanner(System.in);

    private Garaje garage;
    private String matricula, brand, model, color;
    private double price;

    public Coches(String matricula, String brand, String model, String color, double price, Garaje garage)
    {
        this.matricula = matricula;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.price = price;
        this.garage = garage;
    }

    public void endorsment(Cliente cl)
    {
        System.out.println("Enter the data of the client who is going to help to pay: ");
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

        System.out.println("The option of letting other client pay wont be available if the original client hasnt paid mroe than half of the total amount.");
        System.out.println("how much is it left to pay?");
        double lefToPay = scanner.nextDouble();
        double result = 0;

        if (lefToPay > (price/2))
        {
            result = lefToPay - price;
        }
        else
        {
            System.out.println("The amount left to pay is lower than half of the total price, it wont be possible.");
        }
        System.out.println("This is the money left to be paid: " + result);
    }
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
