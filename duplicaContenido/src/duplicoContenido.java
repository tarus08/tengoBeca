import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class duplicoContenido {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String inputFile = "file.txt";
        String outputFile = "";
        String content = "";
        String line;

        String copyContent = " ";
        try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
            while ((line = reader.readLine()) != null) {
                content += line + "\n";
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("There was an error");
        }

        System.out.println("Tell me the name of the new file");
        String name = scanner.nextLine();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(name+"copy_of_file.txt"))){
            writer.write(content);
            writer.close();
            System.out.println("The file was successfully copied");
        }catch(IOException e) {
            System.out.println("An error ocurred writing");
            e.printStackTrace();
        }
    }
}
