import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

//el enunciado te pide que leas un fichero
// binario, pero no se puede escribir en el,
// asi que los metera el usuario
public class _11_12_Show_Content_Dat {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size for the array");
        int size = scanner.nextInt();

        try (ObjectOutputStream writer = new ObjectOutputStream(
                new FileOutputStream("fichero11_13.dat"))) {

            double [] numbers = new double[size];

            //write the values in the file
            for (int i = 0; i < size; i++) {
                System.out.println("Enter the values");
                numbers[i] = scanner.nextDouble();
                writer.writeDouble(numbers[i]);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        //read and show the numbers in the file
        try(ObjectInputStream reader = new ObjectInputStream(
                new FileInputStream("fichero11_13.dat"))){

            double[] nums = new double[size];

            for (int i = 0; i < nums.length; i++) {
                nums[i] = reader.readDouble();
            }

            System.out.println("This is the array: " + Arrays.toString(nums));

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
