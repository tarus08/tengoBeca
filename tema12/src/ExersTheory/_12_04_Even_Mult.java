package ExersTheory;

import java.util.*;

public class _12_04_Even_Mult {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Integer> even = new ArrayList<>();
        List<Integer> multiplesOf3 = new ArrayList<Integer>();
        Integer numbersEntered = 0;
        Collection<Integer> numbersList = new ArrayList<>();

        do{
            System.out.println("Enter positive numbers ");
            numbersEntered = scanner.nextInt();
            if (numbersEntered > 0){
                numbersList.add(numbersEntered);
            }
        }while(numbersEntered > 0);

        for(Integer nums : numbersList){
            if (nums % 2 == 0){
                even.add(nums);
            }else if(nums % 3 == 0){
                multiplesOf3.add(nums);
            }
        }

        System.out.println("Original collection: " +numbersList);
        System.out.println("Even numbers: " +even+ " , multiples of 3: " +multiplesOf3);
        numbersList.removeAll(multiplesOf3);
        System.out.println("The collection without the multiples of 3: " +numbersList);

    }
}
