package _13_13_Fusion_Lists;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> list01 = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++)
        {
            list01.add((int)(Math.random() * 100));
        }

        List<Integer> list02 = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++)
        {
            list02.add((int)(Math.random() * 100));
        }

        List<Integer> fusionList = new ArrayList<Integer>();
        fusionList.addAll(list01);
        fusionList.addAll(list02);

        fusionList.stream()
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }
}
