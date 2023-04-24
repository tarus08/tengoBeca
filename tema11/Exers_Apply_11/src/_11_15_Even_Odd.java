import java.io.*;
import java.util.Scanner;

public class _11_15_Even_Odd {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int size = scanner.nextInt();
        int[] numbers = new int[size];

        try (ObjectOutputStream writerImpar = new ObjectOutputStream(
                new FileOutputStream("programa11_15_impar.dat"))) {
            try (ObjectOutputStream writerPar = new ObjectOutputStream(
                    new FileOutputStream("programa11_15_par.dat"))) {
                for (int i = 0; i < size; i++) {
                    System.out.println("Enter the number " + (i + 1) + " :");
                    numbers[i] = scanner.nextInt();
                    if (numbers[i] % 2 == 0) {
                        //write object is better than write int
                        writerPar.writeObject(numbers[i]);
                    } else {
                        writerImpar.writeObject(numbers[i]);
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            try (ObjectInputStream readerOdd = new ObjectInputStream(
                    new FileInputStream("programa11_15_impar.dat"))) {
                System.out.print("These are the odd numbers: ");
                boolean hasNext = true;
                while (hasNext) {
                    try {
                        int num = (int) readerOdd.readObject();
                        System.out.print(num + ", ");
                    } catch (EOFException e) {
                        hasNext = false;
                    }
                }
                System.out.println();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }

            try (ObjectInputStream readerEven = new ObjectInputStream(
                    new FileInputStream("programa11_15_par.dat"))) {
                System.out.print("These are the even numbers: ");
                boolean hasNext = true;
                while (hasNext) {
                    try {
                        int num = (int) readerEven.readObject();
                        System.out.print(num + ", ");
                    } catch (EOFException e) {
                        hasNext = false;
                    }
                }
                System.out.println();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
