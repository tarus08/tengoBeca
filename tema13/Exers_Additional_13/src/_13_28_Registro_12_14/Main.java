package _13_28_Registro_12_14;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.nio.DoubleBuffer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Set<_13_28_Registro_12_14.Registro> registrosList = new LinkedHashSet<>();
        int choice = 0;

        do{
            System.out.println("Enter: \n" +
                    "'1' To add a new registro. \n" +
                    "'2' To list the registros. \n" +
                    "'3' To show the stats. \n" +
                    "'4' To exit");

            choice = new Scanner(System.in).nextInt();

            switch (choice) {
                case 1 ->
                {
                    System.out.println("Enter the new temperature");
                    double newTemperature = new Scanner(System.in).useLocale(Locale.US).nextDouble();
                    registrosList.add(new _13_28_Registro_12_14.Registro(newTemperature));
                }

                case 2 ->
                {
                    Stream<Registro> registroStream = registrosList
                            .stream()
                            .sorted(Comparator.comparing(Registro::toString));
                    registroStream.forEach(System.out::println);
                }

                case 3 ->
                {
                    Optional<Registro> maxT = registrosList
                            .stream()
                            .reduce((r1, r2) -> r1.getMaxTemperature() > r2.getMaxTemperature() ? r1:r2);
                    System.out.println("This is the maximum temperature: " + maxT);

                    Optional<Registro> minT = registrosList
                            .stream()
                            .max(Comparator.comparing(Registro::getMinTemperature));
                    System.out.println("This is the minimum temperature: " + minT);
                }

                case 4 ->
                {
                    String fileName = "registros.dat";
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    fileName += LocalDateTime.now().format(formatter);
                    try(ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(fileName))){
                        writer.writeObject(registrosList);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
        while (choice >= 1 && choice < 4);
    }
}
