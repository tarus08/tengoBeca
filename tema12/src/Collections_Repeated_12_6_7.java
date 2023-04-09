import java.util.*;
//el 7 no esta realmente, pero es una tonteria, creas la coleccion igual que aqui, aniades el 5 en la coleccion y lo quitas -add y -remove 5
public class Collections_Repeated_12_6_7 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Collection<Integer> numberList = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            numberList.add((int) (Math.random() * 10 + 1));
        }

        System.out.println("The original collection" +numberList);

        System.out.println("Enter the number to erease from the collection");
        Integer notAllowed = scanner.nextInt();
        //you can also use Integer.valueOf(5) to delete the number 5 if it appears

        while(numberList.contains(notAllowed)){
            numberList.remove(notAllowed);
        }

        System.out.println("The collection with the number " +notAllowed+ " deleted: " + numberList) ;

        System.out.println(" ------------------------------\nAnother way\n--------------------");
        HashSet<Integer> hashSet = new HashSet<Integer>();
        hashSet.remove(notAllowed);
        Collection<Integer> modifiedCollection = new ArrayList<Integer>();
        System.out.println("The collection with the number " +notAllowed+ " deleted: " + numberList) ;


        System.out.println(" ------------------------------\nAnother way\n--------------------");
        Iterator<Integer> iterator = numberList.iterator();
        while (iterator.hasNext()){
            Integer num = iterator.next();
            //you can also use contains
            if (numberList.equals(notAllowed)){
                iterator.remove();
            }
        }

    }
}
