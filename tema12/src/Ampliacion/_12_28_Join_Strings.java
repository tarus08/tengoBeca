package Ampliacion;

import java.util.ArrayList;
import java.util.List;

public class _12_28_Join_Strings {

    public static void main(String[] args) {
        List<Character> list1 = new ArrayList<>();
        list1.add('a');
        list1.add('b');
        list1.add('c');
        List<Character> list2 = new ArrayList<>();
        list2.add('d');
        list2.add('e');
        list2.add('f');
        List<Character> concatenatedList = join(list1, list2);
        System.out.println(concatenatedList);
    }
    static List<Character> join (List<Character> str01, List<Character> str02){
        List<Character> concatenatedList = new ArrayList<>(str01);
        concatenatedList.addAll(str02);
        return concatenatedList;
    }

}
