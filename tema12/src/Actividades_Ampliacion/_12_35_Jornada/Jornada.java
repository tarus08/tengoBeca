package Actividades_Ampliacion._12_35_Jornada;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Jornada {

    private int dni;
    private LocalDateTime dateIn;
    private LocalDateTime dateOut;

    public Jornada(int dni, LocalDateTime dateIn, LocalDateTime dateOut) {
        this.dni = dni;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
    }

    public long minutesDifference() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Insert the date and hour (yyyy-mm-dd / hh-mm-ss) for the beginning of the day of work: ");
        int yearIn = scanner.nextInt();
        int monthIn = scanner.nextInt();
        int dayIn = scanner.nextInt();
        int hourIn = scanner.nextInt();
        int minutesIn = scanner.nextInt();
        int secondsIn = scanner.nextInt();
        dateIn = LocalDateTime.of(yearIn, monthIn, dayIn, hourIn, minutesIn, secondsIn);

        System.out.println("Insert the date and hour (yyyy-mm-dd / hh-mm-ss) for the end of the day of work: ");
        int yearOut = scanner.nextInt();
        int monthOut = scanner.nextInt();
        int dayOut = scanner.nextInt();
        int hourOut = scanner.nextInt();
        int minutesOut = scanner.nextInt();
        int secondsOut = scanner.nextInt();
        dateOut = LocalDateTime.of(yearOut, monthOut, dayOut, hourOut, minutesOut, secondsOut);

        Duration duration = Duration.between(dateIn, dateOut);
        return duration.toMinutes();
    }

    public String toString() {
        return "dni: " + dni + " date in: " + dateIn + " date out: " + dateOut + " minute difference: " + minutesDifference();
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public LocalDateTime getDateIn() {
        return dateIn;
    }

    public void setDateIn(LocalDateTime dateIn) {
        this.dateIn = dateIn;
    }

    public LocalDateTime getDateOut() {
        return dateOut;
    }

    public void setDateOut(LocalDateTime dateOut) {
        this.dateOut = dateOut;
    }
}
