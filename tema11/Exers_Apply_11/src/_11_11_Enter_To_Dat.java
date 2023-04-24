import java.io.*;
import java.util.Scanner;

public class _11_11_Enter_To_Dat {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(System.in);
        double inputNum;

        System.out.println("Enter a 'double' value");
        inputNum = scanner.nextDouble();

        try(ObjectOutputStream write = new ObjectOutputStream(
                new FileOutputStream("fichero11_11.dat"))){
                write.writeDouble(inputNum);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        try (ObjectInputStream reader = new ObjectInputStream(
                new FileInputStream("fichero11_11.dat"))){
            double value = reader.readDouble();
            System.out.println("This is the number: " +value);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
