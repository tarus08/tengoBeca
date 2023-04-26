package _13_27_Socios_Stream_12_11;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        Set<Socio> socioSet = new HashSet<>();

        do{
            System.out.println("Enter: \n" +
                    "'1'. To add a socio. \n" +
                    "'2'. To remove the socio.\n" +
                    "'3'. To modify the socios. \n" +
                    "'4'. To sort by antiquity.\n" +
                    "'5'. To sort by dni. \n" +
                    "'6'. To exit. \n");

            choice = scanner.nextInt();

            switch(choice){
                case 1 ->
                {
                    System.out.println("Enter the dni:");
                    int newDni = scanner.nextInt();
                    alta(socioSet, newDni);
                }

                case 2 ->
                {
                    System.out.println("Enter the dni of the socio you want to delete.");
                    int removeDni = scanner.nextInt();
                    socioSet.removeIf(s -> s.getDni() == removeDni);
                }

                case 3 ->
                {
                    //no borra el que ya estaba
                    System.out.println("Enter the dni of the socio you want to modify.");
                    int dni = scanner.nextInt();
                    socioSet.removeIf(s -> s.getDni() == dni);
                    alta(socioSet, dni);
                }

                case 4 ->
                {
                    Stream<Socio> sortedByAntiquity = socioSet
                            .stream()
                            .sorted(Comparator.comparing(Socio::antiquity));
                    sortedByAntiquity.forEach(System.out::println);
                }

                case 5 ->
                {
                    Stream<Socio> sortedByDni = socioSet
                            .stream()
                            .sorted(Comparator.comparing(Socio::getDni));
                    sortedByDni.forEach(System.out::println);
                }
            }
        } while (choice != 6);

        try(ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("socios_12.dat"))){
            writer.writeObject(socioSet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static void alta (Set<Socio> so, int dni){
        System.out.println("Enter the name: ");
        String name = new Scanner (System.in).next();
        System.out.println("Enter the fecha alta with this format: yyyy-mm-dd");
        int year = new Scanner(System.in).nextInt();
        int month = new Scanner(System.in).nextInt();
        int day = new Scanner(System.in).nextInt();
        LocalDate fechaAlta = LocalDate.of(year, month, day);
        Socio newSocio = new Socio(dni, name, fechaAlta);
        so.add(newSocio);
    }
}

