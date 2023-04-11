package Actividades_Aplicacion;

import java.util.*;

public class _12_13_Contenedor_Random {
    public static void main(String[] args) {

        Collection<Integer> numberCollection = new ArrayList<Integer>();

        for (int i = 0; i < 30; i++){
            numberCollection.add((int)(Math.random() * 10) + 1);
        }

        System.out.println("This is the collections now: " +numberCollection);

        List<Integer> listOfNumbers = new ArrayList<Integer>(numberCollection);
        listOfNumbers.sort(Comparator.naturalOrder());
        listOfNumbers.sort(Comparator.reverseOrder());
        System.out.println("This is the collection ordered (higher to lower): " +listOfNumbers);

    }
}
