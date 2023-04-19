package Ampliacion;
//delete the repeated objects
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class _12_30_Delete_Repes {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 1, 2, 3));
        List<Integer> result = deleteRepeated(list);
        System.out.println(result);
    }
    public static <T> List <T> deleteRepeated(List<T> list) {
        List<T> result = new ArrayList<T>();
        Iterator<T> iterator = list.iterator();
        //like the for each to see if there are repeated elements in
        // a list. it iterates over each object, storing it in the T
        // element variable
        while(iterator.hasNext()) {
            T element = iterator.next();
            if (!result.contains(element)) {
                result.add(element);
            }
        }
        return result;
    }
}