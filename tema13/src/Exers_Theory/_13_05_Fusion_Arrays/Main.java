package Exers_Theory._13_05_Fusion_Arrays;

import Exers_Theory._13_07_Calculos_AP_13_03.Calculos;
import java.util.Arrays;
import java.util.Scanner;

import static Exers_Theory._13_05_Fusion_Arrays.Fusion.transform;
import static Exers_Theory._13_07_Calculos_AP_13_03.Calculos.rootN;

//the main is in the 13_05 main
public class Main {
    public static void main(String[] args) {

        Integer [] array = new Integer [5];
        array [0] = 4;
        array [1] = 9;
        array [2] = 16;
        array [3] = 25;
        array [4] = 36;

        Double [] array02 = transform(array, new Double[0], y -> Math.sqrt(y));
        System.out.println(Arrays.toString(array02));

        Double [] d1 = {1.,2.,3.,4.,5.,6.,7.,8.,9.,};
        Double [] d2 = transform(d1, new Double[0], Calculos::root3);
        System.out.println(Arrays.toString(d2));

        System.out.println("Enter the number to calculate its 4th root: ");
        double numCalc = new Scanner(System.in).nextDouble();
        double num = rootN(numCalc, 4);
        System.out.println("This is the result for the 4th root of " +numCalc+ ": " +num);
    }
}
