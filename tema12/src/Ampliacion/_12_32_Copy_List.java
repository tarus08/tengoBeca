package Ampliacion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _12_32_Copy_List {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 1, 2, 3));
        List<Integer> result = cloneList(list);
    }
    static <E> List <E> cloneList(List<E>originalList){

        List<E> clonedList = new ArrayList<E>();
        clonedList.addAll(originalList);
        System.out.println("This is the original list: " + originalList);
        System.out.println("This is the cloned list: " +clonedList);

        return clonedList;
    }

}
