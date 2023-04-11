package Aplicacion._11_20_Cliente;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cliente[] clients = new Cliente[3];
        int choice = 0;

        try (ObjectInputStream reader = new ObjectInputStream(
                new FileInputStream("client.dat"))) {
            clients = (Cliente[]) reader.readObject();
        } catch (Exception e) {
            System.out.println("There was an error reading: " + e.getMessage());
        }

        do {
            System.out.println("Enter 1 to add a new client, 2 to modify the data of a client, "
                    + "3 to delete a client and 4 to show the data of all the clients");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter an id, a name and a phone number for the new client");

                    if (scanner.hasNext()) {
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        String name = scanner.nextLine();
                        int phoneNumber = scanner.nextInt();
                        if (id > 0 && name != null && !name.isEmpty() && name.matches("[a-zA-Z ]+") && phoneNumber > 0) {
                            Cliente newClient = new Cliente(id, name, phoneNumber);
                            for (int i = 0; i < clients.length; i++) {
                                if (clients[i] == null) {
                                    clients[i] = newClient;
                                    System.out.println("New client added at index " + i);
                                    break;
                                }
                            }
                        } else {
                            System.out.println("Enter valid values");
                        }
                    } else {
                        System.out.println("Enter valid values");
                    }
                    break;


                case 2:
                    System.out.println("What client do you want to modify the values of?");
                    int index = scanner.nextInt();

                    System.out.print("Enter the client's ID: ");
                    String id = scanner.next();

                    for (int i = 0; i < clients.length; i++) {
                        if (clients[i] != null) {
                            System.out.println("Client found:");
                            System.out.println(clients[i]);
                            System.out.print("Enter the new ID: ");
                            int newId = scanner.nextInt();
                            clients[index].setId_cliente(newId); // Update the ID field with the new value
                            System.out.println("ID updated successfully!");
                            break;
                        }
                        if (i == clients.length - 1) {
                            System.out.println("Client not found.");
                        }
                    }

                    System.out.println("Enter true to alter the value of name_client, false to leave it as it is");
                    boolean nameClienteModify = scanner.nextBoolean();
                    scanner.nextLine();
                    if (nameClienteModify == true) {
                        System.out.println("Enter the new name");
                        String newNameCliente = scanner.nextLine();
                        if (newNameCliente != null && !newNameCliente.isEmpty()) {
                            clients[index].setNameCliente(newNameCliente);
                        } else {
                            System.out.println("Please enter a valid name");
                        }
                    }else{
                        System.out.println("We wont modify that, it is okay");
                    }

                    System.out.println("Enter true to alter the value of phone_number, false to leave it as it is");
                    boolean phoneNumModify = scanner.nextBoolean();
                    if (phoneNumModify == true) {
                        System.out.println("Enter the new phone number");
                        int newPhoneNum = scanner.nextInt();
                        if (newPhoneNum > 0) {
                            clients[index].setPhoneNumber(newPhoneNum);
                        } else {
                            System.out.println("Enter a valid phone number");
                        }
                    }else{
                        System.out.println("We wont modify that, it is okay");
                    }

                    break;

                case 3:
                    System.out.println("Enter the index of the client you want to delete");
                    int delIndex = scanner.nextInt();
                    if (delIndex >= 0 && delIndex < clients.length && clients[delIndex] != null) {
                        clients[delIndex] = null;
                        System.out.println("Client deleted successfully");
                    } else {
                        System.out.println("Enter a valid index");
                    }
                    break;

                case 4:
                    for (Cliente client : clients) {
                        if (client != null) {
                            System.out.println("ID: " + client.getId_cliente() + ", Name: " + client.getName() + ", Phone Number: " + client.getPhoneNumber());
                        }
                    }
                    break;
            }
        }while (choice != 0);
        scanner.close();
        }
        }






