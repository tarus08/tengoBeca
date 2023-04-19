package ejer02_Plataforma;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Cycle> cycleList = new ArrayList<>();
        System.out.println("Enter the name of the platform: ");
        String namePlatform = scanner.next();
        Platform platform = new Platform(namePlatform, cycleList);

        //add a platform
        platform.addPlatform(namePlatform);

        //the exam
        System.out.println("Enter the name of the student who takes the exam: ");
        String nameStudent = scanner.next();
        platform.takeExam(nameStudent);

        //show all
        platform.showAllData();

    }
}
