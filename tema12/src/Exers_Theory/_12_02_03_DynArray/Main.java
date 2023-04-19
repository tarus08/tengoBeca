package Exers_Theory._12_02_03_DynArray;

import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        DynamicArray<Integer> dynArray = new DynamicArray<>(new Integer[0]);

        for(int i = 0; i < 3; i++){
            System.out.println("Enter the number (end) " +(i+1));
            Integer numbers = scanner.nextInt();
            dynArray.addEnd(numbers);
            System.out.println(dynArray);
        }

        for(int i = 0; i < 3; i++){
            System.out.println("Enter the number (beginning) " +(i+1));
            Integer numbers = scanner.nextInt();
            dynArray.addBeginning(numbers);
            System.out.println(dynArray);
        }

        System.out.println("Without sorting the array: " +dynArray);
        dynArray.sort();
        System.out.println("Sorted: " + dynArray);

        Integer integ = dynArray.getFromBeginning();
        System.out.println("Got from the beginning: " +integ);

        Integer integ02 = dynArray.getFromEnd();
        System.out.println("Got from the end: " +integ02);

        Pila<Integer> integ03 = new DynamicArray<>(new Integer[0]);
        System.out.println("Enter positive integer, -1 to exit");
        Integer entered = scanner.nextInt();
        while(entered != -1){
            integ03.apilar(entered);
            System.out.println("Enter positive integer, -1 to exit");
            entered = scanner.nextInt();
        }
        System.out.println("We take out;");
        entered = integ03.desapilar();
        while(entered != null){
            System.out.println(entered+ " ");
            entered = integ03.desapilar();
        }
        System.out.println("");

        System.out.println("Before sorting: " +dynArray);
        dynArray.order(Comparator.naturalOrder());
        System.out.println("After sorting: " +dynArray);
        System.out.println("Enter the index of the element you want to see: ");
        int index = scanner.nextInt();
        dynArray.get(index);
    }
}
