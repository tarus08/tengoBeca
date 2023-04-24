import java.util.*;

public class _12_08_Collection_To_Array {
    public static void main(String[] args) {

        Collection<Integer> numberCollection = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++) {
            numberCollection.add((int) (Math.random() * 10 + 1));
        }

        Integer [] collectionToArray = numberCollection.toArray(new Integer[0]);
        Arrays.sort(collectionToArray);
        System.out.println("These are the numbers sorted and stored in an array: " +Arrays.toString(collectionToArray));

        Collection<Integer> newList = new ArrayList<Integer>();
        newList.addAll(Arrays.asList(collectionToArray));
        System.out.println("These are the numbers stored in a list again");

        //descending order
        Comparator<Integer> descendingOrder = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2){
                return o2 - o1;
            }
        };

        System.out.println(" ------------------------------\nAnother way\n--------------------");

        //to use the reversed method, you must use first the natural order method.
        Comparator<Integer> orderIntegers = Comparator.naturalOrder();
        descendingOrder = orderIntegers.reversed();

        //

        Arrays.sort(collectionToArray, descendingOrder);
        Collection<Integer> descendingList = new ArrayList<Integer>();
        descendingList.addAll(Arrays.asList(collectionToArray));
        System.out.println(descendingList);

    }
}
