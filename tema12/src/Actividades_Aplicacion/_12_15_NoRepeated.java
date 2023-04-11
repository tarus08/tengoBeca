package Actividades_Aplicacion;

import java.util.*;

public class _12_15_NoRepeated<T>{
    public List<T> removeRepeated (List<T> listNumbers) {
        Set<T> set = new HashSet<>(listNumbers);
            return new ArrayList<>(set);
    }
}
