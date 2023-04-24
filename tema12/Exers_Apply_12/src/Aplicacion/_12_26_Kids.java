package Aplicacion;

import java.util.*;

public class _12_26_Kids {
    public static void main(String[] args) {

        List<String> kidsList = new ArrayList<String>();
        kidsList.add("Alice");
        kidsList.add("Bob");
        kidsList.add("Charlie");
        kidsList.add("Dave");
        kidsList.add("Eve");

        List<List<String>> groups = distributeKids(kidsList, 3);
        for (int i = 0; i < groups.size(); i++) {
            System.out.println("Group " + (i + 1) + ": " + groups.get(i));
        }

    }

    public static List<List<String>> distributeKids(List<String> kidsList, int numGroups) {
        // Shuffle the list of kids to assign them randomly
        Collections.shuffle(kidsList);

        // Calculate the number of kids per group
        int kidsPerGroup = (int) Math.ceil((double) kidsList.size() / numGroups);

        // Create a list of empty lists to represent the groups
        List<List<String>> groups = new ArrayList<List<String>>();
        for (int i = 0; i < numGroups; i++) {
            groups.add(new ArrayList<String>());
        }

        // Assign each kid to a group
        int currentGroup = 0;
        for (String kid : kidsList) {
            groups.get(currentGroup).add(kid);
            currentGroup++;
            if (currentGroup >= numGroups) {
                currentGroup = 0;
            }
        }

        return groups;
    }
}
