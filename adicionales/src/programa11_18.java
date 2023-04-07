import java.io.*;
import java.util.*;

public class programa11_18 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> listNames = new ArrayList<String>();
        String enterName;

        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("signatures.dat"))) {
            do {
                System.out.println("Enter names, enter a blank space to get out of the loop");
                enterName = scanner.nextLine();
                if (!enterName.isBlank()) {
                    writer.writeObject(enterName);
                    listNames.add(enterName);
                }
            } while (!enterName.isBlank());
            System.out.println("You entered a blank space to exit the loop.");
        } catch (Exception e) {
            System.out.println("There was an error writing: " + e.getMessage());
        }

        int choice = 0;
        do {
            System.out.println("Now you can enter '1' to add a new name, " +
                    "you can enter '2' to show the names or a negative number to exit the loop");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    try (ObjectOutputStream writer = new ObjectOutputStream(
                            new FileOutputStream("signatures.dat", true))) {
                        do {
                            System.out.println("Enter names, enter a blank space to get out of the loop");
                            enterName = scanner.nextLine();
                            if (!enterName.isBlank()) {
                                writer.writeObject(enterName);
                                listNames.add(enterName);
                            }
                        } while (!enterName.isBlank());
                        System.out.println("You entered a blank space to exit the loop.");

                    } catch (Exception e) {
                        System.out.println("There was an error writing: " + e.getMessage());
                    }
                    break;

                case 2:
                    try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream("signatures.dat"))) {
                        List<String> showNames = new ArrayList<String>();
                        try {
                            while (true) {
                                String name = (String) reader.readObject();
                                showNames.add(name);
                            }
                        } catch (EOFException e) {
                            // end of file
                        }
                        System.out.println("These are the names: " + showNames);
                    } catch (IOException e) {
                        System.out.println("End of file: " + e.getMessage());
                    } catch (ClassNotFoundException e) {
                        System.out.println("Class not found: " + e.getMessage());
                    }
                    break;

                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or a negative number.");
                    break;
            }
        } while (choice >= 0);
        System.out.println("You entered a negative number, the loop ends here");
    }
}
