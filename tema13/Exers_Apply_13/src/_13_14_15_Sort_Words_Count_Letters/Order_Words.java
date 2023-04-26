package _13_14_15_Sort_Words_Count_Letters;

import java.util.Arrays;

public class Order_Words {
    public static void main(String[] args) {

        String words = "zebra yate xanax watermelon vacaciones ana carlos bea";
        String [] wordsArray = words.split(" ");

        //if you convert the array to stream directly, it will give the original array, so it wont be sorted
        String [] sortedArray = Arrays.stream(wordsArray)
                .filter(word -> word.length() > 3 )
                .sorted()
                .toArray(String[]::new);
        System.out.println("These are the words with more than 3 letters and ordered alphabetically: " + Arrays.toString(sortedArray));
    }
}
