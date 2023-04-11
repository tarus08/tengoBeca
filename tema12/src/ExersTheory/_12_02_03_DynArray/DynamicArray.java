package ExersTheory._12_02_03_DynArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DynamicArray <T extends Comparable<T>> implements Pila<T> {

    private T[] objects;
    private T[] objects02;
    private T index;
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
    void order(Comparator<T> comparator){
        Arrays.sort(objects, comparator);
    }
    T get(int index){
        return objects[index];
    }
    int[] lookForAll(Object e){
        List<Integer> indexes = new ArrayList<Integer>();
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] != null && objects[i].equals(e)) {
                indexes.add(i);
            }
        }
        int [] result = new int[indexes.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = indexes.get(i);
        }
        return result;
    }

    boolean deleteAll(Object e){
        int count = 0;
        for (int i = 0; i < objects.length; i++) {
            if (objects[i].equals(e)){
                count++;
            }
        }
        if (count > 0){
            objects = Arrays.copyOf(objects, objects.length - count);
            return true;
        }else{
            return false;
        }
    }

    public String toString(){
        return Arrays.deepToString(objects);
    }

}
