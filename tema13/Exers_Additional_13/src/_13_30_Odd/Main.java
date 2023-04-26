package _13_30_Odd;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Integer> originalList = new ArrayList<Integer>();

        for (int i = 1; i <= 1000; i++)
        {
            originalList.add(i);
        }
        System.out.println("This is the list: " +originalList);

        Stream <Integer> stream = originalList.stream()
                .filter(e -> e % 2 != 0 && e % 3 == 0 && e % 5 == 0)
                .sorted();
        System.out.println("This is the list with the even numbers which are multiples of 3 or 5: ");
        stream.forEach(System.out::println);

    }
}
