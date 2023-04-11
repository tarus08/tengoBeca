package ExersTheory._12_11_Socios;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Socio soOriginal = null;
        Set<Socio> socioList= new TreeSet<>();

        try(ObjectInputStream reader = new ObjectInputStream(new FileInputStream("socios_12.dat"))){
            reader.readObject();
        }catch (IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        int choice;

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
                case 1:
                    System.out.println("Enter the dni:");
                    int newDni = scanner.nextInt();
                    alta(socioList, newDni);

                    break;

                case 2:
                    System.out.println("Enter the dni of the socio you want to delete.");
                    int removeDni = scanner.nextInt();
                    socioList.remove(new Socio(removeDni));

                    break;

                case 3:

                    System.out.println("Enter the dni of the socio you want to modify.");
                    int dni = new Scanner(System.in).nextInt();
                    socioList.remove(new Socio(dni));
                    alta(socioList, dni);

                    break;

                case 4:

                    System.out.println(socioList);

                    break;

                case 5:

                    Comparator<Socio> socios = new Comparator<Socio>(){
                        @Override
                        public int compare(Socio s1, Socio s2) {
                            s1.getFechaAlta().compareTo(s2.getFechaAlta());
                            return s1.antiquity() - s2.antiquity();
                        }
                    };

                    Set<Socio> socio = new TreeSet<>(socios);
                    socio.addAll(socioList);
                    System.out.println(socio);

                    break;
            }
        }while (choice != 6);

        try(ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("socios_12.dat"))){
            writer.writeObject(socioList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static boolean alta (Set<Socio> so, int dni){
        System.out.println("Enter the name: ");
        String name = new Scanner (System.in).next();
        System.out.println("Enter the fecha alta with this format: yyyy-mm-dd");
        int year = new Scanner(System.in).nextInt();
        int month = new Scanner(System.in).nextInt();
        int day = new Scanner(System.in).nextInt();
        LocalDate fechaAlta = LocalDate.of(year, month, day);
        Socio newSocio = new Socio(dni, name, fechaAlta);
        return so.add(newSocio);
    }
}
