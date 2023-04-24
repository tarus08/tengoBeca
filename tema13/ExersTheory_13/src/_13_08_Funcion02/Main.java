package _13_08_Funcion02;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Double [] d1 = {1.,2.,3.,4.,5.,6.,7.,8.,9.};
        Double [] d2 = {2.,2.,2.,2.,2.,2.,2.,2.,2.};
        Double [] res = Calculus.operateArrays(d1,d2, new Double[0], Calculus::multiply);
        System.out.println(Arrays.toString(res));
    }
}
