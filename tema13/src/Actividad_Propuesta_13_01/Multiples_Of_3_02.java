package Actividad_Propuesta_13_01;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Multiples_Of_3_02 <T>{
    static <T> List<T> filter (List <T> genericList, Predicate<T> predicate)
    {
        List<T> multipleBy3 = new ArrayList<>();
        for (T item : genericList)
        {
            if (predicate.test(item))
            {
                multipleBy3.add(item);
            }
        }
        return multipleBy3;
    }
}
