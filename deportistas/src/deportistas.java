import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class deportistas {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("deportistas.txt");
        Scanner scanner = new Scanner(file);
        double sumAge = 0.0;
        double sumWeight = 0.0;
        double sumHeight = 0.0;

        int count = 0;

        try(Scanner scan = new Scanner(
                new File("deportistas.txt"))){
            while(scan.hasNextLine()){
                String line = scan.nextLine();
                String [] number = line.split("\\t");
                if(number.length == 3){
                    try{
                        int age = Integer.parseInt(number[0]);
                        double height = Double.parseDouble(number[1]);
                        double weight = Double.parseDouble(number[2]);
                        sumAge += age;
                        sumHeight += height;
                        sumWeight += weight;
                        count++;
                    }catch(Exception e){
                        System.out.println("There was an error 1");
                    }
                }
            }
            if (count > 0){
                double avgAge = sumAge/count;
                System.out.println("This is the average age:  " + avgAge);
                double avgWeight = sumWeight/count;
                System.out.println("This is the average weight: " + avgWeight);
                double avgHeight = sumHeight/count;
                System.out.println("This is the average height: " + avgHeight);
            }else{
                System.out.println("No values found");
            }
        }catch(Exception e){
            System.out.println("There was an error 2");
            e.getMessage();
        }
    }
}
