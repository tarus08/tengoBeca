package DynArray_AND_Pila_12_02_03;

import java.util.Arrays;
import java.util.Scanner;

public class DynamicArray <T extends Comparable<T>> implements Pila<T> {

    private T[] objects;
    private T[] objects02;
    public DynamicArray(T[] objects) {
        this.objects = objects;
    }

    public void dynamicArray(T[]objects02){
        this.objects02 = objects02;
    }
    @Override
    public void apilar(T nuevo) {
        DynamicArray.this.addBeginning(nuevo);
    }

    @Override
    public T desapilar() {
        return DynamicArray.this.getFromBeginning();
    }

    void addBeginning(T newest){
        objects = Arrays.copyOf(objects, objects.length+1);
        //grabs the objects in '0' index and moves them to '1' index. then, in length, how many objects you want to move
        System.arraycopy(objects, 0, objects, 1, objects.length - 1);
        objects[0] = newest;
    }

    void addEnd(T newest){
        objects = Arrays.copyOf(objects, objects.length+1);
        objects[objects.length-1] = newest;
    }

    T getFromEnd(){
        T result = null;
        if (objects.length > 0){
            // in this line you say: for the generic type T, assign to it the last object in the array
            result = objects[objects.length-1];
            //now the last object is in the T type, so we remove it from the array
            objects = Arrays.copyOfRange(objects, 0, objects.length-1);
        }
        return result;
    }

    T getFromBeginning(){
        T result = null;
        if (objects.length > 0){
            //store the first index in the T
            result = objects[0];
            //erase the first index
            objects = Arrays.copyOfRange(objects, 1, objects.length);
        }
        return result;
    }

    void sort(){
        Arrays.sort(objects);
    }

    public String toString(){
        return Arrays.deepToString(objects);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        DynamicArray<Integer> dynArray = new DynamicArray<>(new Integer[0]);

        for(int i = 0; i < 3; i++){
            System.out.println("Enter the number (end) " +(i+1));
            Integer numbers = scanner.nextInt();
            dynArray.addEnd(numbers);
            System.out.println(dynArray);
        }

        for(int i = 0; i < 3; i++){
            System.out.println("Enter the number (beginning) " +(i+1));
            Integer numbers = scanner.nextInt();
            dynArray.addBeginning(numbers);
            System.out.println(dynArray);
        }

        System.out.println("Without sorting the array: " +dynArray);
        dynArray.sort();
        System.out.println("Sorted: " + dynArray);

        Integer integ = dynArray.getFromBeginning();
        System.out.println("Got from the beginning: " +integ);

        Integer integ02 = dynArray.getFromEnd();
        System.out.println("Got from the end: " +integ02);

        Pila<Integer> integ03 = new DynamicArray<>(new Integer[0]);
        System.out.println("Enter positive integer, -1 to exit");
        Integer entered = scanner.nextInt();
        while(entered != -1){
            integ03.apilar(entered);
            System.out.println("Enter positive integer, -1 to exit");
            entered = scanner.nextInt();
        }
        System.out.println("We take out;");
        entered = integ03.desapilar();
        while(entered != null){
            System.out.println(entered+ " ");
            entered = integ03.desapilar();
        }
        System.out.println("");
    }
}
