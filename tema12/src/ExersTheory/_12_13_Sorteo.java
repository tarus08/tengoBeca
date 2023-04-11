package ExersTheory;

import java.util.*;

public class _12_13_Sorteo<T extends Comparable<T>>{
    private final Set<T> elements;
    public _12_13_Sorteo(){
        elements = new TreeSet<>();
    }

    boolean add(T nuevo){
        return elements.add(nuevo);
    }

    Set<T> winners (int numWinners){
        Set<T> winners = null;
        //store the elements in a temporary list to shuffle the content
        List<T> temporary = new ArrayList<>(elements);
        Collections.shuffle(temporary);
        //store the elements again in a tree set
        if (numWinners <= elements.size()) {
            winners = new TreeSet<>();
            for (int i = 0; i < numWinners; i++) {
                winners.add(temporary.get(i));
            }
        }
        return winners;
    }

    @Override
    public String toString() {
        return "Sorteo.\nElements: " +elements;
    }

    public static void main(String[] args) {
        _12_13_Sorteo<Integer> lottery = new _12_13_Sorteo<>();
        for (int i = 0; i < 100; i++) {
            lottery.add(i);
        }
        System.out.println(lottery);
        System.out.println("Winners: " +lottery.winners(10));
    }

}
