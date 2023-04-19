package Exers_Theory._13_05_Fusion_Arrays;

import java.util.Arrays;
import java.util.function.Function;

public class Fusion {
    public static <T, V> V[] transform(T[] original, V[] transf, Function<T, V> func)
    {
      transf = Arrays.copyOf(transf, original.length);
      for (int i = 0; i < original.length; i++)
      {
          transf[i] = func.apply(original[i]);
      }
      return transf;
    }
}
