package _13_11_Sort_By_Name;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Clients02 [] cli = new Clients02[3];
        cli[0] = new Clients02(3, "ana", 9000);
        cli[1] = new Clients02(2, "carlos", 8000);
        cli[2] = new Clients02(1, "bea", 7000);

        Arrays.stream(cli)
                .sorted(Comparator.comparing(Clients02::getName))
                .map(c -> c.getName()+ "\t" + c.getAge())
                .forEach(System.out::println);
    }
}
