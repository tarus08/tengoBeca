package ejer_04_renting;

import java.time.LocalDate;
import java.util.Scanner;

public class FechaFin {
    Scanner scanner = new Scanner(System.in);
    private LocalDate end;
    private int gasLitre;
    public FechaFin(LocalDate end, int gasLitre) {
        this.end = end;
        this.gasLitre = gasLitre;
    }
    public void returned(Coches car)
    {
        System.out.println("It looks like this contract has come to an end, enter the license plate of the car to return: ");
        String licensePlate = scanner.nextLine();
        if (licensePlate.equals(car.getMatricula()))
        {
            System.out.println("The car with this license plate number: " + licensePlate + " was returned.");
        }
        else
        {
            System.out.println("The car with that license plate number doesn't exist.");
        }
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public int getGasLitre() {
        return gasLitre;
    }

    public void setGasLitre(int gasLitre) {
        this.gasLitre = gasLitre;
    }
}
