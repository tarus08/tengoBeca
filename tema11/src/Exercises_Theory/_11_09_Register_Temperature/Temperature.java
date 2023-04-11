package Exercises_Theory._11_09_Register_Temperature;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class Temperature {
    public static void main(String[] args) {

        double temperature = 0;

        try(ObjectInputStream reader = new ObjectInputStream(
                new FileInputStream("temperature.dat"))){
            reader.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Register[] reg = new Register[0];
        Scanner scanner = new Scanner(System.in);

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("temperature.dat"))) {
            reg = (Register[]) in.readObject();
        } catch (EOFException e) {
            // el archivo está vacío, no hay nada que leer
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        int choice;
        do {
            System.out.println("Choose one");
            System.out.println("1. New register");
            System.out.println("2. Show register");
            System.out.println("3. Out");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the temperature");
                    temperature = scanner.useLocale(Locale.US).nextDouble();
                    LocalDateTime time = LocalDateTime.now(); // Obtener la fecha/hora actual
                    Register newRegister = new Register(temperature, time); // Crear un nuevo registro con la temperatura y la fecha/hora actual
                    reg = Arrays.copyOf(reg, reg.length + 1);
                    reg[reg.length - 1] = newRegister;
                    break;

                case 2:
                    for (int i = 0; i < reg.length; i++){
                        System.out.println(reg[i].toString()); // Mostrar la temperatura y la fecha/hora de cada registro en el arreglo
                    }
                    break;

                case 3:
                    System.out.println("Program finished");
                    break;
            }
        } while (choice != 3);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("temperature.dat"))) {
            out.writeObject(reg);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
