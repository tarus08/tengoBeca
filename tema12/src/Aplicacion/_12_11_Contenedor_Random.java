package Aplicacion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class _12_11_Contenedor_Random {
    public static void main(String[] args) {

        Collection<Integer> numberCollection = new ArrayList<Integer>();

        for (int i = 0; i < 30; i++){
            numberCollection.add((int)(Math.random() * 10) + 1);
        }

        System.out.println("This is the collections now: " +numberCollection);

        List<Integer> listOfNumbers = new ArrayList<Integer>(numberCollection);
        Collections.sort(listOfNumbers);
        System.out.println("This is the collection ordered (lower to higher) : " +listOfNumbers);

    }
}
