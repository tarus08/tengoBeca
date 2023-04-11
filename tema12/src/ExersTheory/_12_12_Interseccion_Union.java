package ExersTheory;

import java.util.HashSet;
import java.util.Set;

public class _12_12_Interseccion_Union {

    public static void main(String[] args) {

        Set <Integer> group1 = new HashSet<Integer>();
        group1.add(1);
        group1.add(2);
        group1.add(3);

        Set <Integer> group2 = new HashSet<Integer>();
        group1.add(1);
        group1.add(2);
        group1.add(3);

        union(group1, group2);
        interseccion(group1, group2);
    }

    static <E> Set<E> union(Set<E> group1, Set<E> group2) {
        Set<E> unionResult = new HashSet<>(group1);
        System.out.println(unionResult);
        return unionResult;
    }

    static <E> Set<E> interseccion(Set<E> group1, Set<E> group2){
        Set<E> intersectionResult = new HashSet<>(group1);
        intersectionResult.retainAll(group2);
        System.out.println(intersectionResult);
        return intersectionResult;
    }
}
