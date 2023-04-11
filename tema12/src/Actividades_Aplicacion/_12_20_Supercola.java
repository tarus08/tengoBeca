package Actividades_Aplicacion;

import java.util.*;

public class _12_20_Supercola {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Queue<Integer> queue01 = new LinkedList<>();
        Queue<Integer> queue02 = new LinkedList<>();
        List<Integer> listFirstQueue = new ArrayList<Integer>();
        List<Integer> listSecondQueue = new ArrayList<Integer>();


        int choice = 0;
        int delIndex01 = 0;
        int delIndex02 = 0;
        boolean isValidIndex = false;

        do {
            System.out.println("Enter: \n" +
                    "'1' to add a new value to the first queue\n" +
                    "'2' to add a new value to the second queue\n" +
                    "'3' the index to delete an element of the first queue\n" +
                    "'4' the index to delete an element of the second queue\n" +
                    "'5' to exit");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the new value: ");
                    int newValue = scanner.nextInt();
                    queue01.add(newValue);
                    listFirstQueue = new ArrayList<Integer>(queue01);

                    System.out.println("The first queue: " + queue01);
                    System.out.println("The second queue: " + queue02);
                    break;

                case 2:
                    System.out.println("Enter the new value: ");
                    int newValue02 = scanner.nextInt();
                    queue02.add(newValue02);
                    listSecondQueue = new ArrayList<Integer>(queue02);

                    System.out.println("The first queue: " + queue01);
                    System.out.println("The second queue: " + queue02);
                    break;

                case 3:
                    System.out.println("Enter the index to delete from the first queue");
                    delIndex01 = scanner.nextInt();

                    if (listFirstQueue.isEmpty() && listSecondQueue.isEmpty()) {
                        System.out.println("Both queues are empty.");
                        break;
                    }

                    if (delIndex01 >= 0 && delIndex01 < listFirstQueue.size()) {
                        System.out.println("The index entered is valid");
                        listFirstQueue.remove(delIndex01);
                    } else if (delIndex01 >= 0 && delIndex01 < listSecondQueue.size()) {
                        System.out.println("The index entered is valid");
                        listSecondQueue.remove(delIndex01);
                    } else {
                        System.out.println("The index entered is not valid");
                    }

                    System.out.println("The first queue: " + listFirstQueue);
                    System.out.println("The second queue: " + listSecondQueue);
                    break;

                case 4:

                    System.out.println("Enter the index to delete from the second queue");
                    delIndex02 = scanner.nextInt();

                    if (listFirstQueue.isEmpty() && listSecondQueue.isEmpty()) {
                        System.out.println("Both queues are empty.");
                        break;
                    }

                    if (delIndex02 >= 0 && delIndex02 < listSecondQueue.size()) {
                        System.out.println("The index entered is valid");
                        listSecondQueue.remove(delIndex02);
                    } else if (delIndex02 >= 0 && delIndex02 < listFirstQueue.size()) {
                        System.out.println("The index entered is valid");
                        listFirstQueue.remove(delIndex02);
                    } else {
                        System.out.println("The index entered is not valid");
                    }

                    System.out.println("The first queue: " + listFirstQueue);
                    System.out.println("The second queue: " + listSecondQueue);
                    break;

            }
        } while (choice >= 1 && choice < 5) ;
    }
}
