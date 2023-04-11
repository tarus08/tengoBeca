package Actividades_Ampliacion._12_34_Registro;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        LocalDate date = LocalDate.of(1, 1, 1);
        Registro reg01 = new Registro(0.0, date);
        Set<Registro> registrosSet = new HashSet<>();
        Map<LocalDate, List<Registro>> map = new HashMap<>();

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
                    System.out.println("Enter the date for the new registro (yyyy-mm-dd):");
                    int year = scanner.nextInt();
                    int month = scanner.nextInt();
                    int day = scanner.nextInt();
                    LocalDate newDate = LocalDate.of(year, month, day);
                    reg01 = new Registro(newTemperature, newDate);

                    List<Registro> registrosDate = map.getOrDefault(newDate, new ArrayList<>());
                    registrosDate.add(reg01);
                    map.put(newDate, registrosDate);

                    break;

                case 2:
                    for (Registro regis : registrosSet) {
                        System.out.println(regis.toString());
                    }

                    System.out.println("Enter the date of the registro you wish to see (yyyy-mm-dd):");
                    int yearSee = scanner.nextInt();
                    int monthSee = scanner.nextInt();
                    int daySee = scanner.nextInt();
                    LocalDate newDateSee = LocalDate.of(yearSee, monthSee, daySee);

                    registrosDate = map.get(newDateSee);

                    if (registrosDate == null || registrosDate.isEmpty()) {
                        System.out.println("No registros for date");
                    }else{
                        for (Registro reg : registrosDate){
                            System.out.println(reg.toString());
                        }
                    }

                    break;

                case 3:
                    Comparator<Registro> compareRegistro = Comparator.comparingDouble(Registro::getTemperature);
                    List<Registro> allRegistros = new ArrayList<>();
                    map.values().forEach(allRegistros::addAll);
                    if (allRegistros.isEmpty()) {
                        System.out.println("No registros added yet");
                    } else {
                        Registro maxTempRegistro = Collections.max(allRegistros, compareRegistro);
                        Registro minTempRegistro = Collections.min(allRegistros, compareRegistro);
                        double sum = allRegistros.stream().mapToDouble(Registro::getTemperature).sum();
                        double avgTemp = sum / allRegistros.size();

                        System.out.println("Maximum temperature: " + maxTempRegistro.getTemperature());
                        System.out.println("Minimum temperature: " + minTempRegistro.getTemperature());
                        System.out.println("Average temperature: " + avgTemp);
                    }
                    break;

                case 4:
                    LocalDateTime newDate02 = LocalDateTime.now();
                    String fileName = "registros.dat";
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    fileName += LocalDateTime.now().format(formatter);
                    try(ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(fileName))){
                        writer.writeObject(registrosSet);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
            }
        }
        while (choice >= 1 && choice < 4);
    }
}
