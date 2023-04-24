import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class _11_19_Llamadas_12_36 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numOfCalls = new ArrayList<Integer>();

        try (ObjectInputStream reader = new ObjectInputStream(
                new FileInputStream("calls.dat"))){
            numOfCalls = (ArrayList<Integer>) reader.readObject();
        } catch (IOException e){
            System.out.println("There is an error reading 01");
        } catch (ClassNotFoundException e) {
            System.out.println("There is an error reading 02");
            throw new RuntimeException(e);
        }

        int choice;
        do {
            System.out.println("Enter '1' to add a new number of calls, '2' to show the numbers");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("How many numbers of calls do you want to store?");
                    int numberOfCalls = scanner.nextInt();

                    for (int i = 0; i < numberOfCalls; i++) {
                        System.out.println("Enter the number of calls in a day");
                        int num = scanner.nextInt();
                        numOfCalls.add(num);
                    }

                    try (ObjectOutputStream writer = new ObjectOutputStream(
                            new FileOutputStream("numOfCalls.dat"))) {
                        writer.writeObject(numOfCalls);
                    } catch (Exception e) {
                        System.out.println("There was an error writing: " + e.getMessage());
                    }

                    break;

                case 2:
                    System.out.println("This is the number of calls: " + numOfCalls.toString());
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice == 1 || choice == 2);
    }
}
