import java.util.*;
public class _12_33_Ordered_List<E> {
    private final Set<E> set;
    public _12_33_Ordered_List() {
        this.set = new TreeSet<>();
    }
    public _12_33_Ordered_List(Comparator<E> comparator) {
        this.set = new TreeSet<>(comparator);
    }
    public void add(E element){
        set.add(element);
    }
    public void remove (E element) {
        set.remove(element);
    }
    public boolean contains(E element){
        return set.contains(element);
    }
    public Iterator<E> iterator(){
        return set.iterator();
    }
}
