package ejer02_Plataforma;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Map<String, List<Cycle>> platformMap = new HashMap<>();
        System.out.println("Enter the name of the platform: ");
        String namePlatform = scanner.next();
        Platform platform = new Platform(namePlatform, platformMap);
        platform.addPlatform(namePlatform);


    }
}
