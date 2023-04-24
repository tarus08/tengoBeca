package _13_08_Funcion02;

import java.util.Arrays;

public class Calculus {
    static <T, V, U> U[] operateArrays(T[] op1, V[] op2, U[] result, Funcion02<T, V, U> function02)
    {
        if (op1.length == op2.length)
        {
            result = Arrays.copyOf(result, op1.length);
            for (int i = 0; i < op1.length; i++)
            {
                result[i] = function02.calculate(op1[i], op2[i]);
            }
        }
        else
        {
            result = null;
        }
        return result;
    }
    public static double multiply(double d1, double d2)
    {
        return d1 * d2;
    }

}
