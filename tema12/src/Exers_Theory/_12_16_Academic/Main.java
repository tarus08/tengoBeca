package Exers_Theory._12_16_Academic;

import java.util.*;
public class Main {
    public static void main(String[] args) {

        Map<Character, Academic> academy = new TreeMap<>();

        for (int i = 0; i < 5; i++) {
            System.out.println("Enter the letter for the academic: ");
            Character letter = new Scanner(System.in).next().charAt(0);
            System.out.println("Enter the name of the academic: ");
            String name = new Scanner(System.in).next();
            System.out.println("Enter the year of admission");
            int yearOfAdmission = new Scanner(System.in).nextInt();
            Academic newAcademic = new Academic(name, yearOfAdmission);
            boolean entered = newAcademic(academy, letter, newAcademic);
            if (!entered) {
                System.out.println("The letter is not valid");
            }
        }

        System.out.println("Ordered by letter: " + academy);

        //pass the values of the map to a list
        List<Academic> listNoLetter = new ArrayList<>(academy.values());
        Collections.sort(listNoLetter);
        System.out.println("By name without letter: " + listNoLetter);
        Comparator<Academic> compareAdmission = new Comparator<>() {
            @Override
            public int compare(Academic o1, Academic o2) {
                return o1.getYearAdmission() - o2.getYearAdmission();
            }
        };

        Collections.sort(listNoLetter, compareAdmission);
        System.out.println("By year without the letter " + listNoLetter);

        //pass the entries (the pairs entered) of the map to a list
        Set<Map.Entry<Character, Academic>> withLetter = academy.entrySet();
        List<Map.Entry<Character, Academic>> listWithLetter = new ArrayList<>(withLetter);
        Collections.sort(listWithLetter, new Comparator<>() {
            @Override
            public int compare(Map.Entry<Character, Academic> o1, Map.Entry<Character, Academic> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        System.out.println("Ordered by name " + listWithLetter);
    }

    //here you are saying: in the map (Map<Character, Academic> academy) enter a new academic (Academic newAcademic) with this letter (Character letter)
    private static boolean newAcademic(Map<Character, Academic> academy, Character letter, Academic newAcademic) {
        boolean entered = false;
        if ((letter >= 'A' && letter <= 'Z') || (letter >= 'a' && letter <= 'z')) {
            academy.put(Character.toUpperCase(letter), newAcademic);
            entered = true;
        } else {
            System.out.println("Invalid letter entered.");
        }
        return entered;
    }
}
