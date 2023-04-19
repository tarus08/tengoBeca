package Aplicacion;

import java.util.Deque;
import java.util.LinkedList;

public class _12_18_Pila_Generica<T>{
    private Deque<T> stack = new LinkedList<>();
    public void push(T element){
        stack.push(element);
    }
}

//extend the class to arraylist: public class Pila_Generica_12_18 <T> extends ArrayList{
//then you remove private deque.. and the stak.push, you only put push.