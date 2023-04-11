package Actividades_Ampliacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _12_27_Read_String {

    public static void main(String[] args) {

        List<Character> characterList = readString();
        System.out.println(characterList);
    }

    static List<Character> readString() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a phrase: ");
        String phrase = scanner.nextLine();

        List<Character> charList = new ArrayList<Character>();
        if (phrase.isEmpty()) {
            return charList;
        } else {
            for (int i = 0; i < phrase.length(); i++) {
                charList.add(phrase.charAt(i));
            }
        }
        return charList;
    }
}
