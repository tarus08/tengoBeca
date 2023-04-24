package Exer_Proposed_01;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int nums = 0;
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < 50; i ++)
        {
            nums = (int)(Math.random() * 100);
            list.add(nums);
        }
        System.out.println("These are the numbers: " + list);

        List<Integer> list02 = Multiples_Of_3_02.filter(list, e -> e % 3 == 0);
        System.out.println("These are the multiples of 3: " + list02);
    }
}
