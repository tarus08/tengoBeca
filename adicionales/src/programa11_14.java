import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class programa11_14 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner (System.in);
        System.out.println("Enter a phrase");
        String phrase = scanner.nextLine();

        try (ObjectOutputStream write = new ObjectOutputStream(
                new FileOutputStream("programa11_14.dat"))){
            write.writeChars(phrase);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

        try(ObjectInputStream reader = new ObjectInputStream((
                new FileInputStream("programa11_14.dat")))){
            reader.readLine();
            System.out.println(phrase);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
