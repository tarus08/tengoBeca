import java.util.*;

public class _12_10_Set {
    public static void main(String[] args) {

        List<Integer> numbersList = new ArrayList<Integer>();
        Set<Integer> noRepeated = new TreeSet<Integer>();
        Set<Integer> repeated = new TreeSet<Integer>();
        Set<Integer> uniques = new TreeSet<Integer>();

        for (int i = 0; i < 20; i++){
            numbersList.add((int)(Math.random() * 10+1));
        }

        Comparator<Integer> compare = Comparator.naturalOrder();
        numbersList.sort(compare);
        System.out.println("The original list: " +numbersList);

        //addAll automatically deletes the repeated numbers but keeps the original ones
        noRepeated.addAll(numbersList);
        System.out.println("The original numbers: " +noRepeated);

        //just repeated numbers
        for (Integer number : numbersList){
            if (Collections.frequency(numbersList, number) > 1){
                repeated.add(number);
            }
        }
        System.out.println("The repeated numbers: " + repeated);

        //just the unique numbers
        uniques.addAll(noRepeated);
        uniques.removeAll(repeated);
        System.out.println("The unique numbers: " +uniques);

    }
}
