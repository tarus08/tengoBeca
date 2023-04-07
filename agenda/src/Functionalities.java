import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Functionalities {
    private static agenda [] contacts = new agenda [20];
    private String name = null;

    public static void addContact() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i] == null) {
                System.out.println("Enter a name");
                String name = scanner.nextLine();
                System.out.println("Enter a phone number");
                int phoneNumber = 0;
                    if (scanner.hasNextInt()) {
                    phoneNumber = scanner.nextInt();
                    scanner.nextLine();
                    }else{
                    System.out.println("Invalid phone number");
                }
                        if (name != null && !name.isEmpty() && phoneNumber > 0) {
                    agenda newContact = new agenda(name, phoneNumber);
                    contacts[i] = newContact;
                    return;
                         }else{
                    System.out.println("Enter a valid name");
                    return;
                }
            }else{
                System.out.println("The contact book is full");
            }
        }
    }

    public static void findContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a name");
        String lookForName = scanner.nextLine();
        for (agenda contact : contacts) {
            if (contact != null && contact.getName().contains(lookForName)){
                System.out.println(contact.getName() + " : " +contact.getPhoneNumber() );
            }
        }
    }

    public static void showContact() {
        for (agenda contact : contacts){
            if (contact != null) {
                System.out.println("Name of the contact : " + contact.getName() + " " +
                        "whose number is: " + contact.getPhoneNumber());
            }
        }
    }


    public static void saveAndExit() {
        String file = "agenda.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            for(agenda contact : contacts){
                if (contact != null){
                    writer.write("This is the name of the contact: " +
                            contact.getName()+ " whose phone number is: " +
                            +contact.getPhoneNumber());
                    writer.newLine();
                }
            }
            System.out.println("Contacts saved successfully");
        } catch (IOException e) {
            System.out.println("There was a problem");
            e.getMessage();
        }
    }
}
