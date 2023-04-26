package _13_25_Reduce_Multiply;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        System.out.println("This is the result of the multiplication of the numbers in the stream: ");
        Stream<Integer> integers = Stream.of(1,2,3,4,5);
        integers.reduce((integer, integer2) -> integer * integer2)
                .ifPresent(System.out::println);

    }
}
