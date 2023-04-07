import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
public class SumNumbersFromFileScanner {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("file.txt");
        Scanner scanner = new Scanner(file);
        double sum = 0.0;
        double average = 0.0;
        int count = 0;

        try(Scanner scan = new Scanner (new File("file.txt"))){
            while(scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] number = line.split(";");
                for (String num : number) {
                    count++;
                    sum += Double.parseDouble(num.trim());
                    average = sum/count;
                }
            }
            System.out.println("The sum of the numbers is: " +sum);
            System.out.println("The average of the numbers is: " +average);

        }catch(IOException e){
            e.printStackTrace();
        }

    }

}
