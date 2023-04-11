package Actividades_Aplicacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class _12_24_Fusion_Listas {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> list01 = new ArrayList<>();
        List<Integer> list02 = new ArrayList<>();
        List<Integer> fusion = new ArrayList<>();

        System.out.println("Insert the sizse for the lists");
        int size = scanner.nextInt();

        int numbers01 = 0;
        int numbers02 = 0;

        for (int i = 0; i < size; i++) {
            System.out.println("Insert the " +(i + 1) + " value for the first list:");
            numbers01 = scanner.nextInt();
            list01.add(numbers01);
        }

        for (Integer i : list01) {
            Integer nums01 = i;
            fusion.add(i);
        }

        for (int i = 0; i < size; i++) {
            System.out.println("Insert the " +(i + 1) + " value for the second list:");
            numbers02 = scanner.nextInt();
            list02.add(numbers02);
        }

        for (Integer i : list02){
            Integer nums02 = i;
            fusion.add(i);
        }

        Collections.sort(fusion);
        System.out.println("This is the collection: " + fusion);

    }
}
