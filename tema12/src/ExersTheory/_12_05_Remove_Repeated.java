package ExersTheory;

import java.util.*;

public class _12_05_Remove_Repeated {
    public static void main(String[] args) {

        Random randomFunctionAPI = new Random();

        //first way
        Collection<Integer> numbersList = new ArrayList<Integer>();
        Collection<Integer> noRepeatedNumbers = new ArrayList<Integer>();
        List<Integer> sortedNoRepeatedNumbers = new ArrayList<Integer>();
        HashSet <Integer> set = new HashSet<Integer>();
        Integer randomNumbers = 0;

        for (int i = 0; i < 20; i++) {
            randomNumbers = randomFunctionAPI.nextInt(10)+1;
            numbersList.add(randomNumbers);
        }

        for (Integer repeated : numbersList) {
            if (set.add(repeated)) {
                noRepeatedNumbers.add(repeated);
            }
        }

        for (Integer e : noRepeatedNumbers){
            sortedNoRepeatedNumbers.add(e);
        }

        Collections.sort(sortedNoRepeatedNumbers);

        //show the lists
        System.out.println("The list with repeated numbers: ");
        System.out.println(numbersList);
        System.out.println("The list sorted and without repeated numbers: ");
        System.out.println(sortedNoRepeatedNumbers);

        //second way
        Collection<Integer> numberList02 = new ArrayList<Integer>();
        List<Integer> sortedNoRepeatedNumbers02 = new ArrayList<Integer>();

        System.out.println("------------------------------------------------------------");
        System.out.println("Another way to do it");

        for (int i = 0; i < 20; i++) {
            numberList02.add((int)(Math.random() * 10) + 1);
        }

       for(Integer number : numberList02){
           if (!sortedNoRepeatedNumbers02.contains(number)){
               sortedNoRepeatedNumbers02.add(number);
           }
       }

        Collections.sort(sortedNoRepeatedNumbers02);

        //show the lists
        System.out.println("The list02 with repeated numbers: ");
        System.out.println(numberList02);
        System.out.println("The list02 sorted and without repeated numbers: ");
        System.out.println(sortedNoRepeatedNumbers02);

    }
}
