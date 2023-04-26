package _13_16_17_18_19_20_21_Socio;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Socio [] socioArray = new Socio[5];
        socioArray[0] = new Socio("123A", "mario", LocalDate.of(2004,10,9),
                LocalDate.of(2020,1,9), 100., 1);

        socioArray[1] = new Socio("123C", "alex", LocalDate.of(2006,10,9),
                LocalDate.of(2020,2,9), 200., 4);

        socioArray[2] = new Socio("123B", "abel", LocalDate.of(2005,10,9),
                LocalDate.of(2020,3,9), 300., 5);

        socioArray[3] = new Socio("123E", "menganito", LocalDate.of(2008,10,9),
                LocalDate.of(2020,4,9), 400., 2);

        socioArray[4] = new Socio("123D", "maria", LocalDate.of(2007,10,9),
                LocalDate.of(2020,5,9), 500., 7);

        //13_18
        //sorted by dni
        Stream<Socio> streamSocio = Stream.of(socioArray)
                .sorted(Socio::compareTo);
        System.out.println("Sorted by dni: ");
        streamSocio.forEach(System.out::println);

        //shares higher than 100
        Stream<Socio> streamSocio01 = Stream.of(socioArray)
                .filter(e -> e.getShare() > 100);
        System.out.println("Socios with shares higher than 100: ");
        streamSocio01.forEach(System.out::println);

        //name starts with "A"
        Stream<Socio> streamSocio02 = Stream.of(socioArray)
                .sorted(Socio::equals)
                .filter(s -> s.getName().startsWith("a"));
        System.out.println("The socios whose names start with 'A' : ");
        streamSocio02.forEach(System.out::println);

        //13_17
        //age of each socio
        Stream<Socio> streamSocio03 = Stream.of(socioArray)
                .sorted(Socio::age);
        System.out.println("The socios sorted by age: ");
        streamSocio03.forEach(System.out::println);

        //loyalty of each socio
        Stream<Socio> streamSocio04 = Stream.of(socioArray)
                .sorted(Socio::loyalty);
        System.out.println("The socios sorted by loyalty: ");
        streamSocio04.forEach(System.out::println);

        //13_19
        //convert the stream to an array
        String [] socioArray02 = Arrays.stream(socioArray)
                .sorted(Socio::compareTo)
                .map(Socio::getDni)
                .toArray(String[]::new);
        System.out.println("The dnis as an array: ");
        System.out.println(Arrays.toString(socioArray02));

        //13_20
        //convert the stream to a list
        List<String> socioList = Stream.of(socioArray).toList()
                .stream()
                .sorted(Socio::compareTo)
                .map(Socio::getDni)
                .toList();
        System.out.println("The dnis as a list: ");
        System.out.println(socioList);

        //el 13_21 se refiere a una lista, un mapa, un set...
        List<Socio> socioList02 = Stream.of(socioArray).toList()
                .stream()
                .sorted(Socio::compNames)
                .toList();
        System.out.println("The names ordered alphabetically: ");
        System.out.println(socioList02);

        //13_22
        double avgFamilyMembers = Stream.of(socioArray)
                .collect(Collectors.averagingDouble(Socio::getNumFamily));
        System.out.println("This is the average number of family members the socios have: " + avgFamilyMembers);

    }
}
