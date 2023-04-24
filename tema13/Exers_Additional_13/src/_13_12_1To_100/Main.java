package _13_12_1To_100;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= 100; i++)
        {
            list.add(i);
        }

        long count = list.stream()
                .filter(e -> e % 7 == 0)
                .count();

        System.out.println("There are: " + count + " multiples of 7: " + list);
    }
}