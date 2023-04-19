package Aplicacion;

import java.util.*;

public class _12_19_Frase_Espacios {
    public static void main(String[] args) {


        List<String> repeatedList = new ArrayList<String>();
        List<String> uniqueList = new ArrayList<String>();
        List<String> wholePhrase = new ArrayList<String>();
        boolean correctPhrase = false;
        int countRepeatedWords = 0;

        System.out.println("Enter a phrase in which there are only words separated by spaces");
        String phrase = new Scanner(System.in).nextLine().trim();

        if (phrase.matches("^[A-Za-z ]*$")) {

            correctPhrase = true;
            wholePhrase.addAll(Arrays.asList(phrase.split(" ")));

            for (String findRepeatedWord : wholePhrase) {
                //if the index of the first occurrence for the word in different than the last, then it is repeated
                if (wholePhrase.indexOf(findRepeatedWord) != wholePhrase.lastIndexOf(findRepeatedWord)) {
                    if (wholePhrase.contains(findRepeatedWord)) {
                        repeatedList.add(findRepeatedWord);
                        countRepeatedWords++;
                    }
                } else {
                    if (!uniqueList.contains(findRepeatedWord)) {
                        uniqueList.add(findRepeatedWord);
                    }
                }
            }

            System.out.println("This is the number of repeated words: " + countRepeatedWords);
            System.out.println("These are the repeated words: " +repeatedList);

            System.out.println("These are the unique words: " +uniqueList);

            } else {
            System.out.println("The phrase is incorrect");
            correctPhrase = false;
        }

        System.out.println("-----------------------------------");
        System.out.println("Another way");
        System.out.println("-----------------------------------");

        System.out.println("Enter a phrase in which there are only words separated by spaces");
        String phrase02 = new Scanner(System.in).nextLine().trim();

        Map<String, Integer> wordCounts = new HashMap<String, Integer>();
        List<String> wholePhrase02 = new ArrayList<>();
        wholePhrase02.addAll(Arrays.asList(phrase02.split(" ")));

        if (phrase02.matches("^[A-Za-z ]*$")) {
            correctPhrase = true;
            wholePhrase.addAll(Arrays.asList(phrase02.split(" ")));

            for (String word02 : wholePhrase02) {
                // Update the count of the word in the map
                wordCounts.put(word02, wordCounts.getOrDefault(word02, 0) + 1);
            }

            // Print the count of each word
            for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
                String word02 = entry.getKey();
                int count = entry.getValue();
                System.out.printf("The word '%s' appears %d times\n", word02, count);
            }

        } else {
            System.out.println("The phrase is incorrect");
            correctPhrase = false;
        }
    }
}
