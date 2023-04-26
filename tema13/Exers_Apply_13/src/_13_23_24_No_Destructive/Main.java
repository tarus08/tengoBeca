package _13_23_24_No_Destructive;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<Integer> list01 = new ArrayList<Integer>();
        list01.add(6);
        list01.add(4);
        list01.add(5);

        List<Integer> list02 = new ArrayList<Integer>();
        list02.add(1);
        list02.add(3);
        list02.add(2);

        List<Integer> streamList01 = list01.stream()
                .sorted()
                .toList();
        System.out.println("These are the numbers in the first list: "
                +streamList01.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "))
        );

        List<Integer> streamList02 = list02.stream()
                .sorted()
                .toList();
        System.out.println("These are the numbers in the second list: "
                +streamList02.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "))
        );

        List<Integer> listFusion = Stream.concat(list01.stream(), list02.stream())
                .sorted()
                .toList();
        System.out.println("This is the fusion of both lists: "
                + listFusion.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "))
        );

        //13_24
        //the same but using streams instead of lists
        Stream<Integer> stream01 = streamList01
                .stream()
                .sorted();
        System.out.println("This is the first list again, but now it is a stream: "
            +stream01
                .map(Object::toString)
                .collect(Collectors.joining(", "))
        );

        Stream<Integer> stream02 = streamList02
                .stream()
                .sorted();
        System.out.println("This is the second list again, but now it is a stream: "
                +stream02
                .map(Object::toString)
                .collect(Collectors.joining(", "))
        );

        Stream<Integer> stream03 = listFusion
                .stream()
                .sorted();
        System.out.println("This is the fusion of the lists again, but now it is a stream: "
                + stream03
                .map(Object::toString)
                .collect(Collectors.joining(", "))
        );
    }
}
