import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class count {
    public static void main(String[] args) {

        String line = null;
        String letter = "letter.txt";
        int numOfChars = 0;
        int numOfWords = 0;
        int numOfLines = 0;

        try{
            Scanner scanner = new Scanner(new File(letter));
            while(scanner.hasNextLine()) {
                line = scanner.nextLine();
                numOfLines++;
                numOfChars += line.length();
                String [] words = line.split(" ");
                numOfWords += words.length;
            }
            scanner.close();
            System.out.println("Number of lines: " + numOfLines);
            System.out.println("Number of words: " + numOfWords);
            System.out.println("Number of characters: " + numOfChars);
        }catch(FileNotFoundException e){
            e.printStackTrace();
            System.out.println("File not found");
        }
    }
}
