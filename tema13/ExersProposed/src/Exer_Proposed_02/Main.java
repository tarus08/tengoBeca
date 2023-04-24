package Exer_Proposed_02;

import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {

        List<Integer> originalList = new ArrayList<>();
        originalList.add(1);
        originalList.add(2);
        originalList.add(3);
        originalList.add(4);

        List<Integer> squareList = Fusion_02.transform(originalList, x -> x * x);
        System.out.println(squareList);


    }
}
