package Aplicacion;
import java.util.ArrayList;
public class _12_17_Cola_Generica<T>{

    private ArrayList<T> elements;
    public void enqueue(T element){
        elements.add(element);
    }
}
//extend the class to Cola_Generica_12_17 <T> extends ArrayList{
//then you remove private arrayList.. and the elements.add, you only let add.