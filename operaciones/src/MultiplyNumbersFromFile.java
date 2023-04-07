import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.*;
public class MultiplyNumbersFromFile {
    public static void main(String[] args) {

        File file = new File ("file2.txt");
        String line;
        int multiply = 1;

        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            while((line = reader.readLine()) != null){
                String [] numbers = line.split(";");
                for (String nums : numbers){
                    int n = Integer.parseInt(nums.trim());
                    multiply *= n;
                    System.out.println(n +" ");
                }
            }
        }catch (IOException e){
            System.err.format("IOException: ", e);
        }
        System.out.println("The result of multiplicating of the numbers is: " +multiply);



    }
}
