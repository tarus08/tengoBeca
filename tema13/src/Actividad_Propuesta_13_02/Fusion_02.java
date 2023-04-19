package Actividad_Propuesta_13_02;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Fusion_02 {

    static <T, V> List <V> transform(List<T> original, Function<T,V> func)
    {
        List<V> listV = new ArrayList<>();
        for (T element : original)
        {
            V transformedElement = func.apply(element);
            listV.add(transformedElement);
        }
        return listV;
    }
}
