import java.io.*;
import java.util.*;

public class _11_16_Names {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String end = "fin";
        List<String> namesList = new ArrayList<String>();
        String inputName;

        try (ObjectOutputStream writer = new ObjectOutputStream(
                new FileOutputStream("namesList.dat"))) {
            do {
                System.out.println("Enter a name");
                inputName = scanner.nextLine();
                if (!inputName.equals(end)) {
                    writer.writeObject(inputName);
                    namesList.add(inputName);
                }
            } while (!inputName.equals(end));

            //order alphabetically
            Collections.sort(namesList);
            System.out.println("Names entered in alphabetical order: " +namesList);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try (ObjectInputStream reader = new ObjectInputStream(
                new FileInputStream("namesList.dat"))) {

            List<String> fileNamesList = new ArrayList<String>();

            //read the list of names in the file
            try {
                while (fileNamesList != null) {
                    String name = (String) reader.readObject();
                    fileNamesList.add(name);
                }
            } catch (EOFException e) {
                System.out.println("End of file " +e.getMessage());
                // End of file reached
            }

            System.out.println("These are the names in the file: " + fileNamesList);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}