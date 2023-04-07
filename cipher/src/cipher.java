import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class cipher {
    public static void main(String[] args) {

        String line = null;
        File cipherFile = new File("cipherFile.txt");
        String content = "";
        String output = "cipheredMessage.txt";

        try {
            // Read the content of the input file
            BufferedReader reader = new BufferedReader(new FileReader(cipherFile));
            StringBuilder fileContent = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                fileContent.append(line);
            }
            reader.close();

            // Write random characters to the output file
            BufferedWriter writer = new BufferedWriter(new FileWriter(output));
            for (int i = 0; i < fileContent.length(); i++) {
                char c = fileContent.charAt(i);
                if (Character.isWhitespace(c)) {
                    writer.write(c);
                } else {
                    char randomChar = (char) ('a' + (new Random()).nextInt(26));
                    writer.write(randomChar);
                }
            }
            writer.close();

            System.out.println("Randomized text written to " + output);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("An error occurred while reading or writing the files");
        }
    }
}