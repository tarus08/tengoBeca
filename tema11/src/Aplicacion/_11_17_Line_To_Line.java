package Aplicacion;

import java.io.*;
import java.util.Scanner;

public class _11_17_Line_To_Line {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String text;
        String filename = "lineToLine.dat";

        try (ObjectOutputStream writer = new ObjectOutputStream(
                new FileOutputStream(filename))) {
            do {
                System.out.println("Write a text");
                text = scanner.nextLine();
                writer.writeUTF(text);
                writer.writeUTF(System.lineSeparator());
            } while (!text.isBlank());
            System.out.println("You entered a blank space, the loop ends here");
        } catch (Exception e) {
            System.out.println("There was an error " + e.getMessage());
        }

        try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(filename))) {
            String readText;
            while ((readText = reader.readUTF()) != null) {
                System.out.println(readText);
            }
        } catch (EOFException e) {
            System.out.println("End of file reached");
        } catch (Exception e) {
            System.out.println("There was an error " + e.getMessage());
        }
    }
}
