package _13_09_10_Is_Primo;

import java.util.ArrayList;
import java.util.List;

import static _13_09_10_Is_Primo.Even.isEven;

public class Main {
    public static void main(String[] args) {

        int nums = 0;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            list.add((int) (Math.random() * 1000));
        }

        list.stream().filter(Even::isEven)
                .sorted()
                .forEach(n -> System.out.println(n + " "));
        System.out.println(" ");

        list.stream().filter(Even::isEven)
                .sorted((a,b) -> b - a)
                .forEach(n -> System.out.println(n + " "));
        System.out.println(" ");

        list.stream().filter(n -> isEven(n) && n > 200 && n < 800)
                .sorted((a,b) -> b -a)
                .forEach(n -> System.out.println(n + " "));
        System.out.println(" ");
    }
}
