package Exer_Proposed_04;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Entero> originalList = new ArrayList<>();
        originalList.add(new Entero(1));
        originalList.add(new Entero(2));
        originalList.add(new Entero(3));
        originalList.add(new Entero(4));

        List<Entero> enteroList = Increment_N_Times.transform(originalList, entero -> {
            return new Entero(entero.value + 1);
        }, 3);

        for (Entero entero : enteroList) {
            System.out.println(entero);
        }
    }
}
