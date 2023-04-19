package Exers_Theory;

import java.util.Arrays;

public class FusionArrays {

    static <T extends String> String [] table01andTable02 (T [] table01, T [] table02){
        int totalLength = table01.length + table02.length;
        String [] table03 = Arrays.copyOf(table01, totalLength);
        // void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
        System.arraycopy(table02, 0, table03, table01.length, table02.length);
        return table03;
    }

    static <T extends String> String [] table02andTable01 (T [] table01, T [] table02){
        int totalLength = table01.length + table02.length;
        String [] table03 = Arrays.copyOf(table02, totalLength);
        System.arraycopy(table01, 0, table03, table02.length, table01.length);
        return table03;
    }

    public static void main(String[] args) {

        String [] table01 = {"en el chino yo me compro una chuche"};
        String [] table02 = {"o patatas? no. unas garrapatas"};

        String [] result01 = table01andTable02(table01, table02);
        System.out.println("First array concatenated with the second: " +Arrays.toString(result01));

        String [] result02 = table02andTable01(table01, table02);
        System.out.println("Second array concatenated with the first: "+Arrays.toString(result02));
    }


}
