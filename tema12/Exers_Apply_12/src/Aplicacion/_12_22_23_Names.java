package Aplicacion;

import java.util.*;

public class _12_22_23_Names {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Collection<String> namesCollection = new ArrayList<>();
        List<String> namesList = new ArrayList<>();
        String enteredNames = null;
        String end = "end";

        do {
            System.out.println("Enter names, enter 'end' to exit the loop");
            enteredNames = scanner.nextLine();

            if (enteredNames.equals(end)){
                break;
            }
           if (namesCollection.contains(enteredNames)){
               System.out.println("That name is already in the collection");
           }else{
               namesCollection.add(enteredNames);
               namesList = new ArrayList<String>(namesCollection);
               Collections.sort(namesList);
               System.out.println("This is the list of names sorted alphabetically: " + namesList);
           }
        } while (!enteredNames.equals(end));
    }
}
