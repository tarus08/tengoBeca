import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class writeInTheFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert the first phrase");
        String firstLine = scanner.nextLine();
        System.out.println("Insert the second phrase");
        String secondLine = scanner.nextLine();

        try(BufferedWriter writer = new BufferedWriter(new FileWriter("file.txt"))){
            //escribir caracter a caracter
            for (int i = 0; i < firstLine.length(); i++){
                writer.write(firstLine.charAt(i));
            }
            //cambio de linea en el archivo
            writer.newLine();
            //escribirtododeuna
            writer.write(secondLine);
            writer.close();
            System.out.println("File writen successfully.");
        } catch (IOException e) {
            System.out.println("An error ocurred my guy");
            e.printStackTrace();
        }
    }
}
