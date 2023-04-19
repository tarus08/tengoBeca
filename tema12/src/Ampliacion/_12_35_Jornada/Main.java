package Ampliacion._12_35_Jornada;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        LocalDateTime dateIn = LocalDateTime.now();
        LocalDateTime dateOut = LocalDateTime.now();
        Jornada jor = new Jornada(123, dateIn, dateOut);

        jor.switchOptions();
        jor.toString();
    }
}
