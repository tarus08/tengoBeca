package _12_14_Registro;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Registro reg = new Registro(12);
        Set<Registro> registrosList = new LinkedHashSet<>();
        int choice = 0;

        do{
            System.out.println("Enter: \n" +
                    "'1' To add a new registro. \n" +
                    "'2' To list the registros. \n" +
                    "'3' To show the stats. \n" +
                    "'4' To exit");

            choice = new Scanner(System.in).nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the new temperature");
                    double newTemperature = new Scanner(System.in).useLocale(Locale.US).nextDouble();
                    registrosList.add(new Registro(newTemperature));
                    break;

                case 2:
                    for (Registro regis : registrosList) {
                        System.out.println(regis.toString());
                    }
                    break;

                case 3:
                    Comparator<Registro> compareRegistro = new Comparator<Registro>() {
                        @Override
                        public int compare(Registro r1, Registro r2) {
                            return (int) Math.signum(r1.getTemperature() - r2.getTemperature());
                        }
                    };

                    System.out.println("Maximum temperature: " + Collections.max(registrosList, compareRegistro));
                    System.out.println("Minimum temperature: " + Collections.min(registrosList, compareRegistro));
                    double sum = 0;
                    for (Registro r : registrosList){
                        sum += r.getTemperature();
                    }
                    System.out.println("Average temperature: " +sum / registrosList.size());
                    break;

                case 4:
                    LocalDateTime newDate = LocalDateTime.now();
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
        while (choice >= 1 && choice < 4);
    }
}
