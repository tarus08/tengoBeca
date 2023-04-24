import java.io.*;
import java.util.Scanner;
class _11_07_CopyBinary {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num;
        try(ObjectOutputStream output = new ObjectOutputStream(
                new FileOutputStream("numeros.dat"))){
            System.out.println("Enter a number higher than zero to continue in the loop");
            num = scanner.nextInt();
            while(num >= 0){
                output.writeInt(num);
                System.out.println("Enter a number to write in the file");
                num = scanner.nextInt();
            }
        }catch(IOException e){
            System.out.println(e);
        }
        try(ObjectInputStream input = new ObjectInputStream(new FileInputStream("numeros.dat"));
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("numerosCopia.dat"))){
            while(input.available() > 0){
                num = input.readInt();
                System.out.println("Numbers in the original: " + num);
                output.writeInt(num);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
