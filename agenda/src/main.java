import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        agenda[] contacts = new agenda[20];

        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running){
            System.out.println("We have an agenda, insert: \n '1'. To add contacts on it." +
                    " \n '2'. To look for a name. \n '3'. To show all contacts. \n '4'. To " +
                    "exit the menu ");
            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    Functionalities.addContact();
                    break;

                case 2:
                    Functionalities.findContact();
                    break;

                case 3:
                    Functionalities.showContact();
                    break;

                case 4:
                    Functionalities.saveAndExit();
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice, try again");
                    break;
            }
        }
    }
}

