package Aplicacion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class _12_21_Random_Collection {
    public static void main(String[] args) {

        Collection<Integer> groupNumbers = new ArrayList<>();
        List<Integer> groupNumbersList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            int randomNumber = (int) (Math.random() * 100);
            groupNumbers.add(randomNumber);
            groupNumbersList = new ArrayList<>(groupNumbers);
            Collections.sort(groupNumbersList, Collections.reverseOrder());
        }

        System.out.println("This is the list in reverse order: " +groupNumbersList);

    }
}
