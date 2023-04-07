package programa11_30;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Jornada> jornadaList = new ArrayList<Jornada>();

        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream("jornada.dat"))) {
            jornadaList = (List<Jornada>) reader.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }

        int dniClave = 1;
        int dniJornada = 0;

        System.out.println("How many working days do you want?");
        int numWorkingDays = scanner.nextInt();

        Jornada [] jornadaArray = new Jornada[numWorkingDays];
        boolean exitLooop = false;

        do {
            //dni
            System.out.println("Enter the dni for the working day; enter '1' to exit");
            dniJornada = scanner.nextInt();
            if (dniJornada == dniClave){
                exitLooop = true;
                break;
                
            }else{
                for (int i = 0; i < numWorkingDays; i++) {
                    //beginning
                    LocalDateTime beginningWorkDay = LocalDateTime.now();

                    //end
                    LocalDateTime endWorkDay = LocalDateTime.now();

                    System.out.println("The dni of the work day: " +dniJornada);
                    System.out.println("The beginning of the work day: " + beginningWorkDay);
                    System.out.println("The end of the work day: " + endWorkDay);

                    //add to the list and to the array because that is the statement for the exercise
                    Jornada jornadaNormal = new Jornada(dniJornada, beginningWorkDay, endWorkDay);
                    jornadaArray[i] = jornadaNormal;
                    jornadaList.add(jornadaNormal);
                }
            }
        } while (!exitLooop);

        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("jornada.dat"))) {
            writer.writeObject(jornadaList);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
