package _13_09_10_Is_Primo;

import java.util.ArrayList;
import java.util.List;
import static _13_09_10_Is_Primo.Primo.isEven;

public class Main02 {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            list.add((int)(Math.random()*1000));
        }

        List<Integer> sortedEvenNumbers = list.stream()
                .filter(Primo::isEven)
                .sorted()
                .toList();
        System.out.println(sortedEvenNumbers);

        List<Integer> reversedEvenNumbers = list.stream()
                .filter(Primo::isEven)
                .sorted((a, b) -> b -a)
                .toList();
        System.out.println(reversedEvenNumbers);

        List <Integer> between = list.stream()
                .filter(n -> isEven(n) && n >= 200 && n <= 800)
                .sorted((a, b) -> b -a)
                .toList();
        System.out.println(between);
    }
}
