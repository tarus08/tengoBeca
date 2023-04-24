package Exer_Proposed_04;

import java.util.List;
import java.util.function.Function;

public class Increment_N_Times {
    static List<Entero> transform (List<Entero> originalList, Function<Entero, Entero> functi, int n)
    {
        //el metodo se llama a si mismo, y se reemplaza la lista anterior con la nueva,
        // que ahora tiene un valor mas, se ha transformado
        for (int i = 0; i < n; i++) {
            originalList.replaceAll(functi::apply);
        }
        return originalList;
    }
}
