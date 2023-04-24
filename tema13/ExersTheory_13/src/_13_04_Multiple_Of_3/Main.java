package _13_04_Multiple_Of_3;

import java.util.Arrays;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        Integer [] t = new Integer[50];
        for (int i = 0; i < 50; i++) {
            t[i] = (int) (Math.random()*100);
        }
        Arrays.sort(t);
        Integer [] multip3 = filter(t, e -> e % 3== 0);
        System.out.println("Original array: " + Arrays.toString(t));
        System.out.println("Filtered array: " + Arrays.toString(multip3));
    }

    static <T> T [] filter  (T[] generic, Predicate<T> isOrNot)
    {
        T [] multip = Arrays.copyOf(generic, 0);
        for (T t : generic)
        {
            if (isOrNot.test(t))
            {
                multip = Arrays.copyOf(multip, multip.length + 1);
                multip[multip.length - 1] = t;
            }
        }
        return multip;
    }
}
