import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class countBetter {
    public static void main(String[] args) {
        String filename = "letter.txt";
        File file = new File(filename);
        StringBuilder fileContent = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                //append adds the current line of the text and a new line character to
                // the StringBuilder object, storing the content in fileContent
                fileContent.append(line).append("\n");
            }
            System.out.println("This is the content of the file: \n" + fileContent.toString());

            // Counting characters, words, and lines
            int numOfChars = fileContent.length();
            //converts the content, stringbuilder to stringa and then splits the words with split
            // the '\\s' is used to split the string, including spaces, whitespace characters
            //tabs and line breaks.
            int numOfWords = fileContent.toString().split("\\s+").length;
            //the same but the string is split with the '\\s', that matches
            // the newline character
            int numOfLines = fileContent.toString().split("\n").length;

            System.out.println("Number of lines: " + numOfLines);
            System.out.println("Number of words: " + numOfWords);
            System.out.println("Number of characters: " + numOfChars);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error reading file");
        }
    }
}
