package _12_34_Registro;
import java.time.LocalDate;
import java.util.*;

public class prueba {

    private double temperature;
    private LocalDate date;
    public prueba(double temperature, LocalDate date){
        this.temperature = temperature;
        this.date = date;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<LocalDate, prueba> map = new HashMap<LocalDate, prueba>();

        LocalDate date01 = LocalDate.of(2002, 12, 12);
        LocalDate date02 = LocalDate.of(2002, 12, 12);
        LocalDate date03 = LocalDate.of(2002, 12, 13);
        LocalDate date04 = LocalDate.of(2002, 12, 14);
        LocalDate date05 = LocalDate.of(2002, 12, 15);

        prueba prue01 = new prueba(23, date01);
        prueba prue02 = new prueba(23, date02);
        prueba prue03 = new prueba(23, date03);
        prueba prue04 = new prueba(23, date04);
        prueba prue05 = new prueba(23, date05);

        map.put(date01, prue01);
        map.put(date02, prue02);
        map.put(date03, prue03);
        map.put(date04, prue04);
        map.put(date05, prue05);

        System.out.println("Enter the day you want the register of: ");
        int year = 2002;
        int month = 12;
        int day = scanner.nextInt();

        LocalDate newDate = LocalDate.of(year, month, day);
        if (map.containsKey(newDate)){
            System.out.println("the day was found");
        }
    }
}
