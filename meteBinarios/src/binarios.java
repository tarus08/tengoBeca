import java.io.*;
import java.util.*;
public class binarios {
    public static void main(String[] args) {

        Scanner scanner = new Scanner (System.in);
        System.out.println("Enter a size");
        int size = scanner.nextInt();
        double [] array = new double[size];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter the number " +(i+1));
            array[i] = scanner.nextDouble();
        }

        File file = new File("meteBinarios.dat");

        try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("meteBinarios.dat"))){
            output.writeObject(array);
        }catch(IOException e){
            System.out.println("There was an error");
            e.getMessage();
        }
        try(ObjectInputStream input = new ObjectInputStream(new FileInputStream("meteBinarios.dat"))){
            input.readObject();
            System.out.println("This is the messy code:");
            for (int i = 0; i < size; i++) {
                System.out.println("This is the number " +(i+1)+ ": " +array[i]);
            }
            System.out.println(" ");

            System.out.println("This is the cleaner code:");
            for (double numbers : array) {
                System.out.println("These are the numbers: "+numbers);
            }
        }catch(ClassNotFoundException | IOException e){
            e.getMessage();
        }
    }
}
