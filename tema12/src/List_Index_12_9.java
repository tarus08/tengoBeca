import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class List_Index_12_9 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Integer> numbersList = new ArrayList<Integer>();

        System.out.println("Enter positive numbers");
        Integer numbers = scanner.nextInt();
        while (numbers >= 0) {
            numbersList.add(numbers);
            System.out.println("Enter positive numbers");
            numbers = scanner.nextInt();
        }

        System.out.println(numbersList);

        for (int i = 0; i < numbersList.size(); i++){
            if (numbersList.get(i) % 2 == 0){
                System.out.print("These are the indexes of the even numbers: " +i+ ", ");
                numbersList.set(i, numbersList.get(i) * 100);
            }
        }
        System.out.println();
        System.out.println(numbersList);
    }
}
