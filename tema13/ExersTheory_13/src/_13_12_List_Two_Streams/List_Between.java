package _13_12_List_Two_Streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class List_Between {
    public static void main(String[] args) {

        List<Integer> list01 = new ArrayList<Integer>();
        int min = -20;
        int max = 20;

        for (int i = 0; i < 40; i++)
        {
            Integer e = (int) (Math.random() * (max - min) + min);
            list01.add(e);
        }

        Collections.sort(list01);

        long posNums = list01.stream()
                .filter(e -> e > 0)
                .distinct()
                .count();
        System.out.println("Positive numbers: " +posNums);

        long negNums = list01.stream()
                .distinct()
                .filter(e -> e < 0)
                .count();
        System.out.println("Negative numbers: " + negNums);

        long numsBetween = list01.stream()
                .distinct()
                .filter(e -> e >= -10 && e <= 10)
                .count();
        System.out.println("Numbers between -10 and 10: " + numsBetween);

    }
}
